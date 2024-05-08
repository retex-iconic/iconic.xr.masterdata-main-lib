package com.retexspa.xr.ms.masterdata.main.core.dto.operatore;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class OperatorePosIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public OperatorePosIndexGerarchiaDTO() {}

  public OperatorePosIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getUk(OperatorePosBaseDTO op) {
    String uk = op.getCodice();
    return uk;
  }
}
