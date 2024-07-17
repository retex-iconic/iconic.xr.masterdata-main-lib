package com.retexspa.xr.ms.masterdata.main.core.dto.variazioneLog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.validation.constraints.NotNull;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class VariazioniCausaliBaseDTO extends BaseDTO {

  @EnumValidator(
      enumClazz = Enums.TipologiaVariazione.class,
      message = "Tipologia Variazione not valid")
  private String tipologiaVariazione;

  @NotNull(message = "priorita is mandatory")
  private Integer priorita;

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flag Attivo not valid")
  private String flgAttiva;

  private LocalDateTime dataCancellazione;

  @JsonIgnore
  public static String getAggregateId() {
    return UUID.randomUUID().toString();
  }

  public static String getName() {
    return "VariazioniCausali";
  }

  public static String getAggregateName() {
    return "VariazioniCausaliAggregate";
  }


  public String getTipologiaVariazione() {
    return this.tipologiaVariazione;
  }

  public void setTipologiaVariazione(String tipologiaVariazione) {
    this.tipologiaVariazione = tipologiaVariazione;
  }

  public Integer getPriorita() {
    return this.priorita;
  }

  public void setPriorita(Integer priorita) {
    this.priorita = priorita;
  }

  public String getFlgAttiva() {
    return this.flgAttiva;
  }

  public void setFlgAttiva(String flgAttiva) {
    this.flgAttiva = (flgAttiva == null ? "S" : flgAttiva);
  }

  public LocalDateTime getDataCancellazione() {
    return this.dataCancellazione;
  }

  public void setDataCancellazione(LocalDateTime dataCancellazione) {
    this.dataCancellazione = dataCancellazione;
  }


}
