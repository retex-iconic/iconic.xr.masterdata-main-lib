package com.retexspa.xr.ms.masterdata.main.core.dto.variazioniCausaliOperazioni;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VariazioniCausaliOperazioniIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public VariazioniCausaliOperazioniIndexGerarchiaDTO() {}

  public VariazioniCausaliOperazioniIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getIndexName(){
    return "VariazioniCausaliOperazioniIndexGerarchia";
  }

  public static String getIndexAggregateName(){
    return "VariazioniCausaliOperazioniIndexGerarchiaAggregate";
  }
}
