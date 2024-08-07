package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.ConfigQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.ConfigByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ConfigResponse;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.ConfigFilter;
import com.retexspa.xr.ms.masterdata.main.query.entities.ConfigQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.ConfigQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.ConfigRepository;
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
public class ConfigQueryServiceImpl implements ConfigQueryService {

  ConfigRepository configRepository;

  ConfigQueryMapper configQueryMapper;

  ConfigQueryServiceImpl(
      ConfigRepository configRepository,
      ConfigQueryMapper configQueryMapper) {
    this.configRepository = configRepository;
    this.configQueryMapper = configQueryMapper;
  }

  @Override
  public ConfigQueryDTO getConfigById(ConfigByIdQuery query) {
    ConfigQueryEntity configQueryEntity = this.configRepository.findById(query.getConfigId()).orElse(null);

    return configQueryMapper.toDTO(configQueryEntity);
  }

  @Override
  // public ConfigResponse
  // searchConfig(ConfigSearchRequest query) {
  public Page<ConfigQueryEntity> searchQueryConfig(
      GenericSearchRequest<ConfigFilter> query) {

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

    List<Specification<ConfigQueryEntity>> specifications = new ArrayList<>();

    ConfigFilter filter = ConfigFilter.createFilterFromMap(query.getFilter());

    if (filter.getId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
    }

    if (filter.getCodice() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("codice")), "%" + filter.getCodice().toUpperCase() + "%"));
    }

    if (filter.getDescrizione() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("descrizione")), "%" + filter.getDescrizione().toUpperCase() + "%"));
    }
    if (filter.getNome() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
    }
    if (filter.getFlgAttivo() != null) {
      specifications.add(
          (r, q, c) -> c.like(c.upper(r.get("flgAttivo")), "%" + filter.getFlgAttivo().toUpperCase() + "%"));
    }
    if (filter.getFlgCancellato() != null) {
      specifications.add(
          (r, q, c) -> c.like(
              c.upper(r.get("flgCancellato")),
              "%" + filter.getFlgCancellato().toUpperCase() + "%"));
    }
    if (filter.getNodoId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("nodo").get("id"), filter.getNodoId()));
    }
    if (filter.getContextId() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("context").get("id"), filter.getContextId()));
    }
    if (filter.getVersion() != null) {
      specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
    }
    Specification<ConfigQueryEntity> specification = specifications.stream().reduce(Specification::and).orElse(null);

    Page<ConfigQueryEntity> page = this.configRepository.findAll(specification, pageable);

    return page;
  }

  @Override
  public ConfigResponse searchConfig(GenericSearchRequest<ConfigFilter> query) {

    ConfigResponse configResponse = new ConfigResponse();
    Page<ConfigQueryEntity> page = searchQueryConfig(query);

    List<ConfigQueryDTO> list = page.getContent().stream()
        .map(entity -> configQueryMapper.toDTO(entity))
        .collect(Collectors.toList());

    configResponse.setRecords(list);
    configResponse.setPagination(Pagination.buildPagination(page));

    return configResponse;
  }
}
