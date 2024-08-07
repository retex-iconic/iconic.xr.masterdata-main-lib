package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.entities.AtecoQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.responses.AtecoResponse;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.AtecoFilter;
import com.retexspa.xr.ms.masterdata.main.query.entities.AtecoQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.entities.RepartoQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.AtecoQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.AtecoRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

  @Autowired
  AtecoQueryMapper atecoQueryMapper;

  @PersistenceContext
  private EntityManager entityManager;

  AtecoQueryServiceImpl(AtecoRepository atecoRepository) {
    this.atecoRepository = atecoRepository;
  }

  @Override
  public Page<AtecoQueryEntity> searchQueryAteco(GenericSearchRequest<AtecoFilter> query) {
    List<Sort.Order> sorts = new ArrayList<>();

    if (query.getSort() != null && query.getSort().size() != 0) {
      for (BaseSort baseSort : query.getSort()) {

        Sort.Order sort = new Sort.Order(
            (baseSort.getOrderType() != null
                ? (baseSort.getOrderType().equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC)
                : Sort.Direction.ASC),
            (baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "id"));
        sorts.add(sort);
      }
    }

    if (sorts.size() == 0) {
      sorts.add(new Sort.Order(Sort.Direction.ASC, "codice"));
    }

    Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

    List<Specification<AtecoQueryEntity>> specifications = new ArrayList<>();

    AtecoFilter filter = AtecoFilter.createFilterFromMap(query.getFilter());

    if (filter.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
    }

    if (filter.getCodice() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("codice")), "%" + filter.getCodice().toUpperCase() + "%"));
    }

    if (filter.getNome() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
    }

    if (filter.getPadreId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("padre").get("id"), filter.getPadreId()));
    }
    if (filter.getFlgCancellato() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("flgCancellato"), filter.getFlgCancellato()));
    }
    if (filter.getDataCancellazione() != null) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
      LocalDateTime dateTime = LocalDateTime.parse(filter.getDataCancellazione(), formatter);
      specifications.add((r, q, c) -> c.equal(r.get("dataCancellazione"), dateTime));
    }

    if (filter.getDescrizione() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("descrizione")), "%" + filter.getDescrizione().toUpperCase() + "%"));
    }
    if (filter.getAtecoNr() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("atecoNr"), filter.getAtecoNr()));
    }
    if (filter.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
    }
    NativeQueryHelper NativeQueryHelper = new NativeQueryHelper();
    if (filter.getGerarchiaId() != null) {
      String gerarchNativeQuery = NativeQueryHelper.gerarchiaNativeQuery();
      Query hierarchiaRoots = entityManager
          .createNativeQuery(gerarchNativeQuery)
          .setParameter("gerarchiaid", filter.getGerarchiaId());
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

    Specification<AtecoQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

    Page<AtecoQueryEntity> page = this.atecoRepository.findAll(specification, pageable);

    AtecoResponse atecoResponse = new AtecoResponse();
    List<AtecoQueryDTO> list = page.getContent().stream()
        .map(entity -> atecoQueryMapper.toDTO(entity))
        .collect(Collectors.toList());
    atecoResponse.setRecords(list);

    atecoResponse.setPagination(Pagination.buildPagination(page));

    return page;
  }

  @Override
  public AtecoResponse searchAteco(GenericSearchRequest<AtecoFilter> query) {

    AtecoResponse atecoResponse = new AtecoResponse();
    Page<AtecoQueryEntity> page = searchQueryAteco(query);

    List<AtecoQueryDTO> list = page.getContent().stream()
        .map(entity -> atecoQueryMapper.toDTO(entity))
        .collect(Collectors.toList());
    atecoResponse.setRecords(list);

    atecoResponse.setPagination(Pagination.buildPagination(page));

    return atecoResponse;
  }
}
