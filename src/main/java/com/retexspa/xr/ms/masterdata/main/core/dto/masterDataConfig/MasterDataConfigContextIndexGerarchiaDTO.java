package com.retexspa.xr.ms.masterdata.main.core.dto.masterDataConfig;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonInclude(Include.NON_NULL)
public class MasterDataConfigContextIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public MasterDataConfigContextIndexGerarchiaDTO() {}

  public MasterDataConfigContextIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }
}
