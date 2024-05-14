package com.retexspa.xr.ms.masterdata.main.core.dto.servizi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnagraficaServizioIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {
  public AnagraficaServizioIndexGerarchiaDTO() {}

  public AnagraficaServizioIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getUk(AnagraficaServizioBaseDTO anag) {
    String uk = anag.getCodice();
    return uk;
  }
  public static String getIndexName() {
    return "AnagraficaServizioIndexGerarchia";
  }

  public static String getIndexAggregateName() {
    return "AnagraficaServizioIndexGerarchiaAggregate";
  }


}
