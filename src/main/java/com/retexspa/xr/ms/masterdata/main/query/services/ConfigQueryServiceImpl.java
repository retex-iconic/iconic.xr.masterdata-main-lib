package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.ConfigQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.ConfigByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ConfigResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.ConfigSearchRequest;
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
    ConfigQueryEntity configQueryEntity =
        this.configRepository.findById(query.getConfigId()).orElse(null);

    return configQueryMapper.toDTO(configQueryEntity);
  }

  @Override
  // public ConfigResponse
  // searchConfig(ConfigSearchRequest query) {
  public Page<ConfigQueryEntity> searchQueryConfig(
      ConfigSearchRequest query) {

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
    Specification<ConfigQueryEntity> specification =
        specifications.stream().reduce(Specification::and).orElse(null);

    Page<ConfigQueryEntity> page =
        this.configRepository.findAll(specification, pageable);

    return page;
  }

  @Override
  public ConfigResponse searchConfig(ConfigSearchRequest query) {

    ConfigResponse configResponse = new ConfigResponse();
    Page<ConfigQueryEntity> page = searchQueryConfig(query);

    List<ConfigQueryDTO> list =
        page.getContent().stream()
            .map(entity -> configQueryMapper.toDTO(entity))
            .collect(Collectors.toList());

    configResponse.setRecords(list);
    configResponse.setPagination(Pagination.buildPagination(page));

    return configResponse;
  }
}
