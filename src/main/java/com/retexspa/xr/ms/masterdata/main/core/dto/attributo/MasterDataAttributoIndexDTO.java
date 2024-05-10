package com.retexspa.xr.ms.masterdata.main.core.dto.attributo;

import java.util.LinkedList;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MasterDataAttributoIndexDTO {

  private String attributoId;
  // DONE IN INDEXAGGREGATE AND EVENTHANDLER
  private LinkedList<String> articoloVenditaIds;
  private LinkedList<String> masterDataConfigIds;

  public MasterDataAttributoIndexDTO() {}

  public MasterDataAttributoIndexDTO(String attributoId) {
    this.attributoId = attributoId;
  }

  public static String getIdFromAttributo(String attributoId) {
    return UUID.nameUUIDFromBytes(("/MasterDataAttributoIndex/" + attributoId).getBytes()).toString();
  }

  public String getAttributoId() {
    return this.attributoId;
  }

  public void setAttributoId(String attributoId) {
    this.attributoId = attributoId;
  }

  public LinkedList<String> getMasterDataConfigIds() {
    return masterDataConfigIds;
  }

  public void setMasterDataConfigIds(LinkedList<String> anagraficaServizioIds) {
    this.masterDataConfigIds = anagraficaServizioIds;
  }

  public LinkedList<String> getArticoloVenditaIds() {
    return articoloVenditaIds;
  }

  public void setArticoloVenditaIds(LinkedList<String> articoloVenditaIds) {
    this.articoloVenditaIds = articoloVenditaIds;
  }
}
