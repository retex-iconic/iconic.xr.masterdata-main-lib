package com.retexspa.xr.ms.masterdata.main.core.dto.attributo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;
import com.retexspa.xr.ms.main.core.dto.attributo.AttributoBaseDTO;

@JsonInclude(Include.NON_NULL)
public class MasterDataAttributoIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public MasterDataAttributoIndexGerarchiaDTO() {}

  public MasterDataAttributoIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getUk(AttributoBaseDTO attributo) {
    String uk =
        attributo.getChiave()
            + MasterDataAttributoIndexGerarchiaDTO.getUkSeparator()
            + attributo.getAggregato();
    return uk;
  }
}
