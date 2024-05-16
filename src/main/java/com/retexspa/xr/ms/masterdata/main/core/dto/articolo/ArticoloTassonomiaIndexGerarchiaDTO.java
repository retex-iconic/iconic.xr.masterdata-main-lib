package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class ArticoloTassonomiaIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public ArticoloTassonomiaIndexGerarchiaDTO() {}

  public ArticoloTassonomiaIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getIndexName() {
    return "ArticoloTassonomiaIndexGerarchia";
  }

  public static String getIndexAggregateName() {
    return "ArticoloTassonomiaIndexGerarchiaAggregate";
  }
}
