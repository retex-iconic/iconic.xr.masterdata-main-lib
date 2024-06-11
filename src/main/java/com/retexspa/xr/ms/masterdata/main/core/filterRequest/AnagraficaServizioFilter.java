package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import java.util.LinkedHashMap;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AnagraficaServizioFilter {

  private String id;
  private String codice;
  private String descrizione;
  private String nome;
  private String gerarchiaId;
  private String padreId;
  private String collocazione;
  private String providerId;
  private String tipologiaServizioId;
  private String fiduciaria;
  private String desScontrino;
  private String serviceType;
  private String config; // TODO MASTERDATA
  private Long version;

  public AnagraficaServizioFilter() {

  }

  public AnagraficaServizioFilter(
      @JsonProperty("id") String id,
      @JsonProperty("codice") String codice,
      @JsonProperty("descrizione") String descrizione,
      @JsonProperty("nome") String nome,
      @JsonProperty("gerarchiaId") String gerarchiaId,
      @JsonProperty("padreId") String padreId,
      @JsonProperty("collocazione") String collocazione,
      @JsonProperty("providerId") String providerId,
      @JsonProperty("tipologiaServizioId") String tipologiaServizioId,
      @JsonProperty("fiduciaria") String fiduciaria,
      @JsonProperty("desScontrino") String desScontrino,
      @JsonProperty("serviceType") String serviceType,
      @JsonProperty("version") Long version,
      @JsonProperty("config") String config) {

    this.id = id;
    this.codice = codice;
    this.descrizione = descrizione;
    this.gerarchiaId = gerarchiaId;
    this.padreId = padreId;
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

  public static AnagraficaServizioFilter createFilterFromMap(Object obj) {

    ObjectMapper mapper = new ObjectMapper();
    String json = null;
    try {
      json = mapper.writeValueAsString(obj);

      LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);

      AnagraficaServizioFilter filter = new AnagraficaServizioFilter();
      if (map != null) {
        filter.setId((String) map.get("id"));
        filter.setCodice((String) map.get("codice"));
        filter.setNome((String) map.get("nome"));
        filter.setDescrizione((String) map.get("descrizione"));
        filter.setGerarchiaId((String) map.get("gerarchiaId"));
        filter.setPadreId((String) map.get("padreId"));
        filter.setCollocazione((String) map.get("collocazione"));
        filter.setProviderId((String) map.get("providerId"));
        filter.setTipologiaServizioId((String) map.get("tipologiaServizioId"));
        filter.setFiduciaria((String) map.get("fiduciaria"));
        filter.setDesScontrino((String) map.get("desScontrino"));
        filter.setServiceType((String) map.get("serviceType"));
        filter.setConfig((String) map.get("config"));

        Object version = map.get("version");
        if (version != null) {
          if (version instanceof Integer) {
            filter.setVersion(Long.valueOf((Integer) version));
          } else if (version instanceof Long) {
            filter.setVersion((Long) version);
          }
        }
      }
      return filter;
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  public String getPadreId() {
    return padreId;
  }

  public void setPadreId(String padreId) {
    this.padreId = padreId;
  }
}
