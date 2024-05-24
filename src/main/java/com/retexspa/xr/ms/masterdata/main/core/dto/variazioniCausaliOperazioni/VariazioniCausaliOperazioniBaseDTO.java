package com.retexspa.xr.ms.masterdata.main.core.dto.variazioniCausaliOperazioni;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class VariazioniCausaliOperazioniBaseDTO extends BaseDTO {

  @NotNull(message = "VariazioniCausali is mandatory")
  @NotEmpty(message = "VariazioniCausali is mandatory")
  @NotBlank(message = "VariazioniCausali  is mandatory")
  private String variazioniCausaliId;

  @NotNull(message = "Operazione is mandatory")
  @NotEmpty(message = "Operazione is mandatory")
  @NotBlank(message = "Operazione is mandatory")
  @EnumValidator(enumClazz = Enums.TipoOperazioneVariazione.class, message = "Operazione not valid")
  private String operazione;

  private Integer priorita;

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flg Esecuzione Immediata not valid")
  private String flgEsecuzioneImmediata;

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flg Attivo not valid")
  private String flgAttivo;

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }

  public String getVariazioniCausaliId() {
    return variazioniCausaliId;
  }

  public void setVariazioniCausaliId(String variazioniCausaliId) {
    this.variazioniCausaliId = variazioniCausaliId;
  }

  public String getOperazione() {
    return operazione;
  }

  public void setOperazione(String operazione) {
    this.operazione = operazione;
  }

  public Integer getPriorita() {
    return priorita;
  }

  public void setPriorita(Integer priorita) {
    this.priorita = priorita;
  }

  public String getFlgEsecuzioneImmediata() {
    return flgEsecuzioneImmediata;
  }

  public void setFlgEsecuzioneImmediata(String flgEsecuzioneImmediata) {
    this.flgEsecuzioneImmediata = (flgEsecuzioneImmediata == null ? "N" : flgEsecuzioneImmediata);
  }

  public String getFlgAttivo() {
    return flgAttivo;
  }

  public void setFlgAttivo(String flgAttivo) {
    this.flgAttivo = (flgAttivo == null ? "S" : flgAttivo);
  }

  public static String getName() {
    return "VariazioniCausaliOperazioni";
  }

  public static String getAggregateName() {
    return "VariazioniCausaliOperazioniAggregate";
  }
}
