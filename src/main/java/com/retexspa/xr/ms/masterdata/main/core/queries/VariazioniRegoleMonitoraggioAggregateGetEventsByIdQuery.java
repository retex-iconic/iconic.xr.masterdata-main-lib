package com.retexspa.xr.ms.masterdata.main.core.queries;

public class VariazioniRegoleMonitoraggioAggregateGetEventsByIdQuery {
  private String variazioniRegoleMonitoraggioId;

  public VariazioniRegoleMonitoraggioAggregateGetEventsByIdQuery(
      String variazioniRegoleMonitoraggioId) {
    this.variazioniRegoleMonitoraggioId = variazioniRegoleMonitoraggioId;
  }

  public String getVariazioniRegoleMonitoraggioId() {
    return variazioniRegoleMonitoraggioId;
  }

  public void setVariazioniRegoleMonitoraggioId(String variazioniRegoleMonitoraggioId) {
    this.variazioniRegoleMonitoraggioId = variazioniRegoleMonitoraggioId;
  }
}
