package com.retexspa.xr.ms.masterdata.main.core.dto.variazioniRegoleMonitoraggio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class VariazioniRegoleMonitoraggioUpdateDTO {
  private String nome;
  private String descrizione;

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flag Salva not valid")
  private String flgSalva;

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flg Esecuzione Immediata not valid")
  private String flgSalvaCancellazione;
}
