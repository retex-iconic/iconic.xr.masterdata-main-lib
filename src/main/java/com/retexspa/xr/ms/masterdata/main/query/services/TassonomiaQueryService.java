package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.queries.TassonomiaListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.TassonomieResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.TassonomiaSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.TassonomiaQueryEntity;
import org.springframework.data.domain.Page;

public interface TassonomiaQueryService {
  TassonomieResponse listTassonomia(TassonomiaListQuery query);

  TassonomieResponse searchTassonomia(TassonomiaSearchRequest query);

  Page<TassonomiaQueryEntity> searchQueryTassonomia(TassonomiaSearchRequest query);
  // TassonomiaQueryDTO getTassonomiaById(TassonomiaByIdQuery query);

  // List<TassonomiaQueryEntity> createBatchTassonomia(TassonomiaBatchCreateQuery query);
}
