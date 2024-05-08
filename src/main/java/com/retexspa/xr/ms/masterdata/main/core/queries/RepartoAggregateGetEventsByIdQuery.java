package com.retexspa.xr.ms.masterdata.main.core.queries;

public class RepartoAggregateGetEventsByIdQuery {
  private String repartoId;

  public RepartoAggregateGetEventsByIdQuery(String repartoId) {
    this.repartoId = repartoId;
  }

  public String getRepartoId() {
    return repartoId;
  }

  public void setRepartoId(String repartoId) {
    this.repartoId = repartoId;
  }
}
