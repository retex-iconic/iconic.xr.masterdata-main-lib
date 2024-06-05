package com.retexspa.xr.ms.masterdata.main.query.services;


import com.retexspa.xr.ms.masterdata.main.core.entities.ConfigContextQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.ConfigContextByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ConfigContextResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.ConfigContextSearchRequest;

public interface ConfigContextQueryService {

  ConfigContextQueryDTO getConfigContextById(
      ConfigContextByIdQuery query);

  ConfigContextResponse searchConfigContext(
      ConfigContextSearchRequest query);
}
