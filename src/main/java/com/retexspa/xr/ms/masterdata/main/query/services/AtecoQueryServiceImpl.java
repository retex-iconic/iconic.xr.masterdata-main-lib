package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.AtecoQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.responses.AtecoResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.AtecoSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.AtecoQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.AtecoQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.AtecoRepository;
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
public class AtecoQueryServiceImpl implements AtecoQueryService {

  AtecoRepository atecoRepository;

  @Autowired AtecoQueryMapper atecoQueryMapper;

  @PersistenceContext private EntityManager entityManager;

  AtecoQueryServiceImpl(AtecoRepository atecoRepository) {
    this.atecoRepository = atecoRepository;
  }

  @Override
  public Page<AtecoQueryEntity> searchQueryAteco(AtecoSearchRequest query) {
    List<Sort.Order> sorts = new ArrayList<>();

    if (query.getSort() != null && query.getSort().size() != 0) {
      for (BaseSort baseSort : query.getSort()) {

        switch (baseSort.getOrderBy()) {
          case "id":
            break;

          case "codice":
            break;

          case "gerarchiaId":
            break;

          case "atecoNr":
            break;

          case "nome":
            break;

          case "descrizione":
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

    List<Specification<AtecoQueryEntity>> specifications = new ArrayList<>();

    if (query.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
    }

    if (query.getCodice() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("codice")), "%" + query.getCodice().toUpperCase() + "%"));
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
    if (query.getAtecoNr() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("atecoNr"), query.getAtecoNr()));
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
            Subquery<AtecoQueryEntity> subquery = criteriaQuery.subquery(AtecoQueryEntity.class);
            Root<AtecoQueryEntity> subRoot = subquery.from(AtecoQueryEntity.class);

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

    Specification<AtecoQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<AtecoQueryEntity> page = this.atecoRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public AtecoResponse searchAteco(AtecoSearchRequest query) {

    AtecoResponse atecoResponse = new AtecoResponse();
    Page<AtecoQueryEntity> page = searchQueryAteco(query);
    atecoResponse.setPagination(Pagination.buildPagination(page));
    List<AtecoQueryDTO> list =
        page.getContent().stream()
            .map(entity -> atecoQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    atecoResponse.setRecords(list);
    return atecoResponse;
  }
}
