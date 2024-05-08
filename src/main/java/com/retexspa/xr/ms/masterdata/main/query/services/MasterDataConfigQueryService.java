package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.entities.MasterDataConfigQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.MasterDataConfigByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.MasterDataConfigResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.MasterDataConfigSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.MasterDataConfigQueryEntity;
import org.springframework.data.domain.Page;

public interface MasterDataConfigQueryService {

  Page<MasterDataConfigQueryEntity> searchQueryMasterdataConfig(
      MasterDataConfigSearchRequest query);

  MasterDataConfigQueryDTO getMasterDataConfigById(MasterDataConfigByIdQuery query);

  MasterDataConfigResponse searchMasterDataConfig(MasterDataConfigSearchRequest query);
}
