package com.retexspa.xr.ms.masterdata.main.core.queries;

public class NegozioAggregateGetByIdQuery {
  private String negozioId;

  public NegozioAggregateGetByIdQuery(String negozioId) {
    this.negozioId = negozioId;
  }

  public String getNegozioId() {
    return negozioId;
  }

  public void setNegozioId(String negozioId) {
    this.negozioId = negozioId;
  }
}
