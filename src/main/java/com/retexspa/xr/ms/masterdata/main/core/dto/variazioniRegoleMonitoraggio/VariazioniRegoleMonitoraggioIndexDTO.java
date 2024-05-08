package com.retexspa.xr.ms.masterdata.main.core.dto.variazioniRegoleMonitoraggio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VariazioniRegoleMonitoraggioIndexDTO {
  private String variazioniRegoleMonitoraggioId;

  private LinkedList<String> variazioniCausaliOperazioniIds;

  public VariazioniRegoleMonitoraggioIndexDTO(String variazioniRegoleMonitoraggioId) {
    this.variazioniRegoleMonitoraggioId = variazioniRegoleMonitoraggioId;
    //        this.casualeIds = new ArrayList<String>();
  }

  public static String getIdFromVariazioniRegoleMonitoraggio(
      String variazioniRegoleMonitoraggioId) {
    return UUID.nameUUIDFromBytes(
            ("/VariazioniRegoleMonitoraggioIndex/" + variazioniRegoleMonitoraggioId).getBytes())
        .toString();
  }

  public String getVariazioniRegoleMonitoraggioId() {
    return variazioniRegoleMonitoraggioId;
  }

  public void setVariazioniRegoleMonitoraggioId(String variazioniRegoleMonitoraggioId) {
    this.variazioniRegoleMonitoraggioId = variazioniRegoleMonitoraggioId;
  }

  //    public List<String> getCasualeIds() {
  //        return casualeIds;
  //    }
  //
  //    public void setCasualeIds(List<String> casualeIds) {
  //        this.casualeIds = casualeIds;
  //    }
}
