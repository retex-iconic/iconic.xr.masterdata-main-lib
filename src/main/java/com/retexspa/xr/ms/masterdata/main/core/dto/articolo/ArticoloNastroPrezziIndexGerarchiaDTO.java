package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonInclude(Include.NON_NULL)
public class ArticoloNastroPrezziIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public ArticoloNastroPrezziIndexGerarchiaDTO() {}

  public ArticoloNastroPrezziIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getIndexName() {
    return "ArticoloNastroPrezziIndexGerarchia";
  }

  public static String getIndexAggregateName() {
    return "ArticoloNastroPrezziIndexGerarchiaAggregate";
  }
}
