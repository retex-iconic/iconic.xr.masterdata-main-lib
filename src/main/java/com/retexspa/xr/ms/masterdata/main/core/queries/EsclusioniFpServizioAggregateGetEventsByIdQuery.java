package com.retexspa.xr.ms.masterdata.main.core.queries;

public class EsclusioniFpServizioAggregateGetEventsByIdQuery {
  private String esclusioniFpServizio;

  public EsclusioniFpServizioAggregateGetEventsByIdQuery(String esclusioniFpServizio) {
    this.esclusioniFpServizio = esclusioniFpServizio;
  }

  public String getEsclusioniFpServizioId() {
    return esclusioniFpServizio;
  }

  public void setEsclusioniFpServizioId(String esclusioniFpServizio) {
    this.esclusioniFpServizio = esclusioniFpServizio;
  }
}
