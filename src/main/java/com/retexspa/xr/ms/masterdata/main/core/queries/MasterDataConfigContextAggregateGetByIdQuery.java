package com.retexspa.xr.ms.masterdata.main.core.queries;

public class MasterDataConfigContextAggregateGetByIdQuery {

  private String masterDataConfigContextId;

  public MasterDataConfigContextAggregateGetByIdQuery(String masterDataConfigContextId) {
    this.masterDataConfigContextId = masterDataConfigContextId;
  }

  public String getMasterDataConfigContextId() {
    return this.masterDataConfigContextId;
  }

  public void setMasterDataConfigContextId(String masterDataConfigContextId) {
    this.masterDataConfigContextId = masterDataConfigContextId;
  }
}
