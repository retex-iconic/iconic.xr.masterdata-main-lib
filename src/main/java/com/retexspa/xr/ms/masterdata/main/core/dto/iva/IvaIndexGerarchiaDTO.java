package com.retexspa.xr.ms.masterdata.main.core.dto.iva;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonInclude(Include.NON_NULL)
public class IvaIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public IvaIndexGerarchiaDTO() {}

  public IvaIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getUk(IvaBaseDTO iva) {
    String uk = iva.getCodice();
    return uk;
  }
}
