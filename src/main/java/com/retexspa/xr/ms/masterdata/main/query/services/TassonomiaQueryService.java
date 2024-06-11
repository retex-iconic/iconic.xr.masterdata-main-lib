package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.TassonomiaFilter;
import com.retexspa.xr.ms.masterdata.main.core.queries.TassonomiaListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.TassonomieResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.TassonomiaQueryEntity;
import org.springframework.data.domain.Page;

public interface TassonomiaQueryService {

    Page<TassonomiaQueryEntity> searchQueryTassonomia(GenericSearchRequest<TassonomiaFilter> query);

    TassonomieResponse listTassonomia(TassonomiaListQuery query);

    TassonomieResponse searchTassonomia(GenericSearchRequest<TassonomiaFilter> query);
}
