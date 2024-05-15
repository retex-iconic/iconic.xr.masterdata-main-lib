package com.retexspa.xr.ms.masterdata.main.query.services;

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

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.TipologiaServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.TipologiaServizioByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.TipologiaServizioListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.TipologiaServizioResponse;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.TipologiaServizioFilter;
import com.retexspa.xr.ms.masterdata.main.query.entities.TipologiaServizioQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.TipologiaServizioQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.TipologiaServizioRepository;

@Service
public class TipologiaServizioQueryServiceImpl implements TipologiaServizioQueryService {

  @Autowired private TipologiaServizioRepository tipologiaServizioRepository;

  @Autowired private TipologiaServizioQueryMapper tipologiaServizioQueryMapper;

  @PersistenceContext EntityManager entityManager;



  public TipologiaServizioQueryServiceImpl( TipologiaServizioRepository tipologiaServizioRepository) {
    this.tipologiaServizioRepository = tipologiaServizioRepository;
  }

  @Override
  public TipologiaServizioResponse listTipologiaServizio(TipologiaServizioListQuery query) {

    TipologiaServizioResponse tipologiaServizioResponse = new TipologiaServizioResponse();

    Page<TipologiaServizioQueryEntity> page =
        this.tipologiaServizioRepository.findAll(PageRequest.of(query.getPage(), query.getLimit()));

    List<TipologiaServizioQueryDTO> list =
        page.getContent().stream()
            .map(entity -> tipologiaServizioQueryMapper.toDTO(entity))
            .collect(Collectors.toList());

    tipologiaServizioResponse.setRecords(list);

    tipologiaServizioResponse.setPagination(Pagination.buildPagination(page));

    return tipologiaServizioResponse;
  }

  @Override
  public Page<TipologiaServizioQueryEntity> searchQueryTipologiaServizio(
      GenericSearchRequest<TipologiaServizioFilter> query) {

    List<Sort.Order> sorts = new ArrayList<>();

    if (query.getSort() != null && query.getSort().size() != 0) {
      for (BaseSort baseSort : query.getSort()) {
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

    List<Specification<TipologiaServizioQueryEntity>> specifications = new ArrayList<>();

    TipologiaServizioFilter filter = TipologiaServizioFilter.createFilterFromMap(query.getFilter());

    if (filter.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
    }

    if (filter.getCodice() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("codice")), "%" + filter.getCodice().toUpperCase() + "%"));
    }

    if (filter.getNome() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
    }

    if (filter.getDescrizione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("descrizione")), "%" + filter.getDescrizione().toUpperCase() + "%"));
    }
    if (filter.getNumMaxInScontrino() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("numMaxInScontrino"), filter.getNumMaxInScontrino()));
    }
    if (filter.getValMaxInScontrino() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("valMaxInScontrino"), filter.getValMaxInScontrino()));
    }
    if (filter.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
    }

    NativeQueryHelper NativeQueryHelper = new NativeQueryHelper();
    if (filter.getGerarchiaId() != null) {
      String gerarchNativeQuery = NativeQueryHelper.gerarchiaNativeQuery();
      Query hierarchiaRoots =
          entityManager
              .createNativeQuery(gerarchNativeQuery)
              .setParameter("gerarchiaid", filter.getGerarchiaId());
      List<String> hierarchiaRootsIds = hierarchiaRoots.getResultList();

      specifications.add(
          (root, criteriaQuery, criteriaBuilder) -> {
            // Define the subquery
            Subquery<TipologiaServizioQueryEntity> subquery =
                criteriaQuery.subquery(TipologiaServizioQueryEntity.class);
            Root<TipologiaServizioQueryEntity> subRoot =
                subquery.from(TipologiaServizioQueryEntity.class);

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

    Specification<TipologiaServizioQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);
    Page<TipologiaServizioQueryEntity> page =
        this.tipologiaServizioRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public TipologiaServizioResponse searchTipologiaServizio(GenericSearchRequest<TipologiaServizioFilter> query) {
    Page<TipologiaServizioQueryEntity> page = searchQueryTipologiaServizio(query);
    TipologiaServizioResponse TipologiaServizioResponse = new TipologiaServizioResponse();

    List<TipologiaServizioQueryDTO> list =
        page.getContent().stream()
            .map(entity -> tipologiaServizioQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    TipologiaServizioResponse.setRecords(list);
    TipologiaServizioResponse.setPagination(Pagination.buildPagination(page));
    return TipologiaServizioResponse;
  }

  @Override
  public TipologiaServizioQueryDTO getTipologiaServizioById(TipologiaServizioByIdQuery query) {

    TipologiaServizioQueryEntity tipologiaServizioQueryEntity =
        this.tipologiaServizioRepository.findById(query.getTipologiaServizioId()).orElse(null);

    return tipologiaServizioQueryMapper.toDTO(tipologiaServizioQueryEntity);
  }
}
