package com.retexspa.xr.ms.masterdata.main.core.dto.servizi;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.LinkedList;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnagraficaServizioIndexDTO {

  private String anagraficaServizioId;
  private LinkedList<String> articoloInfoServizioIds;
  private LinkedList<String> commissioneServizioIds;
  private LinkedList<String> esclusioniFPServizioIds;
  private LinkedList<String> figliIds;

  public AnagraficaServizioIndexDTO() {
  }

  public AnagraficaServizioIndexDTO(String anagraficaServizioId) {
    this.anagraficaServizioId = anagraficaServizioId;
  }

  public static String getIdFromAnagraficaServizio(String anagraficaServizioId) {
    return UUID.nameUUIDFromBytes(("/AnagraficaServizioIndex/" + anagraficaServizioId).getBytes())
        .toString();
  }

  public String getAnagraficaServizioId() {
    return this.anagraficaServizioId;
  }

  public void setAnagraficaServizioId(String anagraficaServizioId) {
    this.anagraficaServizioId = anagraficaServizioId;
  }

  public LinkedList<String> getArticoloInfoServizioIds() {
    return articoloInfoServizioIds;
  }

  public void setArticoloInfoServizioIds(LinkedList<String> articoloInfoServizioIds) {
    this.articoloInfoServizioIds = articoloInfoServizioIds;
  }

  public LinkedList<String> getCommissioneServizioIds() {
    return commissioneServizioIds;
  }

  public void setCommissioneServizioIds(LinkedList<String> commissioneServizioIds) {
    this.commissioneServizioIds = commissioneServizioIds;
  }

  public LinkedList<String> getEsclusioniFPServizioIds() {
    return esclusioniFPServizioIds;
  }

  public void setEsclusioniFPServizioIds(LinkedList<String> esclusioniFPServizioIds) {
    this.esclusioniFPServizioIds = esclusioniFPServizioIds;
  }

  public LinkedList<String> getFigliIds() {
    return figliIds;
  }

  public void setFigliIds(LinkedList<String> figliIds) {
    this.figliIds = figliIds;
  }

  public static String getDetailNameArticoloInfoServizio() {
    return "articoloInfoServizioIds";
  }

  public static String getDetailNameCommissioneServizio() {
    return "commissioneServizioIds";
  }

  public static String getDetailNameEsclusioniFPServizio() {
    return "esclusioniFPServizioIds";
  }

  public static String getDetailNameFigli() {
    return "figliIds";
  }

}
