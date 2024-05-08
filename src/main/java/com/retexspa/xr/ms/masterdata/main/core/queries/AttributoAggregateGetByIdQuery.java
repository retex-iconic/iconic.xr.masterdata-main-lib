package com.retexspa.xr.ms.masterdata.main.core.queries;

public class AttributoAggregateGetByIdQuery {

  private String attributoId;

  public AttributoAggregateGetByIdQuery(String attributoId) {
    this.attributoId = attributoId;
  }

  public String getAttributoId() {
    return this.attributoId;
  }

  public void setAttributoId(String attributoId) {
    this.attributoId = attributoId;
  }
}
