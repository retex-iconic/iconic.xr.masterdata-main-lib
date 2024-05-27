package com.retexspa.xr.ms.masterdata.main.core.dto.iva;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class IvaUpdateDto {

  private String nome;

  private String descrizione;

  private String codIvaAcquisto;

  private String codiceECommerce;
  private String codiceEsterno;

  private String naturaEsenzione;

  private String normaEsenzione;

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

  public String getCodIvaAcquisto() {
    return codIvaAcquisto;
  }

  public void setCodIvaAcquisto(String codIvaAcquisto) {
    this.codIvaAcquisto = codIvaAcquisto;
  }

  public String getCodiceECommerce() {
    return codiceECommerce;
  }

  public void setCodiceECommerce(String codiceECommerce) {
    this.codiceECommerce = codiceECommerce;
  }

  public String getCodiceEsterno() {
    return codiceEsterno;
  }

  public void setCodiceEsterno(String codiceEsterno) {
    this.codiceEsterno = codiceEsterno;
  }

  public String getNaturaEsenzione() {
    return naturaEsenzione;
  }

  public void setNaturaEsenzione(String naturaEsenzione) {
    this.naturaEsenzione = naturaEsenzione;
  }

  public String getNormaEsenzione() {
    return normaEsenzione;
  }

  public void setNormaEsenzione(String normaEsenzione) {
    this.normaEsenzione = normaEsenzione;
  }
}
