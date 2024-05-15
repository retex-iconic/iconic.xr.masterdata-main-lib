package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.entities.IvaRtQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.IvaRtFilter;
import com.retexspa.xr.ms.masterdata.main.core.queries.IvaRtByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.IvaRtResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.IvaRtQueryEntity;
import org.springframework.data.domain.Page;

public interface IvaRtQueryService {

  IvaRtQueryDTO getIvaRtById(IvaRtByIdQuery query);

  Page<IvaRtQueryEntity> searchQueryIvaRt(GenericSearchRequest<IvaRtFilter> query);

  IvaRtResponse searchIvaRt(GenericSearchRequest<IvaRtFilter> query);
}
