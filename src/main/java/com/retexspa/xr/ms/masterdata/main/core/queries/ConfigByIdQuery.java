package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ConfigByIdQuery {

  private String configId;

  public ConfigByIdQuery(String configId) {
    this.configId = configId;
  }

  public String getGerarchiaId() {
    return configId;
  }

  public void setGerarchiaId(String configId) {
    this.configId = configId;
  }

  public String getConfigId() {
    return configId;
  }

  public void setConfigId(String configId) {
    this.configId = configId;
  }
}
