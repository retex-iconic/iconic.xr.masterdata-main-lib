package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.ConfigContextQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.entities.IvaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.ConfigContextFilter;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.IvaFilter;
import com.retexspa.xr.ms.masterdata.main.core.queries.ConfigContextByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ConfigContextResponse;
import com.retexspa.xr.ms.masterdata.main.core.responses.IvaResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.ConfigContextQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.entities.IvaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.ConfigContextQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.ConfigContextRepository;
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
public class ConfigContextQueryServiceImpl
    implements ConfigContextQueryService {

  ConfigContextRepository configContextRepository;

  ConfigContextQueryMapper configContextQueryMapper;

  ConfigContextQueryServiceImpl(
      ConfigContextRepository configContextRepository,
      ConfigContextQueryMapper configContextQueryMapper) {
    this.configContextRepository = configContextRepository;
    this.configContextQueryMapper = configContextQueryMapper;
  }

  @Override
  public ConfigContextQueryDTO getConfigContextById(
      ConfigContextByIdQuery query) {
    ConfigContextQueryEntity configContextQueryEntity =
        this.configContextRepository.findById(query.getConfigId()).orElse(null);

    return configContextQueryMapper.toDTO(configContextQueryEntity);
  }

  @Override
  public Page<ConfigContextQueryEntity> searchQueryConfigContext(
          GenericSearchRequest<ConfigContextFilter> query) {

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

    List<Specification<ConfigContextQueryEntity>> specifications = new ArrayList<>();
    ConfigContextFilter filter = ConfigContextFilter.createFilterFromMap(query.getFilter());
    if (filter.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
    }

    if (filter.getCodice() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(c.upper(r.get("codice")), "%" + filter.getCodice().toUpperCase() + "%"));
    }

    if (filter.getDescrizione() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("descrizione")), "%" + filter.getDescrizione().toUpperCase() + "%"));
    }
    if (filter.getNome() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
    }
    if (filter.getFlgCancellato() != null) {
      specifications.add(
          (r, q, c) ->
              c.like(
                  c.upper(r.get("flgCancellato")),
                  "%" + filter.getFlgCancellato().toUpperCase() + "%"));
    }
    if (filter.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
    }
    Specification<ConfigContextQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<ConfigContextQueryEntity> page =
        this.configContextRepository.findAll(specification, pageable);

    return page;
  }
  @Override
  public ConfigContextResponse searchConfigContext(GenericSearchRequest<ConfigContextFilter> query) {
    Page<ConfigContextQueryEntity> page = searchQueryConfigContext(query);
    ConfigContextResponse configContextResponse = new ConfigContextResponse();
    List<ConfigContextQueryDTO> list =
            page.getContent().stream()
                    .map(entity -> configContextQueryMapper.toDTO(entity))
                    .collect(Collectors.toList());
    configContextResponse.setRecords(list);
    configContextResponse.setPagination(Pagination.buildPagination(page));
    return configContextResponse;
  }
}
