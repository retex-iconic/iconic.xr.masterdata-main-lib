package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.entities.ConfigQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.ConfigByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ConfigResponse;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.ConfigFilter;
import com.retexspa.xr.ms.masterdata.main.query.entities.ConfigQueryEntity;
import org.springframework.data.domain.Page;

public interface ConfigQueryService {

  Page<ConfigQueryEntity> searchQueryConfig(
      GenericSearchRequest<ConfigFilter> query);

  ConfigQueryDTO getConfigById(ConfigByIdQuery query);

  ConfigResponse searchConfig(GenericSearchRequest<ConfigFilter> query);
}
