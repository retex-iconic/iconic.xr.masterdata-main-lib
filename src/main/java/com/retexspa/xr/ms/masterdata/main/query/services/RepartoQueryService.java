package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.responses.RepartoResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.RepartoSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.RepartoQueryEntity;
import org.springframework.data.domain.Page;

public interface RepartoQueryService {
  Page<RepartoQueryEntity> searchQueryReparto(RepartoSearchRequest query);

  RepartoResponse searchReparto(RepartoSearchRequest query);
}
