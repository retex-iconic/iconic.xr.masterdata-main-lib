package com.retexspa.xr.ms.masterdata.main.core.dto.tassonomia;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonInclude(Include.NON_NULL)
public class TipoTassonomiaIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public TipoTassonomiaIndexGerarchiaDTO() {}

  public TipoTassonomiaIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }
}
