package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AtecoFilter {
  private String id;
  private String codice;
  private String nome;
  private String descrizione;
  private Integer atecoNr;
  private String gerarchiaId;
  private String padreId;
  private String  flgCancellato;
  private String dataCancellazione;
  private Long version;

  public AtecoFilter() {
  }

  public AtecoFilter(
      @JsonProperty("id") String id,
      @JsonProperty("codice") String codice,
      @JsonProperty("nome") String nome,
      @JsonProperty("descrizione") String descrizione,
      @JsonProperty("atecoNr") Integer atecoNr,
      @JsonProperty("gerarchiaId") String gerarchiaId,
      @JsonProperty("padreId") String padreId,
      @JsonProperty("flgCancellato") String  flgCancellato,
      @JsonProperty("dataCancellazione") String dataCancellazione,
      @JsonProperty("version") Long version) {

    this.id = id;
    this.codice = codice;
    this.nome = nome;
    this.descrizione = descrizione;
    this.atecoNr = atecoNr;
    this.gerarchiaId = gerarchiaId;
    this.version = version;
    this.padreId=padreId;
    this.flgCancellato= flgCancellato;
    this.dataCancellazione =dataCancellazione;

  }

  
  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCodice() {
    return this.codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

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

  public Integer getAtecoNr() {
    return this.atecoNr;
  }

  public void setAtecoNr(Integer atecoNr) {
    this.atecoNr = atecoNr;
  }

  public String getGerarchiaId() {
    return this.gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public Long getVersion() {
    return this.version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public static AtecoFilter createFilterFromMap(Object obj) {
    // LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;

    ObjectMapper mapper = new ObjectMapper();
    String json = null;
    try {
      json = mapper.writeValueAsString(obj);

      LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);

      AtecoFilter filter = new AtecoFilter();
      if (map != null) {
        filter.setId((String) map.get("id"));
        filter.setCodice((String) map.get("codice"));
        filter.setNome((String) map.get("nome"));
        filter.setDescrizione((String) map.get("descrizione"));
        filter.setAtecoNr((Integer) map.get("atecoNr"));
        filter.setGerarchiaId((String) map.get("gerarchiaId"));
        filter.setPadreId((String) map.get("padreId"));
        filter.setFlgCancellato((String) map.get("flgCancellato"));
        filter.setDataCancellazione((String) map.get("dataCancellazione"));
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

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }

  public String getDataCancellazione() {
    return dataCancellazione;
  }

  public void setDataCancellazione(String dataCancellazione) {
    this.dataCancellazione = dataCancellazione;
  }
}
