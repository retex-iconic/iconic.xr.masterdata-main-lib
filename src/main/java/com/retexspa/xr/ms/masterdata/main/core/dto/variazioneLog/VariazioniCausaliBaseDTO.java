package com.retexspa.xr.ms.masterdata.main.core.dto.variazioneLog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class VariazioniCausaliBaseDTO extends BaseDTO {

  @EnumValidator(
      enumClazz = Enums.TipologiaVariazione.class,
      message = "Tipologia Variazione not valid")
  private String tipologiaVariazione;

  @NotNull(message = "priorita is mandatory")
  private Integer priorita;

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flag Attivo not valid")
  private String flgAttiva;

  @JsonIgnore
  public static String getAggregateId() {
    return UUID.randomUUID().toString();
  }
}
