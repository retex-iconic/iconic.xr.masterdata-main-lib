package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.TabCasseEstesaFilter;
import com.retexspa.xr.ms.masterdata.main.core.responses.TabCasseEstesaResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.TabCasseEstesaQueryEntity;
import org.springframework.data.domain.Page;

public interface TabCasseEstesaQueryService {
    Page<TabCasseEstesaQueryEntity> searchQueryTabCasseEstesa(GenericSearchRequest<TabCasseEstesaFilter> query);

    TabCasseEstesaResponse searchTabCasseEstesa(GenericSearchRequest<TabCasseEstesaFilter> query);
}
