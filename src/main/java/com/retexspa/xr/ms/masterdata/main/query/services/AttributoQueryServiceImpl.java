package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.AttributoQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.responses.AttributoResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.AttributoSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.AttributoQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.AttributoQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.AttributoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AttributoQueryServiceImpl implements AttributoQueryService {

  AttributoRepository attributoRepository;

  @Autowired AttributoQueryMapper attributoQueryMapper;

  @PersistenceContext private EntityManager entityManager;

  AttributoQueryServiceImpl(AttributoRepository attributoRepository) {
    this.attributoRepository = attributoRepository;
  }

  @Override
  public Page<AttributoQueryEntity> searchQueryAttributo(AttributoSearchRequest query) {
    List<Sort.Order> sorts = new ArrayList<>();

    if (query.getSort() != null && query.getSort().size() != 0) {
      for (BaseSort baseSort : query.getSort()) {

        switch (baseSort.getOrderBy()) {
          case "id":
            break;

          case "chiave":
            break;

          case "descrizione":
            break;

          case "aggregato":
            break;

          case "checkvalue":
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
                baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "chiave"));
      }
    }

    if (sorts.size() == 0) {
      sorts.add(new Sort.Order(Sort.Direction.ASC, "chiave"));
    }

    Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

    List<Specification<AttributoQueryEntity>> specifications = new ArrayList<>();

    if (query.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
    }

    if (query.getChiave() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("chiave")), "%" + query.getChiave().toUpperCase() + "%"));
    }

    if (query.getDescrizione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("descrizione")), "%" + query.getDescrizione().toUpperCase() + "%"));
    }

    if (query.getAggregato() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("aggregato")), "%" + query.getAggregato().toUpperCase() + "%"));
    }
    if (query.getCheckValue() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("checkValue"), query.getCheckValue()));
    }
    if (query.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), query.getVersion()));
    }

    NativeQueryHelper NativeQueryHelper = new NativeQueryHelper();

    Specification<AttributoQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<AttributoQueryEntity> page = this.attributoRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public AttributoResponse searchAttributo(AttributoSearchRequest query) {

    AttributoResponse attributoResponse = new AttributoResponse();
    Page<AttributoQueryEntity> page = searchQueryAttributo(query);
    attributoResponse.setPagination(Pagination.buildPagination(page));
    List<AttributoQueryDTO> list =
        page.getContent().stream()
            .map(entity -> attributoQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    attributoResponse.setRecords(list);
    return attributoResponse;
  }
}
