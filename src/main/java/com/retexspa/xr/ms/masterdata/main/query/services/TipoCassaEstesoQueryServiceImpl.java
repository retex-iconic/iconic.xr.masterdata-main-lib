package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.main.core.responses.Pagination;
import com.retexspa.xr.ms.masterdata.main.core.entities.TipoCassaEstesoQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.TipoCassaEstesoFilter;
import com.retexspa.xr.ms.masterdata.main.core.responses.TipoCassaEstesoResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.TipoCassaEstesoQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.mappers.TipoCassaEstesoQueryMapper;
import com.retexspa.xr.ms.masterdata.main.query.repositories.TipoCassaEstesoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoCassaEstesoQueryServiceImpl implements TipoCassaEstesoQueryService {
    @Autowired
    TipoCassaEstesoRepository tipoCassaEstesoRepository;
    @Autowired
    TipoCassaEstesoQueryMapper tipoCassaEstesoQueryMapper;

    @Override
    public Page<TipoCassaEstesoQueryEntity> searchQueryTipoCassaEsteso(GenericSearchRequest<TipoCassaEstesoFilter> query) {

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

        List<Specification<TipoCassaEstesoQueryEntity>> specifications = new ArrayList<>();

        TipoCassaEstesoFilter filter = TipoCassaEstesoFilter.createFilterFromMap(query.getFilter());

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
        if (filter.getTipoCassaId() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("tipoCassa").get("id"), filter.getTipoCassaId()));
        }
        if (filter.getDataCancellazione() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("dataCancellazione"), filter.getDataCancellazione()));
        }
        if (filter.getFlgCancellato() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("flgCancellato"), filter.getFlgCancellato()));
        }

        if (filter.getVersion() != null) {
            specifications.add((r, q, c) -> c.equal(r.get("version"), filter.getVersion()));
        }
            
        Specification<TipoCassaEstesoQueryEntity> specification =
                specifications.stream().reduce(Specification::and).orElse(null);

        Page<TipoCassaEstesoQueryEntity> page = this.tipoCassaEstesoRepository.findAll(specification, pageable);

        return page;
    }

    @Override
    public TipoCassaEstesoResponse searchTipoCassaEsteso(GenericSearchRequest<TipoCassaEstesoFilter> query) {
        Page<TipoCassaEstesoQueryEntity> page = searchQueryTipoCassaEsteso(query);
        TipoCassaEstesoResponse tipoCassaEstesoResponse = new TipoCassaEstesoResponse();
        List<TipoCassaEstesoQueryDTO> list = page.getContent().stream()
                .map(entity -> tipoCassaEstesoQueryMapper.toDTO(entity))
                .collect(Collectors.toList());
        tipoCassaEstesoResponse.setRecords(list);
        tipoCassaEstesoResponse.setPagination(Pagination.buildPagination(page));
        return tipoCassaEstesoResponse;
    }
}
