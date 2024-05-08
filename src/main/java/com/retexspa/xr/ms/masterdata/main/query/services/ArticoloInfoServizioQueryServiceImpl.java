package com.retexspa.xr.ms.masterdata.main.query.services;


import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloInfoServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.ArticoloInfoServizioByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoloInfoServizioResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.ArticoloInfoServizioSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloInfoServizioQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.ArticoloInfoServizioQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.ArticoloInfoServizioRepository;
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
public class ArticoloInfoServizioQueryServiceImpl implements ArticoloInfoServizioQueryService {

  @Autowired private ArticoloInfoServizioRepository articoloInfoServizioRepository;

  @Autowired ArticoloInfoServizioQueryMapper articoloInfoServizioQueryMapper;

  @PersistenceContext private EntityManager entityManager;

  @Override
  public ArticoloInfoServizioQueryDTO getArticoloInfoServizioById(
      ArticoloInfoServizioByIdQuery query) {
    ArticoloInfoServizioQueryEntity articoloInfoServizioQueryEntity =
        this.articoloInfoServizioRepository.findById(query.getArticoloInfoServizoId()).get();
    ArticoloInfoServizioQueryDTO articoloInfoServizioQueryDTO =
        articoloInfoServizioQueryMapper.toDTO(articoloInfoServizioQueryEntity);
    return articoloInfoServizioQueryDTO;
  }

  @Override
  public Page<ArticoloInfoServizioQueryEntity> searchQueryArticoloInfoServizio(
      ArticoloInfoServizioSearchRequest query) {
    List<Sort.Order> sorts = new ArrayList<>();

    if (query.getSort() != null && query.getSort().size() != 0) {
      for (BaseSort baseSort : query.getSort()) {

        switch (baseSort.getOrderBy()) {
          case "id":
            break;

          case "gerarchiaId":
            break;

          case "articoloId":
            break;

          case "servizioId":
            break;

          case "flgCancellato":
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
                baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "articoloId"));
      }
    }

    if (sorts.size() == 0) {
      sorts.add(new Sort.Order(Sort.Direction.ASC, "articoloId"));
    }

    Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

    List<Specification<ArticoloInfoServizioQueryEntity>> specifications = new ArrayList<>();

    if (query.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
    }

    if (query.getGerarchiaId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("gerarchiaId"), query.getGerarchiaId()));
    }

    if (query.getArticoloId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("articoloId"), query.getArticoloId()));
    }
    if (query.getServizioId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("servizioId"), query.getServizioId()));
    }

    if (query.getFlgCancellato() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("flgCancellato"), query.getFlgCancellato()));
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
            Subquery<ArticoloInfoServizioQueryEntity> subquery =
                criteriaQuery.subquery(ArticoloInfoServizioQueryEntity.class);
            Root<ArticoloInfoServizioQueryEntity> subRoot =
                subquery.from(ArticoloInfoServizioQueryEntity.class);

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

    Specification<ArticoloInfoServizioQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<ArticoloInfoServizioQueryEntity> page =
        this.articoloInfoServizioRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public ArticoloInfoServizioResponse searchArticoloInfoServizio(
      ArticoloInfoServizioSearchRequest query) {
    ArticoloInfoServizioResponse articoloInfoServizioResponse = new ArticoloInfoServizioResponse();
    Page<ArticoloInfoServizioQueryEntity> page = searchQueryArticoloInfoServizio(query);
    articoloInfoServizioResponse.setPagination(Pagination.buildPagination(page));
    List<ArticoloInfoServizioQueryDTO> list =
        page.getContent().stream()
            .map(entity -> articoloInfoServizioQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    articoloInfoServizioResponse.setRecords(list);
    return articoloInfoServizioResponse;
  }
}
