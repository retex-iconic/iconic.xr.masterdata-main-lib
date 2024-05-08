package com.retexspa.xr.ms.masterdata.main.core.queries;

public class TipologiaServizioByIdQuery {

  private final String tipologiaServizioId;

  public TipologiaServizioByIdQuery(String id) {
    this.tipologiaServizioId = id;
  }

  public String getTipologiaServizioId() {
    return tipologiaServizioId;
  }
}
