package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ConfigContextAggregateGetByIdQuery {

  private String configContextId;

  public ConfigContextAggregateGetByIdQuery(String configContextId) {
    this.configContextId = configContextId;
  }

  public String getConfigContextId() {
    return this.configContextId;
  }

  public void setConfigContextId(String configContextId) {
    this.configContextId = configContextId;
  }
}
