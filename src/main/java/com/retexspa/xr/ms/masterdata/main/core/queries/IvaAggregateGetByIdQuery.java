package com.retexspa.xr.ms.masterdata.main.core.queries;

public class IvaAggregateGetByIdQuery {

  private String ivaId;

  public IvaAggregateGetByIdQuery(String ivaId) {
    this.ivaId = ivaId;
  }

  public String getIvaId() {
    return this.ivaId;
  }

  public void setIvaId(String ivaId) {
    this.ivaId = ivaId;
  }
}
