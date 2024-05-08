package com.retexspa.xr.ms.masterdata.main.core.queries;

public class TipoTassonomiaAggregateGetEventsByIdQuery {
  private String tipoTassonomiaId;

  public TipoTassonomiaAggregateGetEventsByIdQuery(String tipoTassonomiaId) {
    this.tipoTassonomiaId = tipoTassonomiaId;
  }

  public String getTipoTassonomiaId() {
    return tipoTassonomiaId;
  }

  public void setTipoTassonomiaId(String tipoTassonomiaId) {
    this.tipoTassonomiaId = tipoTassonomiaId;
  }
}
