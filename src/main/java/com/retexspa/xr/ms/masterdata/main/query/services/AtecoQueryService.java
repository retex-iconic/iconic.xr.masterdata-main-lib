package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.responses.AtecoResponse;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.AtecoFilter;
import com.retexspa.xr.ms.masterdata.main.query.entities.AtecoQueryEntity;
import org.springframework.data.domain.Page;

public interface AtecoQueryService {

  Page<AtecoQueryEntity> searchQueryAteco(GenericSearchRequest<AtecoFilter> query);

  AtecoResponse searchAteco(GenericSearchRequest<AtecoFilter> query);
}
