package com.retexspa.xr.ms.masterdata.main.core.dto.variazioniRegoleMonitoraggio;


import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

public class VariazioniRegoleMonitoraggioIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {
  public VariazioniRegoleMonitoraggioIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getIndexName(){
    return "VariazioniRegoleMonitoraggioIndexGerarchia";
  }

  public static String getIndexAggregateName(){
    return "VariazioniRegoleMonitoraggioIndexGerarchiaAggregate";
  }
}
