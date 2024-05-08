package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonInclude(Include.NON_NULL)
public class ArticoloInfoServizioIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public ArticoloInfoServizioIndexGerarchiaDTO() {}

  public ArticoloInfoServizioIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }
}
