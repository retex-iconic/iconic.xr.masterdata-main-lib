package com.retexspa.xr.ms.masterdata.main.core.queries;

public class TassonomiaAggregateGetByIdQuery {
  private String tassonomiaId;

  public TassonomiaAggregateGetByIdQuery(String tassonomiaId) {
    this.tassonomiaId = tassonomiaId;
  }

  public String getTassonomiaId() {
    return tassonomiaId;
  }

  public void setTassonomiaId(String tassonomiaId) {
    this.tassonomiaId = tassonomiaId;
  }
}
