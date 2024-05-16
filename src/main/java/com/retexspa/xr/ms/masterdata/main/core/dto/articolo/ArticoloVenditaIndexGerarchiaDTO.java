package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class ArticoloVenditaIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public ArticoloVenditaIndexGerarchiaDTO() {}

  public ArticoloVenditaIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getUk(ArticoloVenditaBaseDTO articoloVendita) {

    String uk = articoloVendita.getArticoloId();
    return uk;
  }

  public static String getIndexName() {
    return "ArticoloVenditaIndexGerarchia";
  }

  public static String getIndexAggregateName() {
    return "ArticoloVenditaIndexGerarchiaAggregate";
  }
}
