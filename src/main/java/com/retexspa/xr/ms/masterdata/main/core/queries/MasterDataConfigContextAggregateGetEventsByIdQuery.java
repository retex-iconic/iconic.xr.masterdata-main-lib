package com.retexspa.xr.ms.masterdata.main.core.queries;

public class MasterDataConfigContextAggregateGetEventsByIdQuery {
  private String masterDataConfigContextId;

  public MasterDataConfigContextAggregateGetEventsByIdQuery(String masterDataConfigContextId) {
    this.masterDataConfigContextId = masterDataConfigContextId;
  }

  public String getMasterDataConfigContextId() {
    return masterDataConfigContextId;
  }

  public void setMasterDataConfigContextId(String masterDataConfigContextId) {
    this.masterDataConfigContextId = masterDataConfigContextId;
  }
}
