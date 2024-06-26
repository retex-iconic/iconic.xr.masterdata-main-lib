package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.TipiCassaFilter;
import com.retexspa.xr.ms.masterdata.main.core.responses.TipiCassaResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.TipiCassaQueryEntity;
import org.springframework.data.domain.Page;

public interface TipiCassaQueryService {

    Page<TipiCassaQueryEntity> searchQueryTipiCassa(GenericSearchRequest<TipiCassaFilter> query);

    TipiCassaResponse searchTipiCassa(GenericSearchRequest<TipiCassaFilter> query);
}
