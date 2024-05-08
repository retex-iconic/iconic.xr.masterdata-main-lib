package com.retexspa.xr.ms.masterdata.main.core.queries;

public class IvaRtAggregateGetEventsByIdQuery {
  private String ivaRtId;

  public IvaRtAggregateGetEventsByIdQuery(String ivaRtId) {
    this.ivaRtId = ivaRtId;
  }

  public String getIvaRtId() {
    return ivaRtId;
  }

  public void setIvaRtId(String ivaRtId) {
    this.ivaRtId = ivaRtId;
  }
}
