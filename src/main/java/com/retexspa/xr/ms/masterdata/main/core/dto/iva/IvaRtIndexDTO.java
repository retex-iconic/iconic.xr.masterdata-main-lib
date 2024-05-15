package com.retexspa.xr.ms.masterdata.main.core.dto.iva;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.LinkedList;
import java.util.UUID;

@JsonInclude(Include.NON_NULL)
public class IvaRtIndexDTO {

  private String ivaRtId;
  private LinkedList<String> figliIds;

  public IvaRtIndexDTO() {}

  public IvaRtIndexDTO(String ivaRtId) {
    // this.codNeg = codNeg;
    this.ivaRtId = ivaRtId;
  }

  public static String getIdFromIvaRt(String ivaRtId) {
    return UUID.nameUUIDFromBytes(("/IvaRtIndex/" + ivaRtId).getBytes()).toString();
  }

  public String getIvaRtId() {
    return this.ivaRtId;
  }

  public void setIvaRtId(String ivaId) {
    this.ivaRtId = ivaId;
  }

  public LinkedList<String> getFigliIds() {
    return figliIds;
  }

  public void setFigliIds(LinkedList<String> figliIds) {
    this.figliIds = figliIds;
  }

  public static String getDetailNameFigli() {
    return "figliIds";
  }
}
