package com.retexspa.xr.ms.masterdata.main.core.dto.reparto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.LinkedList;
import java.util.UUID;

@JsonInclude(Include.NON_NULL)
public class RepartoIndexDTO {

  private String repartoId;
  // private List<String> negozioIds;
  // private List<String> repartoVenditaIds;
  private LinkedList<String> articoloVenditaIds;
  private LinkedList<String> figliIds;

  public RepartoIndexDTO() {
  }

  public RepartoIndexDTO(String repartoId) {
    this.repartoId = repartoId;
  }

  public static String getIdFromReparto(String repartoId) {
    return UUID.nameUUIDFromBytes(("/RepartoIndex/" + repartoId).getBytes()).toString();
  }

  public String getRepartoId() {
    return this.repartoId;
  }

  public void setRepartoId(String repartoId) {
    this.repartoId = repartoId;
  }

  public LinkedList<String> getArticoloVenditaIds() {
    return articoloVenditaIds;
  }

  public void setArticoloVenditaIds(LinkedList<String> articoloVenditaIds) {
    this.articoloVenditaIds = articoloVenditaIds;
  }

  public LinkedList<String> getFigliIds() {
    return figliIds;
  }

  public void setFigliIds(LinkedList<String> figliIds) {
    this.figliIds = figliIds;
  }

  public static String getDetailNameReparto() {
    return "Reparto";
  }

  public static String getDetailNameRepartoAggregate() {
    return "RepartoAggregate";
  }

  public static String getDetailNameArticoloVenditaIds() {
    return "articoloVenditaIds";
  }

  public static String getDetailNameFigliIds() {
    return "figliIds";
  }

}
