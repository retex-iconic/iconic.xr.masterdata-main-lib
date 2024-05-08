package com.retexspa.xr.ms.masterdata.main.core.dto.variazioneLog;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class VariazioniCausaliUpdateDTO {

  private String nome;
  private String descrizione;
  private Integer priorita;

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flag Attivo not valid")
  private String flgAttiva;
}
