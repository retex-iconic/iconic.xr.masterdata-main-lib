package com.retexspa.xr.ms.masterdata.main.core.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.responses.BasePaginationResponse;
import com.retexspa.xr.ms.masterdata.main.core.entities.MasterDataConfigContextQueryDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MasterDataConfigContextResponse
    extends BasePaginationResponse<MasterDataConfigContextQueryDTO> {

  public MasterDataConfigContextResponse() {
    super();
  }
}
