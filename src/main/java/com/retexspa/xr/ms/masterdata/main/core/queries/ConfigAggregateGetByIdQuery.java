package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ConfigAggregateGetByIdQuery {

  private String configId;

  public ConfigAggregateGetByIdQuery(String configId) {
    this.configId = configId;
  }

  public String getConfigId() {
    return this.configId;
  }

  public void setConfigId(String configId) {
    this.configId = configId;
  }
}
