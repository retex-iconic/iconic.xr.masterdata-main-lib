package com.retexspa.xr.ms.masterdata.main.core.queries;

public class IvaRtAggregateGetByIdQuery {

  private String ivaRtId;

  public IvaRtAggregateGetByIdQuery(String ivaRtId) {
    this.ivaRtId = ivaRtId;
  }

  public String getIvaRtId() {
    return this.ivaRtId;
  }

  public void setIvaRtId(String ivaRtId) {
    this.ivaRtId = ivaRtId;
  }
}
