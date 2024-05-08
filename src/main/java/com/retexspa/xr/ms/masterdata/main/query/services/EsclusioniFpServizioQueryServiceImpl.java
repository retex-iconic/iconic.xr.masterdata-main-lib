package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.EsclusioniFpServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.EsclusioniFpServizioAggregateGetByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.EsclusioniFpServizioListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.EsclusioniFpServizioResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.EsclusioniFpServizioSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.EsclusioniFpServizioQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.EsclusioniFpServizioQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.EsclusioniFpServizioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class EsclusioniFpServizioQueryServiceImpl implements EsclusioniFpServizioQueryService {

  @Autowired private EsclusioniFpServizioRepository esclusioniFpServizioRepository;

  @Autowired private EsclusioniFpServizioQueryMapper esclusioniFpServizioQueryMapper;

  @PersistenceContext EntityManager entityManager;

  QueryGateway queryGateway;

  public EsclusioniFpServizioQueryServiceImpl(
      QueryGateway queryGateway, EsclusioniFpServizioRepository esclusioniFpServizioRepository) {
    this.queryGateway = queryGateway;
    this.esclusioniFpServizioRepository = esclusioniFpServizioRepository;
  }

  @Override
  public EsclusioniFpServizioResponse listEsclusioniFpServizio(
      EsclusioniFpServizioListQuery query) {

    EsclusioniFpServizioResponse esclusioniFpServizioResponse = new EsclusioniFpServizioResponse();

    Page<EsclusioniFpServizioQueryEntity> page =
        this.esclusioniFpServizioRepository.findAll(
            PageRequest.of(query.getPage(), query.getLimit()));

    List<EsclusioniFpServizioQueryDTO> list =
        page.getContent().stream()
            .map(entity -> esclusioniFpServizioQueryMapper.toDTO(entity))
            .collect(Collectors.toList());

    esclusioniFpServizioResponse.setRecords(list);

    esclusioniFpServizioResponse.setPagination(Pagination.buildPagination(page));

    return esclusioniFpServizioResponse;
  }

  @Override
  public EsclusioniFpServizioResponse searchEsclusioniFpServizio(
      EsclusioniFpServizioSearchRequest query) {

    List<Sort.Order> sorts = new ArrayList<>();

    if (query.getSort() != null && query.getSort().size() != 0) {
      for (BaseSort baseSort : query.getSort()) {
        switch (baseSort.getOrderBy()) {
          case "id":
            break;

          case "codice":
            break;

          case "descSegnalazione":
            break;

          case "flgSegnalazione":
            break;

          case "massimaleCumulativo":
            break;

          case "massimaleSingolo":
            break;

          case "formaPagamentoId":
            break;
          case "servizioId":
            break;
          case "gerarchiaId":
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

    List<Specification<EsclusioniFpServizioQueryEntity>> specifications = new ArrayList<>();

    if (query.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
    }

    if (query.getCodice() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("codice")), "%" + query.getCodice().toUpperCase() + "%"));
    }

    if (query.getDescSegnalazione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("descSegnalazione")),
                  "%" + query.getDescSegnalazione().toUpperCase() + "%"));
    }
    if (query.getFlgSegnalazione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("flgSegnalazione")),
                  "%" + query.getFlgSegnalazione().toUpperCase() + "%"));
    }
    if (query.getMassimaleCumulativo() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("massimaleCumulativo"), query.getMassimaleCumulativo()));
    }
    if (query.getMassimaleSingolo() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("massimaleSingolo"), query.getMassimaleSingolo()));
    }
    if (query.getFormaPagamentoId() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("formaPagamento").get("id"), query.getFormaPagamentoId()));
    }
    if (query.getServizioId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("servizio").get("id"), query.getServizioId()));
    }

    if (query.getGerarchiaId() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("gerarchia").get("id"), query.getGerarchiaId()));
    }
    if (query.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), query.getVersion()));
    }

    Specification<EsclusioniFpServizioQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<EsclusioniFpServizioQueryEntity> page =
        this.esclusioniFpServizioRepository.findAll(specification, pageable);

    EsclusioniFpServizioResponse esclusioniFpServizioResponse = new EsclusioniFpServizioResponse();
    List<EsclusioniFpServizioQueryDTO> list =
        page.getContent().stream()
            .map(entity -> esclusioniFpServizioQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    esclusioniFpServizioResponse.setRecords(list);

    esclusioniFpServizioResponse.setPagination(Pagination.buildPagination(page));

    return esclusioniFpServizioResponse;
  }

  @Override
  public EsclusioniFpServizioQueryDTO getEsclusioniFpServizioById(
      EsclusioniFpServizioAggregateGetByIdQuery query) {

    EsclusioniFpServizioQueryEntity esclusioniFpServizioQueryEntity =
        this.esclusioniFpServizioRepository
            .findById(query.getEsclusioniFpServizioId())
            .orElse(null);

    return esclusioniFpServizioQueryMapper.toDTO(esclusioniFpServizioQueryEntity);
  }

  @Override
  public Page<EsclusioniFpServizioQueryEntity> searchQueryEsclusioniFpServizio(
      EsclusioniFpServizioSearchRequest query) {
    List<Sort.Order> sorts = new ArrayList<>();

    if (query.getSort() != null && query.getSort().size() != 0) {
      for (BaseSort baseSort : query.getSort()) {
        switch (baseSort.getOrderBy()) {
          case "id":
            break;

          case "codice":
            break;

          case "descSegnalazione":
            break;

          case "flgSegnalazione":
            break;

          case "massimaleCumulativo":
            break;

          case "massimaleSingolo":
            break;

          case "formaPagamentoId":
            break;
          case "servizioId":
            break;
          case "gerarchiaId":
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

    List<Specification<EsclusioniFpServizioQueryEntity>> specifications = new ArrayList<>();

    if (query.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
    }

    if (query.getCodice() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("codice")), "%" + query.getCodice().toUpperCase() + "%"));
    }

    if (query.getDescSegnalazione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("descSegnalazione")),
                  "%" + query.getDescSegnalazione().toUpperCase() + "%"));
    }
    if (query.getFlgSegnalazione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("flgSegnalazione")),
                  "%" + query.getFlgSegnalazione().toUpperCase() + "%"));
    }
    if (query.getMassimaleCumulativo() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("massimaleCumulativo"), query.getMassimaleCumulativo()));
    }
    if (query.getMassimaleSingolo() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("massimaleSingolo"), query.getMassimaleSingolo()));
    }
    if (query.getFormaPagamentoId() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("formaPagamento").get("id"), query.getFormaPagamentoId()));
    }
    if (query.getServizioId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("servizio").get("id"), query.getServizioId()));
    }

    if (query.getGerarchiaId() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("gerarchia").get("id"), query.getGerarchiaId()));
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
            Subquery<EsclusioniFpServizioQueryEntity> subquery =
                criteriaQuery.subquery(EsclusioniFpServizioQueryEntity.class);
            Root<EsclusioniFpServizioQueryEntity> subRoot =
                subquery.from(EsclusioniFpServizioQueryEntity.class);

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
    // }

    Specification<EsclusioniFpServizioQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<EsclusioniFpServizioQueryEntity> page =
        this.esclusioniFpServizioRepository.findAll(specification, pageable);
    return page;
  }
}
