package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.ArticoliByGerarchiaIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.ArticoloListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoliResponse;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.ArticoloFilter;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.ArticoloQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.ArticoloRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ArticoloQueryServiceImpl implements ArticoloQueryService {

  @Autowired private ArticoloRepository articoloRepository;

  @Autowired ArticoloQueryMapper articoloQueryMapper;

  @PersistenceContext private EntityManager entityManager;

  @Override
  public ArticoliResponse listArticolo(ArticoloListQuery query) {
    ArticoliResponse articoliResponse = new ArticoliResponse();
    Page<ArticoloQueryEntity> page =
        this.articoloRepository.findAll(PageRequest.of(query.getPage(), query.getLimit()));
    List<ArticoloQueryDTO> list =
        page.getContent().stream()
            .map(entity -> articoloQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    articoliResponse.setRecords(list);
    articoliResponse.setPagination(Pagination.buildPagination(page));
    return articoliResponse;
  }

  @Override
  public Page<ArticoloQueryEntity> searchQueryArticolo(GenericSearchRequest<ArticoloFilter> query) {

    List<Sort.Order> sorts = new ArrayList<>();

    if (query.getSort() != null && query.getSort().size() != 0) {
      for (BaseSort baseSort : query.getSort()) {
        switch (baseSort.getOrderBy()) {
          case "id":
            break;

          case "codice":
            break;

          case "dataCancellazione":
            break;

          case "descrizione":
            break;

          case "flgCancellato":
            break;

          case "gerarchiaId":
            break;

          case "nome":
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

    List<Specification<ArticoloQueryEntity>> specifications = new ArrayList<>();

    ArticoloFilter filter = ArticoloFilter.createFilterFromMap(query.getFilter());


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
    if (filter.getDataCancellazione() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("dataCancellazione"), filter.getDataCancellazione()));
    }
    if (filter.getFlgCancellato() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("flgCancellato")),
                  "%" + filter.getFlgCancellato().toUpperCase() + "%"));
    }
    if (filter.getNome() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
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
            Subquery<ArticoloQueryEntity> subquery =
                criteriaQuery.subquery(ArticoloQueryEntity.class);
            Root<ArticoloQueryEntity> subRoot = subquery.from(ArticoloQueryEntity.class);

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

    Specification<ArticoloQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<ArticoloQueryEntity> page = this.articoloRepository.findAll(specification, pageable);

    ArticoliResponse ArticoliResponse = new ArticoliResponse();
    List<ArticoloQueryDTO> list =
        page.getContent().stream()
            .map(entity -> articoloQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    ArticoliResponse.setRecords(list);

    ArticoliResponse.setPagination(Pagination.buildPagination(page));

    return page;
    
  }

  @Override
  public ArticoliResponse getArticoliByGerarchiaId(
      ArticoliByGerarchiaIdQuery articoliByGerarchiaIdQuery) {
    Pageable pageable =
        PageRequest.of(articoliByGerarchiaIdQuery.getPage(), articoliByGerarchiaIdQuery.getLimit());

    List<Specification<ArticoloQueryEntity>> specifications = new ArrayList<>();
    if (articoliByGerarchiaIdQuery.getGerarchiaId() != null) {
      Query hierarchiaRoots =
          entityManager
              .createNativeQuery(
                  "(WITH RECURSIVE subordinates AS ( "
                      + "    SELECT id, padre_id "
                      + "    FROM gerarchie "
                      + "    WHERE id = :gerarchiaid "
                      + "    UNION "
                      + "    SELECT e.id, e.padre_id "
                      + "    FROM gerarchie e "
                      + "        INNER JOIN subordinates s ON s.padre_id = e.id "
                      + ") "
                      + "SELECT id "
                      + "FROM subordinates)")
              .setParameter("gerarchiaid", articoliByGerarchiaIdQuery.getGerarchiaId());
      List<String> hierarchiaRootsIds = hierarchiaRoots.getResultList();

      specifications.add(
          (root, criteriaQuery, criteriaBuilder) -> {
            // Define the subquery
            Subquery<ArticoloQueryEntity> subquery =
                criteriaQuery.subquery(ArticoloQueryEntity.class);
            Root<ArticoloQueryEntity> subRoot = subquery.from(ArticoloQueryEntity.class);

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
    Specification<ArticoloQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);
    Page<ArticoloQueryEntity> page = this.articoloRepository.findAll(specification, pageable);

    ArticoliResponse ArticoliResponse = new ArticoliResponse();
    List<ArticoloQueryDTO> list =
        page.getContent().stream()
            .map(entity -> articoloQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    ArticoliResponse.setRecords(list);

    ArticoliResponse.setPagination(Pagination.buildPagination(page));

    return ArticoliResponse;
  }

  @Override
  public ArticoliResponse searchArticolo(GenericSearchRequest<ArticoloFilter> query) {
    ArticoliResponse articoliResponse = new ArticoliResponse();
    Page<ArticoloQueryEntity> page = searchQueryArticolo(query);
    List<ArticoloQueryDTO> list =
        page.getContent().stream()
            .map(entity -> articoloQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    articoliResponse.setRecords(list);
    articoliResponse.setPagination(Pagination.buildPagination(page));
    return articoliResponse;
  }
}
