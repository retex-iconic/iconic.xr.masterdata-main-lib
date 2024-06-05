package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.entities.ConfigQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.ConfigByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ConfigResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.ConfigSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.ConfigQueryEntity;
import org.springframework.data.domain.Page;

public interface ConfigQueryService {

  Page<ConfigQueryEntity> searchQueryConfig(
      ConfigSearchRequest query);

  ConfigQueryDTO getConfigById(ConfigByIdQuery query);

  ConfigResponse searchConfig(ConfigSearchRequest query);
}
