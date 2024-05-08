package com.retexspa.xr.ms.masterdata.main.query.services;


import com.retexspa.xr.ms.masterdata.main.core.entities.MasterDataConfigContextQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.MasterDataConfigContextByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.MasterDataConfigContextResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.MasterDataConfigContextSearchRequest;

public interface MasterDataConfigContextQueryService {

  MasterDataConfigContextQueryDTO getMasterDataConfigContextById(
      MasterDataConfigContextByIdQuery query);

  MasterDataConfigContextResponse searchMasterDataConfigContext(
      MasterDataConfigContextSearchRequest query);
}
