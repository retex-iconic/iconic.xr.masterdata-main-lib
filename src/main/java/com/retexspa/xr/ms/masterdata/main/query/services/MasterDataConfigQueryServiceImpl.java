package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.MasterDataConfigQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.MasterDataConfigByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.MasterDataConfigResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.MasterDataConfigSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.MasterDataConfigQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.MasterDataConfigQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.MasterDataConfigRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class MasterDataConfigQueryServiceImpl implements MasterDataConfigQueryService {

  MasterDataConfigRepository masterDataConfigRepository;

  MasterDataConfigQueryMapper masterDataConfigQueryMapper;

  MasterDataConfigQueryServiceImpl(
      MasterDataConfigRepository masterDataConfigRepository,
      MasterDataConfigQueryMapper masterDataConfigQueryMapper) {
    this.masterDataConfigRepository = masterDataConfigRepository;
    this.masterDataConfigQueryMapper = masterDataConfigQueryMapper;
  }

  @Override
  public MasterDataConfigQueryDTO getMasterDataConfigById(MasterDataConfigByIdQuery query) {
    MasterDataConfigQueryEntity masterDataConfigQueryEntity =
        this.masterDataConfigRepository.findById(query.getMasterDataConfigId()).orElse(null);

    return masterDataConfigQueryMapper.toDTO(masterDataConfigQueryEntity);
  }

  @Override
  // public MasterDataConfigResponse
  // searchMasterDataConfig(MasterDataConfigSearchRequest query) {
  public Page<MasterDataConfigQueryEntity> searchQueryMasterdataConfig(
      MasterDataConfigSearchRequest query) {

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
          case "flgAttivo":
            break;
          case "flgCancellato":
            break;
          case "nodoId":
            break;
          case "contextId":
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

    List<Specification<MasterDataConfigQueryEntity>> specifications = new ArrayList<>();

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
    if (query.getFlgAttivo() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("flgAttivo")), "%" + query.getFlgAttivo().toUpperCase() + "%"));
    }
    if (query.getFlgCancellato() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("flgCancellato")),
                  "%" + query.getFlgCancellato().toUpperCase() + "%"));
    }
    if (query.getNodoId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("nodo").get("id"), query.getNodoId()));
    }
    if (query.getContextId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("context").get("id"), query.getContextId()));
    }
    if (query.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), query.getVersion()));
    }
    Specification<MasterDataConfigQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<MasterDataConfigQueryEntity> page =
        this.masterDataConfigRepository.findAll(specification, pageable);

    return page;
  }

  @Override
  public MasterDataConfigResponse searchMasterDataConfig(MasterDataConfigSearchRequest query) {

    MasterDataConfigResponse masterdataConfigResponse = new MasterDataConfigResponse();
    Page<MasterDataConfigQueryEntity> page = searchQueryMasterdataConfig(query);

    List<MasterDataConfigQueryDTO> list =
        page.getContent().stream()
            .map(entity -> masterDataConfigQueryMapper.toDTO(entity))
            .collect(Collectors.toList());

    masterdataConfigResponse.setRecords(list);
    masterdataConfigResponse.setPagination(Pagination.buildPagination(page));

    return masterdataConfigResponse;
  }
}
