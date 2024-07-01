package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.TabCasseQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.TabCasseFilter;
import com.retexspa.xr.ms.masterdata.main.core.responses.TabCasseResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.TabCasseQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.TabCasseQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.TabCasseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TabCasseQueryServiceImpl implements TabCasseQueryService {
    @PersistenceContext
    private EntityManager entityManager;
    TabCasseRepository tabCasseRepository;

    TabCasseQueryMapper tabCasseQueryMapper;

    TabCasseQueryServiceImpl(
            TabCasseRepository tabCasseRepository,
            TabCasseQueryMapper tabCasseQueryMapper) {
        this.tabCasseRepository = tabCasseRepository;
        this.tabCasseQueryMapper = tabCasseQueryMapper;
    }


    @Override
    public Page<TabCasseQueryEntity> searchQueryTabCasse(GenericSearchRequest<TabCasseFilter> query) {

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

        List<Specification<TabCasseQueryEntity>> specifications = new ArrayList<>();

        TabCasseFilter filter = TabCasseFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }
        if (filter.getCodice() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("codice"), filter.getCodice()));
        }
        if (filter.getNome() != null) {
            specifications.add(
                    (r, q, c) -> c.like(c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
        }
        if (filter.getDescrizione() != null) {
            specifications.add(
                    (r, q, c) ->
                            c.like(
                                    c.upper(r.get("descrizione")),
                                    "%" + filter.getDescrizione().toUpperCase() + "%"));
        }
        if (filter.getAttiva() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("attiva"), filter.getAttiva()));
        }
        if (filter.getTipoCassaId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("tipoCassa").get("id"), filter.getTipoCassaId()));
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

        if (filter.getGerarchiaId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("gerarchia").get("id"), filter.getGerarchiaId()));
        }
        Specification<TabCasseQueryEntity> specification =
                specifications.stream().reduce(Specification::and).orElse(null);

        Page<TabCasseQueryEntity> page = this.tabCasseRepository.findAll(specification, pageable);

        return page;
    }

    @Override
    public TabCasseResponse searchTabCasse(GenericSearchRequest<TabCasseFilter> query) {
        Page<TabCasseQueryEntity> page = searchQueryTabCasse(query);
        TabCasseResponse tabCasseResponse = new TabCasseResponse();
        List<TabCasseQueryDTO> list =
                page.getContent().stream()
                        .map(entity -> tabCasseQueryMapper.toDTO(entity))
                        .collect(Collectors.toList());
        tabCasseResponse.setRecords(list);
        tabCasseResponse.setPagination(Pagination.buildPagination(page));
        return tabCasseResponse;
    }
}
