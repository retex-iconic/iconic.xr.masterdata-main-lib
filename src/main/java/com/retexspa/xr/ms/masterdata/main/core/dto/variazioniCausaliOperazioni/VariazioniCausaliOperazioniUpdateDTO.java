package com.retexspa.xr.ms.masterdata.main.core.dto.variazioniCausaliOperazioni;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class VariazioniCausaliOperazioniUpdateDTO {
  private String nome;
  private String descrizione;
  private Integer priorita;

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flg Esecuzione Immediata not valid")
  private String flgEsecuzioneImmediata;

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flg Attivo not valid")
  private String flgAttivo;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
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
    this.flgEsecuzioneImmediata = flgEsecuzioneImmediata;
  }

  public String getFlgAttivo() {
    return flgAttivo;
  }

  public void setFlgAttivo(String flgAttivo) {
    this.flgAttivo = flgAttivo;
  }
}
