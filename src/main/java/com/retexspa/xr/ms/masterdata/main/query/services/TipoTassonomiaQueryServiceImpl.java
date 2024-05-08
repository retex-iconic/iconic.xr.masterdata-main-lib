package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.TipoTassonomiaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.responses.TipoTassonomiaResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.TipoTassonomiaSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.TipoTassonomiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.TipoTassonomiaQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.TipoTassonomiaRepository;
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
public class TipoTassonomiaQueryServiceImpl implements TipoTassonomiaQueryService {

  TipoTassonomiaRepository tipoTassonomiaRepository;

  @Autowired TipoTassonomiaQueryMapper tipoTassonomiaQueryMapper;
  @PersistenceContext private EntityManager entityManager;

  TipoTassonomiaQueryServiceImpl(TipoTassonomiaRepository tipoTassonomiaRepository) {
    this.tipoTassonomiaRepository = tipoTassonomiaRepository;
  }

  @Override
  public Page<TipoTassonomiaQueryEntity> searchQueryTipoTassonomia(
      TipoTassonomiaSearchRequest query) {
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

          case "gruppoTassonomia":
            break;

          case "flgNonCancellabile":
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

    List<Specification<TipoTassonomiaQueryEntity>> specifications = new ArrayList<>();

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
    if (query.getGruppoTassonomia() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("gruppoTassonomia")),
                  "%" + query.getGruppoTassonomia().toUpperCase() + "%"));
    }
    if (query.getFlgNonCancellabile() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("flgNonCancellabile")),
                  "%" + query.getFlgNonCancellabile().toUpperCase() + "%"));
    }
    if (query.getNodoId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("nodo").get("id"), query.getNodoId()));
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
            Subquery<TipoTassonomiaQueryEntity> subquery =
                criteriaQuery.subquery(TipoTassonomiaQueryEntity.class);
            Root<TipoTassonomiaQueryEntity> subRoot =
                subquery.from(TipoTassonomiaQueryEntity.class);

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

    Specification<TipoTassonomiaQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<TipoTassonomiaQueryEntity> page =
        this.tipoTassonomiaRepository.findAll(specification, pageable);

    return page;
  }

  @Override
  public TipoTassonomiaResponse searchTipoTassonomia(TipoTassonomiaSearchRequest query) {
    Page<TipoTassonomiaQueryEntity> page = searchQueryTipoTassonomia(query);
    TipoTassonomiaResponse tipoTassonomiaResponse = new TipoTassonomiaResponse();
    List<TipoTassonomiaQueryDTO> list =
        page.getContent().stream()
            .map(entity -> tipoTassonomiaQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    tipoTassonomiaResponse.setRecords(list);

    tipoTassonomiaResponse.setPagination(Pagination.buildPagination(page));

    return tipoTassonomiaResponse;
  }
}
