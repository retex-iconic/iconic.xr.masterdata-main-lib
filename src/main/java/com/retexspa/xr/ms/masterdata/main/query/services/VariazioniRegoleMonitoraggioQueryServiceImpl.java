package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.VariazioniRegoleMonitoraggioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.responses.VariazioniRegoleMonitoraggioResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.VariazioniRegoleMonitoraggioSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniRegoleMonitoraggioQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.VariazioniRegoleMonitoraggioQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.VariazioniRegoleMonitoraggioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class VariazioniRegoleMonitoraggioQueryServiceImpl
    implements VariazioniRegoleMonitoraggioQueryService {
  VariazioniRegoleMonitoraggioRepository variazioniRegoleMonitoraggioRepository;
  @Autowired VariazioniRegoleMonitoraggioQueryMapper variazioniRegoleMonitoraggioQueryMapper;
  @PersistenceContext private EntityManager entityManager;

  public VariazioniRegoleMonitoraggioQueryServiceImpl(
      VariazioniRegoleMonitoraggioRepository variazioniRegoleMonitoraggioRepository) {
    this.variazioniRegoleMonitoraggioRepository = variazioniRegoleMonitoraggioRepository;
  }

  @Override
  public Page<VariazioniRegoleMonitoraggioQueryEntity> searchQueryVariazioniRegoleMonitoraggio(
      VariazioniRegoleMonitoraggioSearchRequest query) {
    // public VariazioniRegoleMonitoraggioResponse
    // searchVariazioniRegole(VariazioniRegoleMonitoraggioSearchRequest query) {
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

          case "schema":
            break;

          case "nomeTabella":
            break;

          case "nomeCampo":
            break;

          case "regolaConfronto":
            break;

          case "variazioniCausaliId":
            break;

          case "flgSalva":
            break;

          case "flgSalvaCancellazione":
            break;

          case "flgAttiva":
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

    List<Specification<VariazioniRegoleMonitoraggioQueryEntity>> specifications = new ArrayList<>();

    if (query.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
    }
    if (query.getCodice() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("codice"), query.getCodice()));
    }
    if (query.getNome() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + query.getNome().toUpperCase() + "%"));
    }
    if (query.getDescrizione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("descrizione")), "%" + query.getDescrizione().toUpperCase() + "%"));
    }
    if (query.getSchema() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("schema")), "%" + query.getSchema().toUpperCase() + "%"));
    }
    if (query.getNomeTabella() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("nomeTabella")), "%" + query.getNomeTabella().toUpperCase() + "%"));
    }
    if (query.getNomeCampo() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("nomeCampo")), "%" + query.getNomeCampo().toUpperCase() + "%"));
    }
    if (query.getRegolaConfronto() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("regolaConfronto")),
                  "%" + query.getRegolaConfronto().toUpperCase() + "%"));
    }
    if (query.getFlgSalva() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("flgSalva")), "%" + query.getFlgSalva().toUpperCase() + "%"));
    }
    if (query.getFlgSalvaCancellazione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("flgSalvaCancellazione")),
                  "%" + query.getFlgSalvaCancellazione().toUpperCase() + "%"));
    }
    if (query.getFlgAttiva() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("flgAttiva")), "%" + query.getFlgAttiva().toUpperCase() + "%"));
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
            Subquery<VariazioniRegoleMonitoraggioQueryEntity> subquery =
                criteriaQuery.subquery(VariazioniRegoleMonitoraggioQueryEntity.class);
            Root<VariazioniRegoleMonitoraggioQueryEntity> subRoot =
                subquery.from(VariazioniRegoleMonitoraggioQueryEntity.class);

            subquery.select(subRoot);
            subquery.where(
                criteriaBuilder.and(
                    criteriaBuilder.equal(subRoot.get("padre").get("id"), root.get("id")),
                    subRoot.get("gerarchia").get("id").in(hierarchiaRootsIds)));
            return criteriaBuilder.and(
                criteriaBuilder.not(criteriaBuilder.exists(subquery)),
                root.get("gerarchia").get("id").in(hierarchiaRootsIds));
          });
    }

    if (query.getVariazioniCausaliId() != null) {
      specifications.add(
          (r, q, c) ->
              c.equal(r.get("variazioniCausali").get("id"), query.getVariazioniCausaliId()));
    }

    Specification<VariazioniRegoleMonitoraggioQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<VariazioniRegoleMonitoraggioQueryEntity> page =
        this.variazioniRegoleMonitoraggioRepository.findAll(specification, pageable);

    VariazioniRegoleMonitoraggioResponse variazioniRegoleResponse =
        new VariazioniRegoleMonitoraggioResponse();

    variazioniRegoleResponse.setPagination(Pagination.buildPagination(page));

    List<VariazioniRegoleMonitoraggioQueryDTO> list =
        page.getContent().stream()
            .map(entity -> variazioniRegoleMonitoraggioQueryMapper.toDTO(entity))
            .collect(Collectors.toList());

    variazioniRegoleResponse.setRecords(list);

    return page;
  }

  @Override
  public VariazioniRegoleMonitoraggioResponse searchVariazioniRegole(
      VariazioniRegoleMonitoraggioSearchRequest query) {

    VariazioniRegoleMonitoraggioResponse variazioniRegoleMonitoraggioResponse =
        new VariazioniRegoleMonitoraggioResponse();
    Page<VariazioniRegoleMonitoraggioQueryEntity> page =
        searchQueryVariazioniRegoleMonitoraggio(query);
    variazioniRegoleMonitoraggioResponse.setPagination(Pagination.buildPagination(page));
    List<VariazioniRegoleMonitoraggioQueryDTO> list =
        page.getContent().stream()
            .map(entity -> variazioniRegoleMonitoraggioQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    variazioniRegoleMonitoraggioResponse.setRecords(list);
    return variazioniRegoleMonitoraggioResponse;
  }
}
