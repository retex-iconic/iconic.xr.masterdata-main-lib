package com.retexspa.xr.ms.masterdata.main.core.dto.variazioniCausaliOperazioni;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VariazioniCausaliOperazioniIndexDTO {
  private String variazioniCausaliOperazioniId;

  public VariazioniCausaliOperazioniIndexDTO() {}

  public VariazioniCausaliOperazioniIndexDTO(String variazioniCausaliOperazioniId) {
    this.variazioniCausaliOperazioniId = variazioniCausaliOperazioniId;
  }

  public static String getIdFromVariazioniCausaliOperazioni(String variazioniCausaliOperazioniId) {
    return UUID.nameUUIDFromBytes(
            ("/VariazioniCausaliOperazioniIndex/" + variazioniCausaliOperazioniId).getBytes())
        .toString();
  }

  public String getVariazioniCausaliOperazioniId() {
    return this.variazioniCausaliOperazioniId;
  }

  public void setVariazioniCausaliOperazioniId(String variazioniCausaliOperazioniId) {
    this.variazioniCausaliOperazioniId = variazioniCausaliOperazioniId;
  }
}
