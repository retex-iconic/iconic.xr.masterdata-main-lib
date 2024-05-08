package com.retexspa.xr.ms.masterdata.main.core.queries;

public class MasterDataConfigAggregateGetEventsByIdQuery {

  private String masterDataConfigId;

  public MasterDataConfigAggregateGetEventsByIdQuery(String masterDataConfigId) {
    this.masterDataConfigId = masterDataConfigId;
  }

  public String getMasterDataConfigId() {
    return this.masterDataConfigId;
  }

  public void setMasterDataConfigId(String masterDataConfigId) {
    this.masterDataConfigId = masterDataConfigId;
  }
}
