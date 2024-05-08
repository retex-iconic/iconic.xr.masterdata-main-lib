package com.retexspa.xr.ms.masterdata.main.core.dto.variazioniRegoleMonitoraggio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class VariazioniRegoleMonitoraggioUpdateFlgAttivaDTO {
  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flag Attivo not valid")
  private String flgAttiva;

  public String getFlgAttiva() {
    return flgAttiva;
  }

  public void setFlgAttiva(String flgAttiva) {
    this.flgAttiva = (flgAttiva == null ? "S" : flgAttiva);
  }
}
