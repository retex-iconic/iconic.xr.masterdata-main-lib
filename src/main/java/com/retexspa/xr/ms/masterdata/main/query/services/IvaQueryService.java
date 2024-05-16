package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.entities.IvaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.IvaFilter;
import com.retexspa.xr.ms.masterdata.main.core.queries.IvaByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.IvaResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.IvaQueryEntity;
import org.springframework.data.domain.Page;

public interface IvaQueryService {

  IvaQueryDTO getIvaById(IvaByIdQuery query);

  Page<IvaQueryEntity> searchQueryIva(GenericSearchRequest<IvaFilter> query);

  IvaResponse searchIva(GenericSearchRequest<IvaFilter> query);
}
