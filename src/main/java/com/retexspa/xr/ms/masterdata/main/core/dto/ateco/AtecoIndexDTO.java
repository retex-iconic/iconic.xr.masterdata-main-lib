package com.retexspa.xr.ms.masterdata.main.core.dto.ateco;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.LinkedList;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AtecoIndexDTO {

  private String atecoId;

  private LinkedList<String> ivaRTIds;
  private LinkedList<String> figliIds;

  public AtecoIndexDTO() {}

  public AtecoIndexDTO(String atecoId) {
    this.atecoId = atecoId;
  }

  public static String getIdFromAteco(String atecoId) {
    return UUID.nameUUIDFromBytes(("/AtecoIndex/" + atecoId).getBytes()).toString();
  }

  public String getAtecoId() {
    return atecoId;
  }

  public void setAtecoId(String atecoId) {
    this.atecoId = atecoId;
  }

  public LinkedList<String> getIvaRTIds() {
    return ivaRTIds;
  }

  public void setIvaRTIds(LinkedList<String> ivaRTIds) {
    this.ivaRTIds = ivaRTIds;
  }

  public LinkedList<String> getFigliIds() {
    return figliIds;
  }

  public void setFigliIds(LinkedList<String> figliIds) {
    this.figliIds = figliIds;
  }
}
