package com.retexspa.xr.ms.masterdata.main.core.queries;

public class TipoTassonomiaByIdQuery {

  private final String tipoTassonomiaId;

  public TipoTassonomiaByIdQuery(String tipoTassonomiaId) {
    this.tipoTassonomiaId = tipoTassonomiaId;
  }

  public String getTipoTassonomiaId() {
    return tipoTassonomiaId;
  }
}
