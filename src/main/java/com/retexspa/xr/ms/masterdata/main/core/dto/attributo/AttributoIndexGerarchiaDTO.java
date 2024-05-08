package com.retexspa.xr.ms.masterdata.main.core.dto.attributo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonInclude(Include.NON_NULL)
public class AttributoIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public AttributoIndexGerarchiaDTO() {}

  public AttributoIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getUk(AttributoBaseDTO attributo) {
    String uk =
        attributo.getChiave()
            + AttributoIndexGerarchiaDTO.getUkSeparator()
            + attributo.getAggregato();
    return uk;
  }
}
