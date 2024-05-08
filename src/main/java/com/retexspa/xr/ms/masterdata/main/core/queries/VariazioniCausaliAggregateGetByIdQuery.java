package com.retexspa.xr.ms.masterdata.main.core.queries;

public class VariazioniCausaliAggregateGetByIdQuery {
  private String variazioniCausaliId;

  public VariazioniCausaliAggregateGetByIdQuery(String variazioniCausaliId) {
    this.variazioniCausaliId = variazioniCausaliId;
  }

  public String getVariazioniCausaliId() {
    return this.variazioniCausaliId;
  }

  public void setVariazioniCausaliId(String variazioniCausaliId) {
    this.variazioniCausaliId = variazioniCausaliId;
  }
}
