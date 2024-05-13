package com.retexspa.xr.ms.masterdata.main.core.dto.fornitore;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class FornitoreIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public FornitoreIndexGerarchiaDTO() {}

  public FornitoreIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getUk(FornitoreBaseDTO fornitore) {
    String uk = fornitore.getCodice();
    return uk;
  }
  
  public static String getIndexName () {
    return "FornitoreIndexGerarchia";
  }

  public static String getIndexAggregateName () {
    return "FornitoreIndexGerarchiaAggregate";
  }


}
