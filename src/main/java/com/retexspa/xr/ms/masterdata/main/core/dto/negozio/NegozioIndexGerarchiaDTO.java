package com.retexspa.xr.ms.masterdata.main.core.dto.negozio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;
import com.retexspa.xr.ms.main.core.dto.negozio.NegozioBaseDTO;

@JsonInclude(Include.NON_NULL)
public class NegozioIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public NegozioIndexGerarchiaDTO() {}

  public NegozioIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getUk(NegozioBaseDTO iva) {
    String uk = iva.getCodice();
    return uk;
  }
}
