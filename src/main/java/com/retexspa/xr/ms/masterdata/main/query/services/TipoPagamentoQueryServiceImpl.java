package com.retexspa.xr.ms.masterdata.main.query.services;


import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.TipoPagamentoQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.TipoPagamentoByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.TipoPagamentoResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.TipoPagamentoSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.TipoPagamentoQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.TipoPagamentoQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.TipoPagamentoRepository;
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
public class TipoPagamentoQueryServiceImpl implements TipoPagamentoQueryService {
  TipoPagamentoRepository tipoPagamentoRepository;
  TipoPagamentoQueryMapper tipoPagamentoQueryMapper;
  @PersistenceContext private EntityManager entityManager;

  public TipoPagamentoQueryServiceImpl(
      TipoPagamentoRepository tipoPagamentoRepository,
      TipoPagamentoQueryMapper tipoPagamentoQueryMapper) {
    this.tipoPagamentoRepository = tipoPagamentoRepository;
    this.tipoPagamentoQueryMapper = tipoPagamentoQueryMapper;
  }

  @Override
  public TipoPagamentoQueryDTO getTipoPagamentoById(TipoPagamentoByIdQuery query) {
    TipoPagamentoQueryEntity tipoPagamentoQueryEntity =
        this.tipoPagamentoRepository.findById(query.getTipoPagamentoId()).orElse(null);

    return tipoPagamentoQueryMapper.toDTO(tipoPagamentoQueryEntity);
  }

  @Override
  public Page<TipoPagamentoQueryEntity> searchQueryTipoPagamento(TipoPagamentoSearchRequest query) {
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

          case "indicatoreFts":
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

    List<Specification<TipoPagamentoQueryEntity>> specifications = new ArrayList<>();

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
    if (query.getIndicatoreFts() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("indicatoreFts")),
                  "%" + query.getIndicatoreFts().toUpperCase() + "%"));
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
            Subquery<TipoPagamentoQueryEntity> subquery =
                criteriaQuery.subquery(TipoPagamentoQueryEntity.class);
            Root<TipoPagamentoQueryEntity> subRoot = subquery.from(TipoPagamentoQueryEntity.class);

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

    Specification<TipoPagamentoQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<TipoPagamentoQueryEntity> page =
        this.tipoPagamentoRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public TipoPagamentoResponse searchTipoPagamento(TipoPagamentoSearchRequest query) {

    TipoPagamentoResponse tipoPagamentoResponse = new TipoPagamentoResponse();
    Page<TipoPagamentoQueryEntity> page = searchQueryTipoPagamento(query);
    List<TipoPagamentoQueryDTO> list =
        page.getContent().stream()
            .map(entity -> tipoPagamentoQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    tipoPagamentoResponse.setRecords(list);

    tipoPagamentoResponse.setPagination(Pagination.buildPagination(page));

    return tipoPagamentoResponse;
  }
}
