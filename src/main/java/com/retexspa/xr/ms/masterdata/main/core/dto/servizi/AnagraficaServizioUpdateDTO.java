package com.retexspa.xr.ms.masterdata.main.core.dto.servizi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AnagraficaServizioUpdateDTO {
  private String nome;
  private String descrizione;

  @EnumValidator(enumClazz = Enums.Collocazione.class, message = "Collocazione not valid")
  private String collocazione;

  private String providerId;
  private String fiduciaria;
  private String desScontrino;
  private String serviceType;

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescrizione() {
    return this.descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getCollocazione() {
    return collocazione;
  }

  public void setCollocazione(String collocazione) {
    this.collocazione = collocazione;
  }

  public String getProviderId() {
    return providerId;
  }

  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }

  public String getFiduciaria() {
    return fiduciaria;
  }

  public void setFiduciaria(String fiduciaria) {
    this.fiduciaria = fiduciaria;
  }

  public String getDesScontrino() {
    return desScontrino;
  }

  public void setDesScontrino(String desScontrino) {
    this.desScontrino = desScontrino;
  }

  public String getServiceType() {
    return serviceType;
  }

  public void setServiceType(String serviceType) {
    this.serviceType = serviceType;
  }
}
