package com.retexspa.xr.ms.masterdata.main.core.dto.articoloExtra;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.UUID;

@JsonInclude(Include.NON_NULL)
public class ArticoloExtraIndexDTO {

  private String articoloExtraId;

  public ArticoloExtraIndexDTO() {}

  public ArticoloExtraIndexDTO(String articoloExtraId) {
    this.articoloExtraId = articoloExtraId;
  }

  public static String getIdFromArticoloExtra(String articoloExtraId) {
    return UUID.nameUUIDFromBytes(("/ArticoloExtraIndex/" + articoloExtraId).getBytes()).toString();
  }

  public String getArticoloExtraId() {
    return this.articoloExtraId;
  }

  public void setArticoloExtraId(String articoloExtraId) {
    this.articoloExtraId = articoloExtraId;
  }
}
