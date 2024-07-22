package com.retexspa.xr.ms.masterdata.main.query.services;


import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.entities.ConfigContextQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.ConfigContextFilter;
import com.retexspa.xr.ms.masterdata.main.core.queries.ConfigContextByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ConfigContextResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.ConfigContextQueryEntity;
import org.springframework.data.domain.Page;

public interface ConfigContextQueryService {

  ConfigContextQueryDTO getConfigContextById(
      ConfigContextByIdQuery query);

  Page<ConfigContextQueryEntity> searchQueryConfigContext(
          GenericSearchRequest<ConfigContextFilter> query);
  ConfigContextResponse searchConfigContext(GenericSearchRequest<ConfigContextFilter> query);
}
