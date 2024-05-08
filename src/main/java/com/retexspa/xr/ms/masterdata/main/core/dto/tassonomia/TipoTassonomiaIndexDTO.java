package com.retexspa.xr.ms.masterdata.main.core.dto.tassonomia;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipoTassonomiaIndexDTO {

  private String tipoTassonomiaId;

  private Integer levelCounter;
  private Integer level;
  private List<String> nodoIds;

  private List<String> tassonomiaIds;
  private LinkedList<String> figliIds;

  public TipoTassonomiaIndexDTO() {}

  public TipoTassonomiaIndexDTO(String tipoTassonomiaId) {
    this.tipoTassonomiaId = tipoTassonomiaId;
    this.tassonomiaIds = new ArrayList<String>();
    this.nodoIds = new ArrayList<String>();
    this.figliIds = new LinkedList<>();
  }

  public static String getIdFromTipoTassonomia(String tipoTassonomiaId) {
    return UUID.nameUUIDFromBytes(("/TipoTassonomiaIndex/" + tipoTassonomiaId).getBytes())
        .toString();
  }

  public String getTipoTassonomiaId() {
    return tipoTassonomiaId;
  }

  public void setTipoTassonomiaId(String tipoTassonomiaId) {
    this.tipoTassonomiaId = tipoTassonomiaId;
  }

  public Integer getLevelCounter() {
    return levelCounter;
  }

  public void setLevelCounter(Integer levelCounter) {
    this.levelCounter = levelCounter;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public List<String> getNodoIds() {
    return nodoIds;
  }

  public void setNodoIds(List<String> nodoIds) {
    this.nodoIds = nodoIds;
  }

  public List<String> getTassonomiaIds() {
    return tassonomiaIds;
  }

  public void setTassonomiaIds(List<String> tassonomiaIds) {
    this.tassonomiaIds = tassonomiaIds;
  }

  public LinkedList<String> getFigliIds() {
    return figliIds;
  }

  public void setFigliIds(LinkedList<String> figliIds) {
    this.figliIds = figliIds;
  }
}
