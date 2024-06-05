package com.retexspa.xr.ms.masterdata.main.core.dto.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.LinkedList;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigIndexDTO {

  private String configId;
  private LinkedList<String> nodoIds;
  private LinkedList<String> artVenditaStatoIds;
  private LinkedList<String> artVenditaTipoIds;
  private LinkedList<String> artVenditaSottotipoIds;

  public ConfigIndexDTO() {}

  public ConfigIndexDTO(String configId) {
    this.configId = configId;
  }

  public static String getIdFromConfig(String configId) {
    return UUID.nameUUIDFromBytes(("/ConfigIndex/" + configId).getBytes())
        .toString();
  }

  public String getConfigId() {
    return configId;
  }

  public void setConfigId(String configId) {
    this.configId = configId;
  }

  public LinkedList<String> getNodoIds() {
    return nodoIds;
  }

  public void setNodoIds(LinkedList<String> nodoIds) {
    this.nodoIds = nodoIds;
  }

  public LinkedList<String> getArtVenditaStatoIds() {
    return artVenditaStatoIds;
  }

  public void setArtVenditaStatoIds(LinkedList<String> artVenditaStatoIds) {
    this.artVenditaStatoIds = artVenditaStatoIds;
  }

  public LinkedList<String> getArtVenditaTipoIds() {
    return artVenditaTipoIds;
  }

  public void setArtVenditaTipoIds(LinkedList<String> artVenditaTipoIds) {
    this.artVenditaTipoIds = artVenditaTipoIds;
  }

  public LinkedList<String> getArtVenditaSottotipoIds() {
    return artVenditaSottotipoIds;
  }

  public void setArtVenditaSottotipoIds(LinkedList<String> artVenditaSottotipoIds) {
    this.artVenditaSottotipoIds = artVenditaSottotipoIds;
  }

  public static String getDetailNameNodo() {
    return "nodoIds";
  }
}
