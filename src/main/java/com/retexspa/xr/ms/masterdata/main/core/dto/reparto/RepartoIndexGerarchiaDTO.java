package com.retexspa.xr.ms.masterdata.main.core.dto.reparto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonInclude(Include.NON_NULL)
public class RepartoIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public RepartoIndexGerarchiaDTO() {}

  public RepartoIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getUk(RepartoBaseDTO rep) {
    String uk = rep.getCodice();
    return uk;
  }

  public static String getIndexName () {
    return "RepartoIndexGerarchia";
  }

  public static String getIndexAggregateName () {
    return "RepartoIndexGerarchiaAggregate";
  }
}
