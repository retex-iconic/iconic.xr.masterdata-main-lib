package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;

import java.util.List;

public class AnagraficaServizioSearchRequest extends BaseSortPagination {

  private String id;
  private String codice;
  private String descrizione;
  private String nome;
  private String gerarchiaId;
  private String collocazione;
  private String providerId;
  private String tipologiaServizioId;
  private String fiduciaria;
  private String desScontrino;
  private String serviceType;
  private String config; // TODO MASTERDATA
  private Long version;

  public AnagraficaServizioSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String codice,
      String descrizione,
      String nome,
      String gerarchiaId,
      String collocazione,
      String providerId,
      String tipologiaServizioId,
      String fiduciaria,
      String desScontrino,
      String serviceType,
      Long version,
      String config) {
    super(page, limit, sort);
    this.id = id;
    this.codice = codice;
    this.descrizione = descrizione;
    this.gerarchiaId = gerarchiaId;
    this.nome = nome;
    this.collocazione = collocazione;
    this.providerId = providerId;
    this.tipologiaServizioId = tipologiaServizioId;
    this.fiduciaria = fiduciaria;
    this.desScontrino = desScontrino;
    this.serviceType = serviceType;
    this.version = version;
    this.config = config;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
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

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public String getConfig() {
    return config;
  }

  public void setConfig(String config) {
    this.config = config;
  }
}
