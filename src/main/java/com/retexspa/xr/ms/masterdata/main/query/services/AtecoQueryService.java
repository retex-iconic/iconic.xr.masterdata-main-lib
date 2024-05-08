package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.responses.AtecoResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.AtecoSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.AtecoQueryEntity;
import org.springframework.data.domain.Page;

public interface AtecoQueryService {

  Page<AtecoQueryEntity> searchQueryAteco(AtecoSearchRequest query);

  AtecoResponse searchAteco(AtecoSearchRequest query);
}
