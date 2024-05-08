package com.retexspa.xr.ms.masterdata.main.core.queries;

public class MasterDataConfigByIdQuery {

  private String masterDataConfigId;

  public MasterDataConfigByIdQuery(String masterDataConfigId) {
    this.masterDataConfigId = masterDataConfigId;
  }

  public String getGerarchiaId() {
    return masterDataConfigId;
  }

  public void setGerarchiaId(String masterDataConfigId) {
    this.masterDataConfigId = masterDataConfigId;
  }

  public String getMasterDataConfigId() {
    return masterDataConfigId;
  }

  public void setMasterDataConfigId(String masterDataConfigId) {
    this.masterDataConfigId = masterDataConfigId;
  }
}
