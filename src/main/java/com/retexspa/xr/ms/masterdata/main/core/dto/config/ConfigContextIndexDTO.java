package com.retexspa.xr.ms.masterdata.main.core.dto.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.LinkedList;
import java.util.UUID;

@JsonInclude(Include.NON_NULL)
public class ConfigContextIndexDTO {

  private String configContextId;

  private LinkedList<String> configIds;

  public ConfigContextIndexDTO() {}

  public ConfigContextIndexDTO(String configContextId) {
    this.configContextId = configContextId;
  }

  public static String getIdFromConfigContext(String configContextId) {
    return UUID.nameUUIDFromBytes(
            ("/ConfigContextIndex/" + configContextId).getBytes())
        .toString();
  }

  public String getConfigContextId() {
    return configContextId;
  }

  public LinkedList<String> getConfigIds() {
    return configIds;
  }

  public void setConfigIds(LinkedList<String> configIds) {
    this.configIds = configIds;
  }

  public static String getDetailNameConfig() {
    return "configIds";
  }

}
