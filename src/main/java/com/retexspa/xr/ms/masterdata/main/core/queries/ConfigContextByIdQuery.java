package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ConfigContextByIdQuery {

  private String contextId;

  public ConfigContextByIdQuery(String contextId) {
    this.contextId = contextId;
  }

  public String getConfigId() {
    return contextId;
  }

  public void setConfigId(String contextId) {
    this.contextId = contextId;
  }
}
