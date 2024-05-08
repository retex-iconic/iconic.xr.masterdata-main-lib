package com.retexspa.xr.ms.masterdata.main.core.dto.variazioniCausaliOperazioni;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class VariazioniCausaliOperazioniUpdateFlgAttivoDTO {
  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flg Attivo not valid")
  private String flgAttivo;

  public String getFlgAttivo() {
    return flgAttivo;
  }

  public void setFlgAttivo(String flgAttivo) {
    this.flgAttivo = (flgAttivo == null ? "S" : flgAttivo);
  }
}
