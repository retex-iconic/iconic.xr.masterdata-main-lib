package com.retexspa.xr.ms.masterdata.main.core.queries;

public class RepartoAggregateGetByIdQuery {

  private String repartoId;

  public RepartoAggregateGetByIdQuery(String repartoId) {
    this.repartoId = repartoId;
  }

  public String getRepartoId() {
    return this.repartoId;
  }

  public void setRepartoId(String repartoId) {
    this.repartoId = repartoId;
  }
}
