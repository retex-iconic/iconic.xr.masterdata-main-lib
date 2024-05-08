package com.retexspa.xr.ms.masterdata.main.core.queries;

public class TipoTassonomiaAggregateGetByIdQuery {
  private String tipoTassonomiaId;

  public TipoTassonomiaAggregateGetByIdQuery(String tipoTassonomiaId) {
    this.tipoTassonomiaId = tipoTassonomiaId;
  }

  public String getTipoTassonomiaId() {
    return tipoTassonomiaId;
  }

  public void setTipoTassonomiaId(String tipoTassonomiaId) {
    this.tipoTassonomiaId = tipoTassonomiaId;
  }
}
