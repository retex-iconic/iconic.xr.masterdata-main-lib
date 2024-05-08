package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.entities.IvaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.IvaByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.IvaResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.IvaSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.IvaQueryEntity;
import org.springframework.data.domain.Page;

public interface IvaQueryService {

  IvaQueryDTO getIvaById(IvaByIdQuery query);

  Page<IvaQueryEntity> searchQueryIva(IvaSearchRequest query);

  IvaResponse searchIva(IvaSearchRequest query);
}
