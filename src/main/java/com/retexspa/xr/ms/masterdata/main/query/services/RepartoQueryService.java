package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.RepartoFilter;
import com.retexspa.xr.ms.masterdata.main.core.responses.RepartoResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.RepartoQueryEntity;
import org.springframework.data.domain.Page;

public interface RepartoQueryService {
  Page<RepartoQueryEntity> searchQueryReparto(GenericSearchRequest<RepartoFilter> query);


  RepartoResponse searchReparto(GenericSearchRequest<RepartoFilter> query);
}
