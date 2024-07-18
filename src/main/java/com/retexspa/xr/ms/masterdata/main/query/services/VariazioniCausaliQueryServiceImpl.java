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
import com.retexspa.xr.ms.masterdata.main.core.entities.VariazioniCausaliQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.responses.VariazioniCausaliResponse;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.VariazioniCausaliFilter;
import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniCausaliQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.VariazioniCausaliQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.VariazioniCausaliRepository;

@Service
public class VariazioniCausaliQueryServiceImpl implements VariazioniCausaliQueryService {

  VariazioniCausaliRepository variazioniCausaliRepository;

  @Autowired
  VariazioniCausaliQueryMapper variazioniCausaliQueryMapper;

  @PersistenceContext
  private EntityManager entityManager;

  VariazioniCausaliQueryServiceImpl(VariazioniCausaliRepository variazioniCausaliRepository) {
    this.variazioniCausaliRepository = variazioniCausaliRepository;
  }

  @Override
  public Page<VariazioniCausaliQueryEntity> searchQueryVariazioniCausali(
      GenericSearchRequest<VariazioniCausaliFilter> query) {
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

    List<Specification<VariazioniCausaliQueryEntity>> specifications = new ArrayList<>();
    VariazioniCausaliFilter filter = VariazioniCausaliFilter.createFilterFromMap(query.getFilter());

    if (filter.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
    }

    if (filter.getNome() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
    }

    if (filter.getDescription() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("descrizione")), "%" + filter.getDescription().toUpperCase() + "%"));
    }

    if (filter.getCodice() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("codice")), "%" + filter.getCodice().toUpperCase() + "%"));
    }

    if (filter.getTipologiaVariazione() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("tipologiaVariazione")),
              "%" + filter.getTipologiaVariazione().toUpperCase() + "%"));
    }

    if (filter.getPriorita() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("priorita"), filter.getPriorita()));
    }

    if (filter.getFlgAttiva() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("flgAttiva"), filter.getFlgAttiva()));
    }

    if (filter.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
    }

    if (filter.getPadreId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("padre").get("id"), filter.getPadreId()));
    }

    if (filter.getFlgCancellato() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("flgCancellato"), filter.getFlgCancellato()));
    }

    // if (filter.getDataCancellazione() != null) {
    // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd
    // HH:mm:ss.SSSSSS");

    // LocalDateTime dateTime = LocalDateTime.parse(filter.getDataCancellazione(),
    // formatter);

    // specifications.add((r, q, c) -> c.equal(r.get("dataCancellazione"),
    // dateTime));
    // }

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
            Subquery<VariazioniCausaliQueryEntity> subquery = criteriaQuery
                .subquery(VariazioniCausaliQueryEntity.class);
            Root<VariazioniCausaliQueryEntity> subRoot = subquery.from(VariazioniCausaliQueryEntity.class);

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

    Specification<VariazioniCausaliQueryEntity> specification = specifications.stream().reduce(Specification::and)
        .orElse(null);

    Page<VariazioniCausaliQueryEntity> page = this.variazioniCausaliRepository.findAll(specification, pageable);

    VariazioniCausaliResponse variazioniCausaliResponse = new VariazioniCausaliResponse();
    List<VariazioniCausaliQueryDTO> list = page.getContent().stream()
        .map(entity -> variazioniCausaliQueryMapper.toDTO(entity))
        .collect(Collectors.toList());
    variazioniCausaliResponse.setRecords(list);

    variazioniCausaliResponse.setPagination(Pagination.buildPagination(page));

    return page;
  }

  @Override
  public VariazioniCausaliResponse searchVariazioniCausali(GenericSearchRequest<VariazioniCausaliFilter> query) {

    VariazioniCausaliResponse variazioniCausaliResponse = new VariazioniCausaliResponse();
    Page<VariazioniCausaliQueryEntity> page = searchQueryVariazioniCausali(query);
    variazioniCausaliResponse.setPagination(Pagination.buildPagination(page));
    List<VariazioniCausaliQueryDTO> list = page.getContent().stream()
        .map(entity -> variazioniCausaliQueryMapper.toDTO(entity))
        .collect(Collectors.toList());
    variazioniCausaliResponse.setRecords(list);
    return variazioniCausaliResponse;
  }
}
