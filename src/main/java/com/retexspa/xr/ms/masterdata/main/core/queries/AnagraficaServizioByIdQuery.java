package com.retexspa.xr.ms.masterdata.main.core.queries;

public class AnagraficaServizioByIdQuery {

  private final String enagraficaServizioId;

  public AnagraficaServizioByIdQuery(String id) {
    this.enagraficaServizioId = id;
  }

  public String getAnagraficaServizioId() {
    return enagraficaServizioId;
  }
}
