package com.retexspa.xr.ms.masterdata.main.core.dto.masterDataConfig;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.LinkedList;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MasterDataConfigIndexDTO {

  private String masterDataConfigId;
  private LinkedList<String> nodoIds;
  private LinkedList<String> artVenditaStatoIds;
  private LinkedList<String> artVenditaTipoIds;
  private LinkedList<String> artVenditaSottotipoIds;

  public MasterDataConfigIndexDTO() {}

  public MasterDataConfigIndexDTO(String masterDataConfigId) {
    this.masterDataConfigId = masterDataConfigId;
  }

  public static String getIdFromMasterDataConfig(String masterDataConfigId) {
    return UUID.nameUUIDFromBytes(("/MasterDataConfigIndex/" + masterDataConfigId).getBytes())
        .toString();
  }

  public String getMasterDataConfigId() {
    return masterDataConfigId;
  }

  public void setMasterDataConfigId(String masterDataConfigId) {
    this.masterDataConfigId = masterDataConfigId;
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
}
