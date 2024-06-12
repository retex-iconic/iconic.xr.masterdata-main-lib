package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;

public class TipologiaServizioFilter {

  private String id;
  private String codice;
  private String nome;
  private String descrizione;
  private String gerarchiaId;

  private String padreId;
  private Integer numMaxInScontrino;
  private Double valMaxInScontrino;
  private Long version;

  public TipologiaServizioFilter() {

  }

  public TipologiaServizioFilter(

      @JsonProperty("id") String id,
      @JsonProperty("codice") String codice,
      @JsonProperty("nome") String nome,
      @JsonProperty("descrizione") String descrizione,
      @JsonProperty("gerarchiaId") String gerarchiaId,
      @JsonProperty("padreId") String padreId,
      @JsonProperty("numMaxInScontrino") Integer numMaxInScontrino,
      @JsonProperty("valMaxInScontrino") Double valMaxInScontrino,
      @JsonProperty("version") Long version) {

    this.id = id;
    this.codice = codice;
    this.descrizione = descrizione;
    this.gerarchiaId = gerarchiaId;
    this.nome = nome;
    this.padreId = padreId;
    this.numMaxInScontrino = numMaxInScontrino;
    this.valMaxInScontrino = valMaxInScontrino;
    this.version = version;
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

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public Integer getNumMaxInScontrino() {
    return numMaxInScontrino;
  }

  public void setNumMaxInScontrino(Integer numMaxInScontrino) {
    this.numMaxInScontrino = numMaxInScontrino;
  }

  public Double getValMaxInScontrino() {
    return valMaxInScontrino;
  }

  public void setValMaxInScontrino(Double valMaxInScontrino) {
    this.valMaxInScontrino = valMaxInScontrino;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public static TipologiaServizioFilter createFilterFromMap(Object obj) {

    ObjectMapper mapper = new ObjectMapper();
    String json = null;
    try {
      json = mapper.writeValueAsString(obj);

      LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);

      TipologiaServizioFilter filter = new TipologiaServizioFilter();
      if (map != null) {
        filter.setId((String) map.get("id"));
        filter.setCodice((String) map.get("codice"));
        filter.setNome((String) map.get("nome"));
        filter.setDescrizione((String) map.get("descrizione"));
        filter.setPadreId((String) map.get("padreId"));
        filter.setNumMaxInScontrino((Integer) map.get("numMaxInScontrino"));
        filter.setValMaxInScontrino((Double) map.get("valMaxInScontrino"));
        filter.setGerarchiaId((String) map.get("gerarchiaId"));
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
