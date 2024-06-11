package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.TipoTassonomiaFilter;
import com.retexspa.xr.ms.masterdata.main.core.responses.TipoTassonomiaResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.TipoTassonomiaQueryEntity;
import org.springframework.data.domain.Page;

public interface TipoTassonomiaQueryService {
  Page<TipoTassonomiaQueryEntity> searchQueryTipoTassonomia(GenericSearchRequest<TipoTassonomiaFilter> query);

  TipoTassonomiaResponse searchTipoTassonomia(GenericSearchRequest<TipoTassonomiaFilter> query);
}
