package com.retexspa.xr.ms.masterdata.main.core.dto.iva;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.LinkedList;
import java.util.UUID;

@JsonInclude(Include.NON_NULL)
public class IvaIndexDTO {

  private String ivaId;
  private LinkedList<String> ivaRtIds;
  private LinkedList<String> articoloVenditaIds;
  private LinkedList<String> repartoIds;
  private LinkedList<String> figliIds;

  public IvaIndexDTO() {
  }

  public IvaIndexDTO(String ivaId) {
    // this.codNeg = codNeg;
    this.ivaId = ivaId;
  }

  public static String getIdFromIva(String ivaId) {
    return UUID.nameUUIDFromBytes(("/IvaIndex/" + ivaId).getBytes()).toString();
  }

  public String getIvaId() {
    return this.ivaId;
  }

  public void setIvaId(String ivaId) {
    this.ivaId = ivaId;
  }

  public LinkedList<String> getIvaRtIds() {
    return ivaRtIds;
  }

  public void setIvaRtIds(LinkedList<String> ivaRtIds) {
    this.ivaRtIds = ivaRtIds;
  }

  public LinkedList<String> getArticoloVenditaIds() {
    return articoloVenditaIds;
  }

  public void setArticoloVenditaIds(LinkedList<String> articoloVenditaIds) {
    this.articoloVenditaIds = articoloVenditaIds;
  }

  public LinkedList<String> getRepartoIds() {
    return repartoIds;
  }

  public void setRepartoIds(LinkedList<String> repartoIds) {
    this.repartoIds = repartoIds;
  }

  public LinkedList<String> getFigliIds() {
    return figliIds;
  }

  public void setFigliIds(LinkedList<String> figliIds) {
    this.figliIds = figliIds;
  }

  public static String getDetailNameIvaRtIds() {
    return "ivaRtIds";
  }

  public static String getDetailNameArticoloVenditaIds() {
    return "articoloVenditaIds";
  }

  public static String getDetailNameRepartoIds() {
    return "repartoIds";
  }

  public static String getDetailNameFigliIds() {
    return "figliIds";
  }

}
