package com.retexspa.xr.ms.masterdata.main.core.queries;

public class VariazioniCausaliOperazioniAggregateGetEventsByIdQuery {
  private String variazioniCausaliOperazioniId;

  public VariazioniCausaliOperazioniAggregateGetEventsByIdQuery(
      String variazioniCausaliOperazioniId) {
    this.variazioniCausaliOperazioniId = variazioniCausaliOperazioniId;
  }

  public String getVariazioniCausaliOperazioniId() {
    return variazioniCausaliOperazioniId;
  }

  public void setVariazioniCausaliOperazioniId(String variazioniCausaliOperazioniId) {
    this.variazioniCausaliOperazioniId = variazioniCausaliOperazioniId;
  }
}
