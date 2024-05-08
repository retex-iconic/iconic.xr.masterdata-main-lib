package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.FormaPagamentoCassaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.FormaPagamentoCassaByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.FormaPagamentoCassaResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.FormaPagamentoCassaSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.FormaPagamentoCassaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.FormaPagamentoCassaQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.FormaPagamentoCassaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FormaPagamentoCassaQueryServiceImpl implements FormaPagamentoCassaQueryService {
  FormaPagamentoCassaRepository formaPagamentoCassaRepository;
  FormaPagamentoCassaQueryMapper formaPagamentoCassaQueryMapper;
  @PersistenceContext private EntityManager entityManager;

  public FormaPagamentoCassaQueryServiceImpl(
      FormaPagamentoCassaRepository formaPagamentoCassaRepository,
      FormaPagamentoCassaQueryMapper formaPagamentoCassaQueryMapper) {
    this.formaPagamentoCassaRepository = formaPagamentoCassaRepository;
    this.formaPagamentoCassaQueryMapper = formaPagamentoCassaQueryMapper;
  }

  @Override
  public FormaPagamentoCassaQueryDTO getFormaPagamentoCassaById(
      FormaPagamentoCassaByIdQuery query) {
    FormaPagamentoCassaQueryEntity formaPagamentoCassaQueryEntity =
        this.formaPagamentoCassaRepository.findById(query.getFormaPagamentoCassaId()).orElse(null);

    return formaPagamentoCassaQueryMapper.toDTO(formaPagamentoCassaQueryEntity);
  }

  @Override
  public Page<FormaPagamentoCassaQueryEntity> searchQueryFormaPagamentoCassa(
      FormaPagamentoCassaSearchRequest query) {
    List<Sort.Order> sorts = new ArrayList<>();

    if (query.getSort() != null && query.getSort().size() != 0) {
      for (BaseSort baseSort : query.getSort()) {
        switch (baseSort.getOrderBy()) {
          case "id":
            break;

          case "codice":
            break;

          case "xx1mty":
            break;

          case "xx1mnr":
            break;

          case "formaPagamentoId":
            break;

          case "gerarchiaId":
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

    List<Specification<FormaPagamentoCassaQueryEntity>> specifications = new ArrayList<>();

    if (query.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), query.getId()));
    }

    if (query.getCodice() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("codice")), "%" + query.getCodice().toUpperCase() + "%"));
    }
    if (query.getXx1mty() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("xx1mty"), query.getXx1mty()));
    }
    if (query.getXx1mnr() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("xx1mnr"), query.getXx1mnr()));
    }
    if (query.getFormaPagamentoId() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("formaPagamento").get("id"), query.getFormaPagamentoId()));
    }
    NativeQueryHelper NativeQueryHelper = new NativeQueryHelper();

    if (query.getGerarchiaId() != null) {
      specifications.add(
          (r, q, c) -> c.equal(r.get("gerarchia").get("id"), query.getGerarchiaId()));
    }
    if (query.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), query.getVersion()));
    }
    Specification<FormaPagamentoCassaQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<FormaPagamentoCassaQueryEntity> page =
        this.formaPagamentoCassaRepository.findAll(specification, pageable);
    return page;
  }

  @Override
  public FormaPagamentoCassaResponse searchFormaPagamentoCassa(
      FormaPagamentoCassaSearchRequest query) {

    FormaPagamentoCassaResponse formaPagamentoCassaResponse = new FormaPagamentoCassaResponse();
    Page<FormaPagamentoCassaQueryEntity> page = searchQueryFormaPagamentoCassa(query);
    List<FormaPagamentoCassaQueryDTO> list =
        page.getContent().stream()
            .map(entity -> formaPagamentoCassaQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    formaPagamentoCassaResponse.setRecords(list);

    formaPagamentoCassaResponse.setPagination(Pagination.buildPagination(page));

    return formaPagamentoCassaResponse;
  }
}
