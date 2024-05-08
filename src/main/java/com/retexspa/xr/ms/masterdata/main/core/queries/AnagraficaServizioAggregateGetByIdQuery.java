package com.retexspa.xr.ms.masterdata.main.core.queries;

public class AnagraficaServizioAggregateGetByIdQuery {
  private String anagraficaServizioId;

  public AnagraficaServizioAggregateGetByIdQuery(String anagraficaServizioId) {
    this.anagraficaServizioId = anagraficaServizioId;
  }

  public String getAnagraficaServizioId() {
    return this.anagraficaServizioId;
  }

  public void setAnagraficaServizioId(String anagraficaServizioId) {
    this.anagraficaServizioId = anagraficaServizioId;
  }
}
