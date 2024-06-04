package com.retexspa.xr.ms.masterdata.main.core.dto.attributo;

import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AttributoIndexDTO extends com.retexspa.xr.ms.main.core.dto.attributo.AttributoIndexDTO {

  // DONE IN INDEXAGGREGATE AND EVENTHANDLER
  private LinkedList<String> articoloVenditaIds;
  private LinkedList<String> configIds;

  public AttributoIndexDTO() {
  }

  public AttributoIndexDTO(String attributoId) {
    super(attributoId);
  }

  public LinkedList<String> getConfigIds() {
    return configIds;
  }

  public void setConfigIds(LinkedList<String> anagraficaServizioIds) {
    this.configIds = anagraficaServizioIds;
  }

  public LinkedList<String> getArticoloVenditaIds() {
    return articoloVenditaIds;
  }

  public void setArticoloVenditaIds(LinkedList<String> articoloVenditaIds) {
    this.articoloVenditaIds = articoloVenditaIds;
  }

  public static String getDetailNameArticoloVendita() {
    return "articoloVenditaIds";
  }

  public static String getDetailNameConfig() {
    return "configIds";
  }
}
