package com.retexspa.xr.ms.masterdata.main.core.queries;

public class AttributoAggregateGetEventsByIdQuery {
  private String attributoId;

  public AttributoAggregateGetEventsByIdQuery(String attributoId) {
    this.attributoId = attributoId;
  }

  public String getAttributoId() {
    return this.attributoId;
  }

  public void setAttributoId(String attributoId) {
    this.attributoId = attributoId;
  }
}
