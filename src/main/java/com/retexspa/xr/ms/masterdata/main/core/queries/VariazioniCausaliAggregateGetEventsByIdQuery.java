package com.retexspa.xr.ms.masterdata.main.core.queries;

public class VariazioniCausaliAggregateGetEventsByIdQuery {
  private String variazioniCausaliId;

  public VariazioniCausaliAggregateGetEventsByIdQuery(String variazioniCausaliId) {
    this.variazioniCausaliId = variazioniCausaliId;
  }

  public String getVariazioniCausaliId() {
    return variazioniCausaliId;
  }

  public void setVariazioniCausaliId(String variazioniCausaliId) {
    this.variazioniCausaliId = variazioniCausaliId;
  }
}
