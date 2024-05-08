package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.FormaPagamentoQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.FormaPagamentoByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.FormaPagamentoResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.FormaPagamentoSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.FormaPagamentoQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.FormaPagamentoQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.FormaPagamentoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FormaPagamentoQueryServiceImpl implements FormaPagamentoQueryService {
  FormaPagamentoRepository formaPagamentoRepository;
  FormaPagamentoQueryMapper formaPagamentoQueryMapper;
  @PersistenceContext private EntityManager entityManager;

  public FormaPagamentoQueryServiceImpl(
      FormaPagamentoRepository formaPagamentoRepository,
      FormaPagamentoQueryMapper formaPagamentoQueryMapper) {
    this.formaPagamentoRepository = formaPagamentoRepository;
    this.formaPagamentoQueryMapper = formaPagamentoQueryMapper;
  }

  @Override
  public FormaPagamentoQueryDTO getFormaPagamentoById(FormaPagamentoByIdQuery query) {
    FormaPagamentoQueryEntity formaPagamentoQueryEntity =
        this.formaPagamentoRepository.findById(query.getFormaPagamentoId()).orElse(null);

    return formaPagamentoQueryMapper.toDTO(formaPagamentoQueryEntity);
  }

  @Override
  public Page<FormaPagamentoQueryEntity> searchQueryFormaPagamento(
      FormaPagamentoSearchRequest query) {
    List<Sort.Order> sorts = new ArrayList<>();

    if (query.getSort() != null && query.getSort().size() != 0) {
      for (BaseSort baseSort : query.getSort()) {
        switch (baseSort.getOrderBy()) {
          case "id":
            break;

          case "codice":
            break;

          case "nome":
            break;

          case "descrizione":
            break;

          case "flgAttivo":
            break;

          case "tipoPagamentoId":
            break;

          case "gerarchiaId":
            break;

          case "padreId":
            break;

          case "version":
            break;
          default:
            throw new IllegalArgumentException("Order by is not correct");
        }
        sorts.add(
            new Sort.Order(
                baseSort.getOrderType() != null
                    ? baseSort.getOrderType().equalsIgnoreCase("ASC")
                        ? Sort.Direction.ASC
                        : Sort.Direction.DESC
                    : Sort.Direction.ASC,
                baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "codice"));
      }
    }

    if (sorts.size() == 0) {
      sorts.add(new Sort.Order(Sort.Direction.ASC, "codice"));
    }

    Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

    List<Specification<FormaPagamentoQueryEntity>> specifications = new ArrayList<>();

    if (query.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
    }

    if (query.getCodice() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("codice")), "%" + query.getCodice().toUpperCase() + "%"));
    }

    if (query.getDescrizione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("descrizione")), "%" + query.getDescrizione().toUpperCase() + "%"));
    }
    if (query.getNome() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + query.getNome().toUpperCase() + "%"));
    }
    if (query.getFlgAttivo() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("flgAttivo")), "%" + query.getFlgAttivo().toUpperCase() + "%"));
    }
    if (query.getTipoPagamentoId() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("tipoPagamento").get("id"), query.getTipoPagamentoId()));
    }
    if (query.getPadreId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("padre").get("id"), query.getPadreId()));
    }
    if (query.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), query.getVersion()));
    }
    NativeQueryHelper NativeQueryHelper = new NativeQueryHelper();

    if (query.getGerarchiaId() != null) {
      String gerarchNativeQuery = NativeQueryHelper.gerarchiaNativeQuery();
      Query hierarchiaRoots =
          entityManager
              .createNativeQuery(gerarchNativeQuery)
              .setParameter("gerarchiaid", query.getGerarchiaId());
      List<String> hierarchiaRootsIds = hierarchiaRoots.getResultList();

      specifications.add(
          (root, criteriaQuery, criteriaBuilder) -> {
            // Define the subquery
            Subquery<FormaPagamentoQueryEntity> subquery =
                criteriaQuery.subquery(FormaPagamentoQueryEntity.class);
            Root<FormaPagamentoQueryEntity> subRoot =
                subquery.from(FormaPagamentoQueryEntity.class);

            subquery.select(subRoot);
            subquery.where(
                criteriaBuilder.and(
                    criteriaBuilder.equal(subRoot.get("padre").get("id"), root.get("id")),
                    subRoot.get("gerarchia").get("id").in(hierarchiaRootsIds)));
            // Integrate the subquery into the main query using criteriaBuilder
            return criteriaBuilder.and(
                criteriaBuilder.not(criteriaBuilder.exists(subquery)),
                root.get("gerarchia").get("id").in(hierarchiaRootsIds));
          });
    }

    Specification<FormaPagamentoQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<FormaPagamentoQueryEntity> page =
        this.formaPagamentoRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public FormaPagamentoResponse searchFormaPagamento(FormaPagamentoSearchRequest query) {

    FormaPagamentoResponse formaPagamentoResponse = new FormaPagamentoResponse();
    Page<FormaPagamentoQueryEntity> page = searchQueryFormaPagamento(query);
    List<FormaPagamentoQueryDTO> list =
        page.getContent().stream()
            .map(entity -> formaPagamentoQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    formaPagamentoResponse.setRecords(list);
    formaPagamentoResponse.setPagination(Pagination.buildPagination(page));
    return formaPagamentoResponse;
  }
}
