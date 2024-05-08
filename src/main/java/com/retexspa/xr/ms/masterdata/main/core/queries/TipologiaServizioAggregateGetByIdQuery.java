package com.retexspa.xr.ms.masterdata.main.core.queries;

public class TipologiaServizioAggregateGetByIdQuery {
  private String tipologiaServizioId;

  public TipologiaServizioAggregateGetByIdQuery(String tipologiaServizioId) {
    this.tipologiaServizioId = tipologiaServizioId;
  }

  public String getTipologiaServizioId() {
    return tipologiaServizioId;
  }

  public void setTipologiaServizioId(String tipologiaServizioId) {
    this.tipologiaServizioId = tipologiaServizioId;
  }
}
