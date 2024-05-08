package com.retexspa.xr.ms.masterdata.main.core.queries;

public class TassonomiaByIdQuery {
  private String tassonomiaId;

  public TassonomiaByIdQuery(String tassonomiaId) {
    this.tassonomiaId = tassonomiaId;
  }

  public String getTassonomiaId() {
    return tassonomiaId;
  }

  public void setTassonomiaId(String tassonomiaId) {
    this.tassonomiaId = tassonomiaId;
  }
}
