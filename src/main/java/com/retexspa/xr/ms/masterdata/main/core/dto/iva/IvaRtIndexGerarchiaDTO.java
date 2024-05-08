package com.retexspa.xr.ms.masterdata.main.core.dto.iva;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonInclude(Include.NON_NULL)
public class IvaRtIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public IvaRtIndexGerarchiaDTO() {}

  public IvaRtIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }
}
