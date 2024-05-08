package com.retexspa.xr.ms.masterdata.main.core.queries;

public class NegozioAggregateGetEventsByIdQuery {
  private String negozioId;

  public NegozioAggregateGetEventsByIdQuery(String negozioId) {
    this.negozioId = negozioId;
  }

  public String getNegozioId() {
    return negozioId;
  }

  public void setNegozioId(String negozioId) {
    this.negozioId = negozioId;
  }
}
