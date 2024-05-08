package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.responses.TipoTassonomiaResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.TipoTassonomiaSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.TipoTassonomiaQueryEntity;
import org.springframework.data.domain.Page;

public interface TipoTassonomiaQueryService {
  Page<TipoTassonomiaQueryEntity> searchQueryTipoTassonomia(TipoTassonomiaSearchRequest query);

  TipoTassonomiaResponse searchTipoTassonomia(TipoTassonomiaSearchRequest query);
}
