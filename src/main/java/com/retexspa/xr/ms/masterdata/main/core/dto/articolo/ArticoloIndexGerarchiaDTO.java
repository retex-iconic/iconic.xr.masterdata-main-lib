package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonInclude(Include.NON_NULL)
public class ArticoloIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public ArticoloIndexGerarchiaDTO() {}

  public ArticoloIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getUk(ArticoloBaseDTO articolo) {
    String uk = articolo.getCodice();
    return uk;
  }
}
