package com.retexspa.xr.ms.masterdata.main.core.queries;

public class TipologiaServizioAggregateGetEventsByIdQuery {
  private String tipologiaServizioId;

  public TipologiaServizioAggregateGetEventsByIdQuery(String tipologiaServizioId) {
    this.tipologiaServizioId = tipologiaServizioId;
  }

  public String getTipologiaServizioId() {
    return tipologiaServizioId;
  }

  public void setTipologiaServizioId(String tipologiaServizioId) {
    this.tipologiaServizioId = tipologiaServizioId;
  }
}
