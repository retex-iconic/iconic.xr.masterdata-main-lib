package com.retexspa.xr.ms.masterdata.main.query.services;


import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloNastroPrezziQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.ArticoloNastroPrezziFilter;
import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoloNastroPrezziResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloNastroPrezziQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.ArticoloNastroPrezziQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.ArticoloNastroPrezziRepository;
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
public class ArticoloNastroPrezziQueryServiceImpl implements ArticoloNastroPrezziQueryService {
  @Autowired private ArticoloNastroPrezziRepository articoloNastroPrezziRepository;

  @Autowired ArticoloNastroPrezziQueryMapper articoloNastroPrezziQueryMapper;

  @PersistenceContext private EntityManager entityManager;

  @Override
  public ArticoloNastroPrezziResponse searchArticoloNastroPrezzi(
          GenericSearchRequest<ArticoloNastroPrezziFilter> query) {
    Page<ArticoloNastroPrezziQueryEntity> page = searchQueryArticoloNastroPrezzi(query);
    ArticoloNastroPrezziResponse articoloNastroPrezziResponse = new ArticoloNastroPrezziResponse();
    List<ArticoloNastroPrezziQueryDTO> list =
        page.getContent().stream()
            .map(entity -> articoloNastroPrezziQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    articoloNastroPrezziResponse.setRecords(list);

    articoloNastroPrezziResponse.setPagination(Pagination.buildPagination(page));

    return articoloNastroPrezziResponse;
  }

  @Override
  public Page<ArticoloNastroPrezziQueryEntity> searchQueryArticoloNastroPrezzi(
          GenericSearchRequest<ArticoloNastroPrezziFilter> query) {

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

    List<Specification<ArticoloNastroPrezziQueryEntity>> specifications = new ArrayList<>();

    ArticoloNastroPrezziFilter filter = ArticoloNastroPrezziFilter.createFilterFromMap(query.getFilter());

    if (filter.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
    }

    if (filter.getCodice() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("codice")), "%" + filter.getCodice().toUpperCase() + "%"));
    }

    if (filter.getPrezzoVendita() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("prezzoVendita"), filter.getPrezzoVendita()));
    }

    if (filter.getDataOraInizio() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("dataOraInizio"), filter.getDataOraInizio()));
    }
    if (filter.getDataOraFine() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("dataOraFine"), filter.getDataOraFine()));
    }

    if (filter.getPadreId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("padre").get("id"), filter.getPadreId()));
    }

    if (filter.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
    }

    if (filter.getArticoloId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("articolo").get("id"), filter.getArticoloId()));
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
            Subquery<ArticoloNastroPrezziQueryEntity> subquery =
                criteriaQuery.subquery(ArticoloNastroPrezziQueryEntity.class);
            Root<ArticoloNastroPrezziQueryEntity> subRoot =
                subquery.from(ArticoloNastroPrezziQueryEntity.class);

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

    Specification<ArticoloNastroPrezziQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<ArticoloNastroPrezziQueryEntity> page =
        this.articoloNastroPrezziRepository.findAll(specification, pageable);

    return page;
  }
}
