package com.retexspa.xr.ms.masterdata.main.core.queries;

public class TassonomiaAggregateGetEventsByIdQuery {
  private String tassonomiaId;

  public TassonomiaAggregateGetEventsByIdQuery(String tassonomiaId) {
    this.tassonomiaId = tassonomiaId;
  }

  public String getTassonomiaId() {
    return tassonomiaId;
  }

  public void setTassonomiaId(String tassonomiaId) {
    this.tassonomiaId = tassonomiaId;
  }
}
