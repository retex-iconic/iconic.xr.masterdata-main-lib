package com.retexspa.xr.ms.masterdata.main.core.queries;

public class EsclusioniFpServizioAggregateGetByIdQuery {

  private String esclusioniFpServizioId;

  public EsclusioniFpServizioAggregateGetByIdQuery(String esclusioniFpServizioId) {
    this.esclusioniFpServizioId = esclusioniFpServizioId;
  }

  public String getEsclusioniFpServizioId() {
    return this.esclusioniFpServizioId;
  }

  public void setEsclusioniFpServizioId(String esclusioniFpServizioId) {
    this.esclusioniFpServizioId = esclusioniFpServizioId;
  }
}
