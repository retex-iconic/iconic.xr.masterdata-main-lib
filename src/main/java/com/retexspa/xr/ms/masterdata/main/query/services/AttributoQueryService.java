package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.responses.AttributoResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.AttributoSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.AttributoQueryEntity;
import org.springframework.data.domain.Page;

public interface AttributoQueryService {

  Page<AttributoQueryEntity> searchQueryAttributo(AttributoSearchRequest query);

  AttributoResponse searchAttributo(AttributoSearchRequest query);
}
