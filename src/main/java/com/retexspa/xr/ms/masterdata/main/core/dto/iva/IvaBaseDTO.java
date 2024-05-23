package com.retexspa.xr.ms.masterdata.main.core.dto.iva;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

import java.util.UUID;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class IvaBaseDTO extends BaseDTO {

  public enum TipoIva {
    AV, // iva acquisto vendita
    V, // iva vendita
    A; // iva acquisto
  }

  @EnumValidator(enumClazz = TipoIva.class, message = "tipoIva not valid")
  private String tipoIva;

  // TLPoswin
  private String codIvaAcquisto;
  private Double percentuale;
  private String naturaEsenzione;
  private String normaEsenzione;
  private String codiceEsterno;
  private String codiceECommerce;

  public String getTipoIva() {
    return tipoIva;
  }

  public void setTipoIva(String tipoIva) {
    this.tipoIva = tipoIva;
  }

  public String getCodIvaAcquisto() {
    return codIvaAcquisto;
  }

  public void setCodIvaAcquisto(String codIvaAcquisto) {
    this.codIvaAcquisto = codIvaAcquisto;
  }

  public Double getPercentuale() {
    return this.percentuale;
  }

  public void setPercentuale(Double percentuale) {
    this.percentuale = percentuale;
  }

  public String getNaturaEsenzione() {
    return this.naturaEsenzione;
  }

  public void setNaturaEsenzione(String naturaEsenzione) {
    this.naturaEsenzione = naturaEsenzione;
  }

  public String getNormaEsenzione() {
    return this.normaEsenzione;
  }

  public void setNormaEsenzione(String normaEsenzione) {
    this.normaEsenzione = normaEsenzione;
  }

  public String getCodiceEsterno() {
    return this.codiceEsterno;
  }

  public void setCodiceEsterno(String codiceEsterno) {
    this.codiceEsterno = codiceEsterno;
  }

  public String getCodiceECommerce() {
    return this.codiceECommerce;
  }

  public void setCodiceECommerce(String codiceECommerce) {
    this.codiceECommerce = codiceECommerce;
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }

  public static String getDetailNameIva() {
    return "Iva";
  }

  public static String getDetailNameIvaAggregate() {
    return "IvaAggregate";
  }
}
