package com.retexspa.xr.ms.masterdata.main.core.dto.variazioneLog;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.LinkedList;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VariazioniCausaliIndexDTO {
  private String variazioniCausaliId;
  private LinkedList<String> figliIds;
  private LinkedList<String> variazioniCausaliOperazioniIds;
  private LinkedList<String> VariazioniRegoleMonitoraggioIds;

  public VariazioniCausaliIndexDTO() {}

  public VariazioniCausaliIndexDTO(String variazioniCausaliId) {
    this.variazioniCausaliId = variazioniCausaliId;
    this.variazioniCausaliOperazioniIds = new LinkedList<>();
    this.VariazioniRegoleMonitoraggioIds = new LinkedList<>();
  }

  public static String getIdFromVariazioniCausali(String variazioniCausaliId) {
    return UUID.nameUUIDFromBytes(("/VariazioniCausaliIndex/" + variazioniCausaliId).getBytes())
        .toString();
  }

  public String getVariazioniCausaliId() {
    return variazioniCausaliId;
  }

  public void setVariazioniCausaliId(String variazioniCausaliId) {
    this.variazioniCausaliId = variazioniCausaliId;
  }

  public LinkedList<String> getFigliIds() {
    return figliIds;
  }

  public void setFigliIds(LinkedList<String> figliIds) {
    this.figliIds = figliIds;
  }

  public LinkedList<String> getVariazioniCausaliOperazioniIds() {
    return variazioniCausaliOperazioniIds;
  }

  public void setVariazioniCausaliOperazioniIds(LinkedList<String> variazioniCausaliOperazioniIds) {
    this.variazioniCausaliOperazioniIds = variazioniCausaliOperazioniIds;
  }

  public LinkedList<String> getVariazioniRegoleMonitoraggioIds() {
    return VariazioniRegoleMonitoraggioIds;
  }

  public void setVariazioniRegoleMonitoraggioIds(
      LinkedList<String> variazioniRegoleMonitoraggioIds) {
    VariazioniRegoleMonitoraggioIds = variazioniRegoleMonitoraggioIds;
  }
}
