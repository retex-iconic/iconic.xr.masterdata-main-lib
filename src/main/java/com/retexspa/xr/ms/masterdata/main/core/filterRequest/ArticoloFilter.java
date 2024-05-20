package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public class ArticoloFilter {
  private String id;
  private String codice;
  private LocalDateTime dataCancellazione;
  private String descrizione;
  private String flgCancellato;
  private String nome;
  private String gerarchiaId;
  private String padreId;
  private Long version;

  public ArticoloFilter() {
  }

  public ArticoloFilter(
      @JsonProperty("id") String id,
      @JsonProperty("codice") String codice,
      @JsonProperty("dataCancellazione") LocalDateTime dataCancellazione,
      @JsonProperty("descrizione") String descrizione,
      @JsonProperty("flgCancellato") String flgCancellato,
      @JsonProperty("nome") String nome,
      @JsonProperty("gerarchiaId") String gerarchiaId,
      @JsonProperty("padreId") String padreId,
      @JsonProperty("version") Long version) {

    this.id = id;
    this.codice = codice;
    this.dataCancellazione = dataCancellazione;
    this.descrizione = descrizione;
    this.flgCancellato = flgCancellato;
    this.nome = nome;
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

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public LocalDateTime getDataCancellazione() {
    return dataCancellazione;
  }

  public void setDataCancellazione(LocalDateTime dataCancellazione) {
    this.dataCancellazione = dataCancellazione;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
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

  public static ArticoloFilter createFilterFromMap(Object obj) {

    ObjectMapper mapper = new ObjectMapper();
    String json = null;
    try {
      json = mapper.writeValueAsString(obj);

      LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);

      ArticoloFilter filter = new ArticoloFilter();
      if (map != null) {
        filter.setId((String) map.get("id"));
        filter.setCodice((String) map.get("codice"));
        filter.setNome((String) map.get("nome"));
        filter.setDescrizione((String) map.get("descrizione"));
        filter.setDataCancellazione((LocalDateTime) map.get("dataCancellazione"));
        filter.setFlgCancellato((String) map.get("flgCancellato"));
        filter.setGerarchiaId((String) map.get("gerarchiaId"));
        filter.setPadreId((String) map.get("padreId"));
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

}
