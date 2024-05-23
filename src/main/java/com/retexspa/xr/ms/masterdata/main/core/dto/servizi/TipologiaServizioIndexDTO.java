package com.retexspa.xr.ms.masterdata.main.core.dto.servizi;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.LinkedList;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipologiaServizioIndexDTO {
  private String TipologiaServizioId;
  private LinkedList<String> anagraficaServizioIds;
  private LinkedList<String> figliIds;

  public TipologiaServizioIndexDTO() {
  }

  public TipologiaServizioIndexDTO(String TipologiaServizioId) {
    this.TipologiaServizioId = TipologiaServizioId;
  }

  public static String getIdFromTipologiaServizio(String TipologiaServizioId) {
    return UUID.nameUUIDFromBytes(("/TipologiaServizioIndex/" + TipologiaServizioId).getBytes())
        .toString();
  }

  public String getTipologiaServizioId() {
    return this.TipologiaServizioId;
  }

  public void setTipologiaServizioId(String TipologiaServizioId) {
    this.TipologiaServizioId = TipologiaServizioId;
  }

  public LinkedList<String> getAnagraficaServizioIds() {
    return anagraficaServizioIds;
  }

  public void setAnagraficaServizioIds(LinkedList<String> anagraficaServizioIds) {
    this.anagraficaServizioIds = anagraficaServizioIds;
  }

  public LinkedList<String> getFigliIds() {
    return figliIds;
  }

  public void setFigliIds(LinkedList<String> figliIds) {
    this.figliIds = figliIds;
  }

  public static String getDetailNameAnagraficaServizio() {
    return "anagraficaServizioIds";
  }

  public static String getDetailNameFigli() {
    return "figliIds";
  }

}
