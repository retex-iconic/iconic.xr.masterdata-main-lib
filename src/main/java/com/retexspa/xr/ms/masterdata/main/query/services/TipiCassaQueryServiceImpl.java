package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.helpers.NativeQueryHelper;
import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.IvaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.entities.TipiCassaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.IvaFilter;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.TipiCassaFilter;
import com.retexspa.xr.ms.masterdata.main.core.queries.IvaByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.IvaResponse;
import com.retexspa.xr.ms.masterdata.main.core.responses.TipiCassaResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.IvaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.entities.TipiCassaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.IvaQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.mappers.TipiCassaQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.IvaRepository;
import com.retexspa.xr.ms.masterdata.main.query.repositories.TipiCassaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipiCassaQueryServiceImpl implements TipiCassaQueryService{
    @Autowired
    TipiCassaRepository tipiCassaRepository;
    @Autowired
    TipiCassaQueryMapper tipiCassaQueryMapper;


    @Override
    public Page<TipiCassaQueryEntity> searchQueryTipiCassa(GenericSearchRequest<TipiCassaFilter> query) {

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

        List<Specification<TipiCassaQueryEntity>> specifications = new ArrayList<>();

        TipiCassaFilter filter = TipiCassaFilter.createFilterFromMap(query.getFilter());

        if (filter.getId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("id"), filter.getId()));
        }
        if (filter.getCodice() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("codice"), filter.getCodice()));
        }
        if (filter.getNome() != null) {
            specifications.add(
                    (r, q, c) ->
                            c.like(c.upper(r.get("nome")), "%" + filter.getNome().toUpperCase() + "%"));
        }
        if (filter.getDescrizione() != null) {
            specifications.add(
                    (r, q, c) ->
                            c.like(c.upper(r.get("descrizione")), "%" + filter.getDescrizione().toUpperCase() + "%"));
        }
        if (filter.getCassaFisica() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("cassaFisica"), filter.getCassaFisica()));
        }
        if (filter.getDataCancellazione() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("dataCancellazione"), filter.getDataCancellazione()));
        }
        if (filter.getFlgCancellato() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("flgCancellato"), filter.getFlgCancellato()));
        }
        Specification<TipiCassaQueryEntity> specification =
                specifications.stream().reduce(Specification::and).orElse(null);

        Page<TipiCassaQueryEntity> page = this.tipiCassaRepository.findAll(specification, pageable);

        return page;
    }

    @Override
    public TipiCassaResponse searchTipiCassa(GenericSearchRequest<TipiCassaFilter> query) {
        Page<TipiCassaQueryEntity> page = searchQueryTipiCassa(query);
        TipiCassaResponse tipiCassaResponse = new TipiCassaResponse();
        List<TipiCassaQueryDTO> list =
                page.getContent().stream()
                        .map(entity -> tipiCassaQueryMapper.toDTO(entity))
                        .collect(Collectors.toList());
        tipiCassaResponse.setRecords(list);
        tipiCassaResponse.setPagination(Pagination.buildPagination(page));
        return tipiCassaResponse;
    }
}

