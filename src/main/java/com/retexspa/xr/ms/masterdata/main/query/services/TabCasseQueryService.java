package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.TabCasseFilter;
import com.retexspa.xr.ms.masterdata.main.core.responses.TabCasseResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.TabCasseQueryEntity;
import org.springframework.data.domain.Page;

public interface TabCasseQueryService {
    Page<TabCasseQueryEntity> searchQueryTabCasse(GenericSearchRequest<TabCasseFilter> query);

    TabCasseResponse searchTabCasse(GenericSearchRequest<TabCasseFilter> query);
}
