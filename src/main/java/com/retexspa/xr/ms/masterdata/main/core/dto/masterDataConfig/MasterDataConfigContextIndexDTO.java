package com.retexspa.xr.ms.masterdata.main.core.dto.masterDataConfig;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.LinkedList;
import java.util.UUID;

@JsonInclude(Include.NON_NULL)
public class MasterDataConfigContextIndexDTO {

  private String masterDataConfigContextId;

  private LinkedList<String> masterDataConfigIds;

  public MasterDataConfigContextIndexDTO() {}

  public MasterDataConfigContextIndexDTO(String masterDataConfigContextId) {
    this.masterDataConfigContextId = masterDataConfigContextId;
  }

  public static String getIdFromMasterDataConfigContext(String MasterDataConfigContextId) {
    return UUID.nameUUIDFromBytes(
            ("/MasterDataConfigContextIndex/" + MasterDataConfigContextId).getBytes())
        .toString();
  }

  public String getMasterDataConfigContextId() {
    return masterDataConfigContextId;
  }

  public LinkedList<String> getMasterDataConfigIds() {
    return masterDataConfigIds;
  }

  public void setMasterDataConfigIds(LinkedList<String> masterDataConfigIds) {
    this.masterDataConfigIds = masterDataConfigIds;
  }
}
