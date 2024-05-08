package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.MasterDataConfigContextQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.MasterDataConfigContextByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.MasterDataConfigContextResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.MasterDataConfigContextSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.MasterDataConfigContextQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.MasterDataConfigContextQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.MasterDataConfigContextRepository;
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
public class MasterDataConfigContextQueryServiceImpl
    implements MasterDataConfigContextQueryService {

  MasterDataConfigContextRepository masterDataConfigContextRepository;

  MasterDataConfigContextQueryMapper masterDataConfigContextQueryMapper;

  MasterDataConfigContextQueryServiceImpl(
      MasterDataConfigContextRepository masterDataConfigContextRepository,
      MasterDataConfigContextQueryMapper masterDataConfigContextQueryMapper) {
    this.masterDataConfigContextRepository = masterDataConfigContextRepository;
    this.masterDataConfigContextQueryMapper = masterDataConfigContextQueryMapper;
  }

  @Override
  public MasterDataConfigContextQueryDTO getMasterDataConfigContextById(
      MasterDataConfigContextByIdQuery query) {
    MasterDataConfigContextQueryEntity masterDataConfigContextQueryEntity =
        this.masterDataConfigContextRepository.findById(query.getMasterDataConfigId()).orElse(null);

    return masterDataConfigContextQueryMapper.toDTO(masterDataConfigContextQueryEntity);
  }

  @Override
  public MasterDataConfigContextResponse searchMasterDataConfigContext(
      MasterDataConfigContextSearchRequest query) {

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
                baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "codice"));
      }
    }

    if (sorts.size() == 0) {
      sorts.add(new Sort.Order(Sort.Direction.ASC, "codice"));
    }

    Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

    List<Specification<MasterDataConfigContextQueryEntity>> specifications = new ArrayList<>();

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
    if (query.getFlgCancellato() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("flgCancellato")),
                  "%" + query.getFlgCancellato().toUpperCase() + "%"));
    }
    if (query.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), query.getVersion()));
    }
    Specification<MasterDataConfigContextQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<MasterDataConfigContextQueryEntity> page =
        this.masterDataConfigContextRepository.findAll(specification, pageable);

    MasterDataConfigContextResponse masterDataConfigContextResponse =
        new MasterDataConfigContextResponse();
    List<MasterDataConfigContextQueryDTO> list =
        page.getContent().stream()
            .map(entity -> masterDataConfigContextQueryMapper.toDTO(entity))
            .collect(Collectors.toList());
    masterDataConfigContextResponse.setRecords(list);

    masterDataConfigContextResponse.setPagination(Pagination.buildPagination(page));

    return masterDataConfigContextResponse;
  }
}
