package com.retexspa.xr.ms.masterdata.main.core.dto.variazioneLog;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VariazioniCausaliIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public VariazioniCausaliIndexGerarchiaDTO() {}

  public VariazioniCausaliIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getIndexName(){
    return "VariazioniCausaliIndexGerarchia";
  }

  public static String getIndexAggregateName(){
    return "VariazioniCausaliIndexGerarchiaAggregate";
  }
}
