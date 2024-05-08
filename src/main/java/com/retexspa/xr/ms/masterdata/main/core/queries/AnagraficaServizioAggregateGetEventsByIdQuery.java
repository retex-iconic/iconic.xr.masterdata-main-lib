package com.retexspa.xr.ms.masterdata.main.core.queries;

public class AnagraficaServizioAggregateGetEventsByIdQuery {
  private String anagraficaServizioId;

  public AnagraficaServizioAggregateGetEventsByIdQuery(String anagraficaServizioId) {
    this.anagraficaServizioId = anagraficaServizioId;
  }

  public String getAnagraficaServizioId() {
    return anagraficaServizioId;
  }

  public void setAnagraficaServizioId(String anagraficaServizioId) {
    this.anagraficaServizioId = anagraficaServizioId;
  }
}
