package com.retexspa.xr.ms.masterdata.main.query.services;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.AtecoFilter;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.TassonomiaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.TassonomiaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.TassonomiaListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.TassonomieResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.TassonomiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.TassonomiaQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.TassonomiaRepository;

@Service
public class TassonomiaQueryServiceImpl implements TassonomiaQueryService {

  @Autowired private TassonomiaRepository tassonomiaRepository;

  @Autowired private TassonomiaQueryMapper tassonomiaQueryMapper;
  @PersistenceContext private EntityManager entityManager;

  public TassonomiaQueryServiceImpl( TassonomiaRepository tassonomiaRepository) {
    this.tassonomiaRepository = tassonomiaRepository;
  }

  @Override
  public TassonomieResponse listTassonomia(TassonomiaListQuery query) {
    TassonomieResponse tassonomieResponse = new TassonomieResponse();
    Page<TassonomiaQueryEntity> page =
        this.tassonomiaRepository.findAll(PageRequest.of(query.getPage(), query.getLimit()));
    List<TassonomiaQueryDTO> list =
        page.getContent().stream()
            // .map(entity -> modelMapper.map(entity, TassonomiaQueryDTO.class))
            .map(entity -> tassonomiaQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    tassonomieResponse.setRecords(list);
    tassonomieResponse.setPagination(Pagination.buildPagination(page));
    return tassonomieResponse;
  }

  /*@Override
  public TassonomiaQueryDTO getTassonomiaById(TassonomiaByIdQuery query) {
    TassonomiaQueryEntity tassonomiaQueryEntity =
        this.tassonomiaRepository.findById(query.getTassonomiaId()).get();
    TassonomiaQueryDTO tassonomiaQueryDTO = tassonomiaQueryMapper.toDTO(tassonomiaQueryEntity);
    return tassonomiaQueryDTO;
  }*/

  @Override
  public Page<TassonomiaQueryEntity> searchQueryTassonomia(GenericSearchRequest<TassonomiaFilter> query) {

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

          case "tipoTassonomiaId":
            break;

          case "gerarchiaId":
            break;

          case "nodoId":
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

    List<Specification<TassonomiaQueryEntity>> specifications = new ArrayList<>();
    TassonomiaFilter filter = TassonomiaFilter.createFilterFromMap(query.getFilter());

    if (filter.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
    }

    if (filter.getCodice() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("codice")), "%" + filter.getCodice().toUpperCase() + "%"));
    }

    if (filter.getDescrizione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("descrizione")), "%" + filter.getDescrizione().toUpperCase() + "%"));
    }
    if (filter.getNome() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
    }
    if (filter.getTipoTassonomiaId() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("tipoTassonomia").get("id")),
                  "%" + filter.getTipoTassonomiaId().toUpperCase() + "%"));
    }
    if (filter.getNodoId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("nodo").get("id"), filter.getNodoId()));
    }
    if (filter.getPadreId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("padre").get("id"), filter.getPadreId()));
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
            Subquery<TassonomiaQueryEntity> subquery =
                criteriaQuery.subquery(TassonomiaQueryEntity.class);
            Root<TassonomiaQueryEntity> subRoot = subquery.from(TassonomiaQueryEntity.class);

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

    Specification<TassonomiaQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<TassonomiaQueryEntity> page = this.tassonomiaRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public TassonomieResponse searchTassonomia(GenericSearchRequest<TassonomiaFilter>  query) {
    Page<TassonomiaQueryEntity> page = searchQueryTassonomia(query);
    TassonomieResponse tassonomiaResponse = new TassonomieResponse();
    List<TassonomiaQueryDTO> list =
        page.getContent().stream()
            .map(entity -> tassonomiaQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    tassonomiaResponse.setRecords(list);

    tassonomiaResponse.setPagination(Pagination.buildPagination(page));

    return tassonomiaResponse;
  }
}
