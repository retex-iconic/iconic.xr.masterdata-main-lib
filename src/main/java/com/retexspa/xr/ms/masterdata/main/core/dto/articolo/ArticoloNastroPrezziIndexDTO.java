package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.LinkedList;
import java.util.UUID;

@JsonInclude(Include.NON_NULL)
public class ArticoloNastroPrezziIndexDTO {

  private String articoloNastroPrezziId;
  private LinkedList<String> figliIds;

  public ArticoloNastroPrezziIndexDTO() {}

  public ArticoloNastroPrezziIndexDTO(String articoloNastroPrezziId) {
    this.articoloNastroPrezziId = articoloNastroPrezziId;
  }

  public static String getIdFromArticoloNastroPrezzi(String articoloNastroPrezziId) {
    return UUID.nameUUIDFromBytes(
            ("/ArticoloNastroPrezziIndex/" + articoloNastroPrezziId).getBytes())
        .toString();
  }

  public String getArticoloNastroPrezziId() {
    return this.articoloNastroPrezziId;
  }

  public void setArticoloNastroPrezziId(String articoloNastroPrezziId) {
    this.articoloNastroPrezziId = articoloNastroPrezziId;
  }

  public LinkedList<String> getFigliIds() {
    return figliIds;
  }

  public void setFigliIds(LinkedList<String> figliIds) {
    this.figliIds = figliIds;
  }

  public static String getDetailNameArticoloNastroPrezzi() {
    return "ArticoloNastroPrezzi";
  }

  public static String getDetailNameArticoloNastroPrezzi2() {
    return "Articolo Nastro Prezzi";
  }

  public static String getDetailNameArticoloNastroPrezziAggregate() {
    return "ArticoloNastroPrezziAggregate";
  }
}
