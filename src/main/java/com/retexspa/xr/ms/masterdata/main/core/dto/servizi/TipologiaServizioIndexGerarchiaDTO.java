package com.retexspa.xr.ms.masterdata.main.core.dto.servizi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipologiaServizioIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {
  public TipologiaServizioIndexGerarchiaDTO() {
  }

  public TipologiaServizioIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getUk(TipologiaServizioBaseDTO tipo) {
    String uk = tipo.getCodice();
    return uk;
  }

  public static String getIndexName() {
    return "TipologiaServizioIndexGerarchia";
  }

  public static String getIndexAggregateName() {
    return "TipologiaServizioIndexGerarchiaAggregate";
  }

}
