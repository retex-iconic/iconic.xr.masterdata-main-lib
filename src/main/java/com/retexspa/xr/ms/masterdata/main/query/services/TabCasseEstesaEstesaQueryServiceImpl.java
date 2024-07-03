package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.TabCasseEstesaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.TabCasseEstesaFilter;
import com.retexspa.xr.ms.masterdata.main.core.responses.TabCasseEstesaResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.TabCasseEstesaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.TabCasseEstesaQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.TabCasseEstesaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TabCasseEstesaEstesaQueryServiceImpl implements TabCasseEstesaQueryService{

    @PersistenceContext
    private EntityManager entityManager;
    TabCasseEstesaRepository tabCasseEstesaRepository;

    TabCasseEstesaQueryMapper tabCasseEstesaQueryMapper;

    TabCasseEstesaEstesaQueryServiceImpl(
            TabCasseEstesaRepository tabCasseEstesaRepository,
            TabCasseEstesaQueryMapper tabCasseEstesaQueryMapper) {
        this.tabCasseEstesaRepository = tabCasseEstesaRepository;
        this.tabCasseEstesaQueryMapper = tabCasseEstesaQueryMapper;
    }


    @Override
    public Page<TabCasseEstesaQueryEntity> searchQueryTabCasseEstesa(GenericSearchRequest<TabCasseEstesaFilter> query) {

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
                                baseSort.getOrderBy() != null ? baseSort.getOrderBy() : "id"));
            }
        }

        if (sorts.size() == 0) {
            sorts.add(new Sort.Order(Sort.Direction.ASC, "id"));
        }

        Pageable pageable = PageRequest.of(query.getPage(), query.getLimit(), Sort.by(sorts));

        List<Specification<TabCasseEstesaQueryEntity>> specifications = new ArrayList<>();

        TabCasseEstesaFilter filter = TabCasseEstesaFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }
        if (filter.getCassaId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("tabCasse").get("id"), filter.getCassaId()));
        }
        if (filter.getDataInizio() != null) {
            specifications.add(
                    (r, q, c) -> c.equal(r.get("dataInizio"),  filter.getDataInizio()));
        }
        if (filter.getTipoCassaEstesoId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("tipoCassaEsteso").get("id"), filter.getTipoCassaEstesoId()));
        }

        if (filter.getFlgCancellato() != null) {
            specifications.add(
                    (r, q, c) ->
                            c.like(
                                    c.upper(r.get("flgCancellato")),
                                    "%" + filter.getFlgCancellato().toUpperCase() + "%"));
        }
        if (filter.getDataCancellazione() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("dataCancellazione"), filter.getDataCancellazione()));
        }
        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }

        Specification<TabCasseEstesaQueryEntity> specification =
                specifications.stream().reduce(Specification::and).orElse(null);

        Page<TabCasseEstesaQueryEntity> page = this.tabCasseEstesaRepository.findAll(specification, pageable);

        return page;
    }

    @Override
    public TabCasseEstesaResponse searchTabCasseEstesa(GenericSearchRequest<TabCasseEstesaFilter> query) {
        Page<TabCasseEstesaQueryEntity> page = searchQueryTabCasseEstesa(query);
        TabCasseEstesaResponse tabCasseEstesaResponse = new TabCasseEstesaResponse();
        List<TabCasseEstesaQueryDTO> list =
                page.getContent().stream()
                        .map(entity -> tabCasseEstesaQueryMapper.toDTO(entity))
                        .collect(Collectors.toList());
        tabCasseEstesaResponse.setRecords(list);
        tabCasseEstesaResponse.setPagination(Pagination.buildPagination(page));
        return tabCasseEstesaResponse;
    }
}
