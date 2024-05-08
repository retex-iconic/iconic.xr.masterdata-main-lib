package com.retexspa.xr.ms.masterdata.main.core.queries;

public class IvaAggregateGetEventsByIdQuery {
  private String ivaId;

  public IvaAggregateGetEventsByIdQuery(String ivaId) {
    this.ivaId = ivaId;
  }

  public String getIvaId() {
    return ivaId;
  }

  public void setIvaId(String ivaId) {
    this.ivaId = ivaId;
  }
}
