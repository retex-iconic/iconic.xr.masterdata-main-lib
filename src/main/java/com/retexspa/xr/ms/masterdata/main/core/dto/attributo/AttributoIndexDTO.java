package com.retexspa.xr.ms.masterdata.main.core.dto.attributo;

import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AttributoIndexDTO extends com.retexspa.xr.ms.main.core.dto.attributo.AttributoIndexDTO {

  // DONE IN INDEXAGGREGATE AND EVENTHANDLER
  private LinkedList<String> articoloVenditaIds;
  private LinkedList<String> masterDataConfigIds;

  public AttributoIndexDTO() {
  }

  public AttributoIndexDTO(String attributoId) {
    super(attributoId);
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

  public static String getDetailNameArticoloVendita() {
    return "ArticoloVendita";
  }

  public static String getDetailNameMasterDataConfig() {
    return "MasterDataConfig";
  }
}
