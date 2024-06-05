package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ConfigContextAggregateGetEventsByIdQuery {
  private String configContextId;

  public ConfigContextAggregateGetEventsByIdQuery(String configContextId) {
    this.configContextId = configContextId;
  }

  public String getConfigContextId() {
    return configContextId;
  }

  public void setConfigContextId(String configContextId) {
    this.configContextId = configContextId;
  }
}
