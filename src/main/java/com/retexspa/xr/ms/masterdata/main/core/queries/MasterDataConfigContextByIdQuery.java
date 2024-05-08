package com.retexspa.xr.ms.masterdata.main.core.queries;

public class MasterDataConfigContextByIdQuery {

  private String contextId;

  public MasterDataConfigContextByIdQuery(String contextId) {
    this.contextId = contextId;
  }

  public String getMasterDataConfigId() {
    return contextId;
  }

  public void setMasterDataConfigId(String contextId) {
    this.contextId = contextId;
  }
}
