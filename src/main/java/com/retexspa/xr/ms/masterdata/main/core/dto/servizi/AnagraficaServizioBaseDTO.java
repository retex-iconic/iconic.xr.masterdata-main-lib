package com.retexspa.xr.ms.masterdata.main.core.dto.servizi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

import java.util.UUID;
import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AnagraficaServizioBaseDTO extends BaseDTO {

  public enum Collocazione {
    F,
    N
  }

  @NotNull(message = "collocazione is mandatory")
  @EnumValidator(
      enumClazz = AnagraficaServizioBaseDTO.Collocazione.class,
      message = "Collocazione not valid")
  private String collocazione;

  private String providerId;
  private String tipologiaServizioId;
  private String fiduciaria;
  private String desScontrino;
  private String serviceType;
  private String config;

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

  public String getTipologiaServizioId() {
    return tipologiaServizioId;
  }

  public void setTipologiaServizioId(String tipologiaServizioId) {
    this.tipologiaServizioId = tipologiaServizioId;
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

  public String getConfig() {
    return config;
  }

  public void setConfig(String config) {
    this.config = config;
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }
}
