package com.retexspa.xr.ms.masterdata.main.query.services;


import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.CommissioneServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.CommissioneServizioAggregateGetByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.CommissioneServizioListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.CommissioneServizioResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.CommissioneServizioSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.CommissioneServizioQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.CommissioneServizioQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.CommissioneServizioRepository;
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
public class CommissioneServizioQueryServiceImpl implements CommissioneServizioQueryService {

  @Autowired private CommissioneServizioRepository commissioneServizioRepository;

  @Autowired private CommissioneServizioQueryMapper commissioneServizioQueryMapper;

  @PersistenceContext EntityManager entityManager;



  public CommissioneServizioQueryServiceImpl( CommissioneServizioRepository commissioneServizioRepository) {
    this.commissioneServizioRepository = commissioneServizioRepository;
  }

  @Override
  public CommissioneServizioResponse listCommissioneServizio(CommissioneServizioListQuery query) {

    CommissioneServizioResponse commissioneServizioResponse = new CommissioneServizioResponse();

    Page<CommissioneServizioQueryEntity> page =
        this.commissioneServizioRepository.findAll(
            PageRequest.of(query.getPage(), query.getLimit()));

    List<CommissioneServizioQueryDTO> list =
        page.getContent().stream()
            .map(entity -> commissioneServizioQueryMapper.toDTO(entity))
            .collect(Collectors.toList());

    commissioneServizioResponse.setRecords(list);

    commissioneServizioResponse.setPagination(Pagination.buildPagination(page));

    return commissioneServizioResponse;
  }

  @Override
  // public CommissioneServizioResponse
  // searchCommissioneServizio(CommissioneServizioSearchRequest query)
  public Page<CommissioneServizioQueryEntity> searchQueryCommissioneServizio(
      CommissioneServizioSearchRequest query) {
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
                baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "profilo"));
      }
    }

    if (sorts.size() == 0) {
      sorts.add(new Sort.Order(Sort.Direction.ASC, "profilo"));
    }

    Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

    List<Specification<CommissioneServizioQueryEntity>> specifications = new ArrayList<>();

    if (query.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
    }

    if (query.getAnagraficaServizioId() != null) {
      specifications.add(
          (r, q, c) ->
              c.equal(r.get("anagraficaServizio").get("id"), query.getAnagraficaServizioId()));
    }
    if (query.getArticoloId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("articolo").get("id"), query.getArticoloId()));
    }
    if (query.getFlgDefault() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("flgDefault")), "%" + query.getFlgDefault().toUpperCase() + "%"));
    }
    if (query.getProfilo() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("profilo")), "%" + query.getProfilo().toUpperCase() + "%"));
    }
    if (query.getGerarchiaId() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("gerarchia").get("id"), query.getGerarchiaId()));
    }
    if (query.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), query.getVersion()));
    }

    Specification<CommissioneServizioQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<CommissioneServizioQueryEntity> page =
        this.commissioneServizioRepository.findAll(specification, pageable);
    CommissioneServizioResponse CommissioneServizioResponse = new CommissioneServizioResponse();

    List<CommissioneServizioQueryDTO> list =
        page.getContent().stream()

            // .map(entity -> modelMapper.map(entity, CommissioneServizioQueryDTO.class))

            .map(entity -> commissioneServizioQueryMapper.toDTO(entity))
            .collect(Collectors.toList());

    CommissioneServizioResponse.setRecords(list);

    CommissioneServizioResponse.setPagination(Pagination.buildPagination(page));

    return page;
  }

  @Override
  public CommissioneServizioQueryDTO getCommissioneServizioById(
      CommissioneServizioAggregateGetByIdQuery query) {

    CommissioneServizioQueryEntity commissioneServizioQueryEntity =
        this.commissioneServizioRepository.findById(query.getCommissioneServizioId()).orElse(null);

    return commissioneServizioQueryMapper.toDTO(commissioneServizioQueryEntity);
  }

  @Override
  public CommissioneServizioResponse searchCommissioneServizio(
      CommissioneServizioSearchRequest query) {
    CommissioneServizioResponse commissioneServizioResponse = new CommissioneServizioResponse();
    Page<CommissioneServizioQueryEntity> page = searchQueryCommissioneServizio(query);
    List<CommissioneServizioQueryDTO> list =
        page.getContent().stream()
            .map(entity -> commissioneServizioQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    commissioneServizioResponse.setRecords(list);
    commissioneServizioResponse.setPagination(Pagination.buildPagination(page));
    return commissioneServizioResponse;
  }
}
