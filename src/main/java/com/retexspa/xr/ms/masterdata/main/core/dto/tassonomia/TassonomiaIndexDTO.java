package com.retexspa.xr.ms.masterdata.main.core.dto.tassonomia;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class TassonomiaIndexDTO {

  private String tassonomiaId;
  private Integer levelCounter;
  private Integer level;
  private LinkedList<String> articoloTassonomiaIds;
  private LinkedList<String> nodoIds;
  private LinkedList<String> figliIds;

  public TassonomiaIndexDTO() {}

  public TassonomiaIndexDTO(String tassonomiaId) {
    this.tassonomiaId = tassonomiaId;
    this.levelCounter = 0;
    this.level = 0;
    // MOVE LISTS INIT TO INDEX AGGREGATE TODO
    this.nodoIds = new LinkedList<String>();
    this.figliIds = new LinkedList<String>();
    this.articoloTassonomiaIds = new LinkedList<String>();
    this.figliIds = new LinkedList<String>();
  }

  public static String getIdFromTassonomia(String tassonomiaId) {
    return UUID.nameUUIDFromBytes(("/TassonomiaIndex/" + tassonomiaId).getBytes()).toString();
  }

  public Integer getLevelCounter() {
    return this.levelCounter;
  }

  public void setLevelCounter(Integer levelCounter) {
    this.levelCounter = levelCounter;
  }

  public Integer getLevel() {
    return this.level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public LinkedList<String> getNodoIds() {
    return this.nodoIds;
  }

  public void setNodoIds(LinkedList<String> nodoIds) {
    this.nodoIds = nodoIds;
  }

  public String getTassonomiaId() {
    return tassonomiaId;
  }

  public void setTassonomiaId(String tassonomiaId) {
    this.tassonomiaId = tassonomiaId;
  }

  public LinkedList<String> getArticoloTassonomiaIds() {
    return articoloTassonomiaIds;
  }

  public void setArticoloTassonomiaIds(LinkedList<String> articoloTassonomiaIds) {
    this.articoloTassonomiaIds = articoloTassonomiaIds;
  }

  public LinkedList<String> getFigliIds() {
    return figliIds;
  }

  public void setFigliIds(LinkedList<String> figliIds) {
    this.figliIds = figliIds;
  }

  public static String getDetailNameArticoloTassonomia() {
    return "articoloTassonomiaIds";
  }

  public static String getDetailNameNodo() {
    return "nodoIds";
  }

  public static String getDetailNameFigli() {
    return "figliIds";
  }
}
