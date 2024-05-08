package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;

import java.util.List;

public class IvaSearchRequest extends BaseSortPagination {

  private String id;

  private String nome;

  private String codice;

  private String descrizione;

  private String tipoIva;

  private String codIvaAcquisto;

  private Double percentuale;

  private String naturaEsenzione;

  private String normaEsenzione;

  private String codiceEsterno;

  private String codiceECommerce;

  private String gerarchiaId;

  private String padreId;
  private Long version;

  public IvaSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String nome,
      String codice,
      String descrizione,
      String tipoIva,
      String codIvaAcquisto,
      Double percentuale,
      String naturaEsenzione,
      String normaEsenzione,
      String codiceEsterno,
      String codiceECommerce,
      String gerarchiaId,
      String padreId,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.nome = nome;
    this.codice = codice;
    this.descrizione = descrizione;
    this.tipoIva = tipoIva;
    this.codIvaAcquisto = codIvaAcquisto;
    this.percentuale = percentuale;
    this.naturaEsenzione = naturaEsenzione;
    this.normaEsenzione = normaEsenzione;
    this.codiceEsterno = codiceEsterno;
    this.codiceECommerce = codiceECommerce;
    this.gerarchiaId = gerarchiaId;
    this.padreId = padreId;
    this.version = version;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

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
    return percentuale;
  }

  public void setPercentuale(Double percentuale) {
    this.percentuale = percentuale;
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

  public String getCodiceEsterno() {
    return codiceEsterno;
  }

  public void setCodiceEsterno(String codiceEsterno) {
    this.codiceEsterno = codiceEsterno;
  }

  public String getCodiceECommerce() {
    return codiceECommerce;
  }

  public void setCodiceECommerce(String codiceECommerce) {
    this.codiceECommerce = codiceECommerce;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getPadreId() {
    return padreId;
  }

  public void setPadreId(String padreId) {
    this.padreId = padreId;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
