package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.TipoCassaEstesoFilter;
import com.retexspa.xr.ms.masterdata.main.core.responses.TipoCassaEstesoResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.TipoCassaEstesoQueryEntity;
import org.springframework.data.domain.Page;


public interface TipoCassaEstesoQueryService {
    Page<TipoCassaEstesoQueryEntity> searchQueryTipoCassaEsteso(GenericSearchRequest<TipoCassaEstesoFilter> query);

    TipoCassaEstesoResponse searchTipoCassaEsteso(GenericSearchRequest<TipoCassaEstesoFilter> query);
}
