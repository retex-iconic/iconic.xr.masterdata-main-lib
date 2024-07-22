package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VariazioniCausaliOperazioniFilter {
  private String id;
  private String codice;
  private String nome;
  private String descrizione;
  private String gerarchiaId;
  private String variazioniCausaliId;
  private String operazione;
  private Integer priorita;
  private String flgEsecuzioneImmediata;
  private String flgAttivo;
  private String padreId;
  private Long version;
  private String dataCancellazione;

  public VariazioniCausaliOperazioniFilter() {
  }

  public VariazioniCausaliOperazioniFilter(
      @JsonProperty("id") String id,
      @JsonProperty("codice") String codice,
      @JsonProperty("nome") String nome,
      @JsonProperty("gerarchiaId") String gerarchiaId,
      @JsonProperty("padreId") String padreId,
      @JsonProperty("version") Long version,
      @JsonProperty("variazioniCausaliId") String variazioniCausaliId,
      @JsonProperty("operazione") String operazione,
      @JsonProperty("priorita") Integer priorita,
      @JsonProperty("flgEsecuzioneImmediata") String flgEsecuzioneImmediata,
      @JsonProperty("flgAttivo") String flgAttivo,
      @JsonProperty("descrizione") String descrizione,
      @JsonProperty("dataCancellazione") String dataCancellazione) {
    this.id = id;
    this.codice = codice;
    this.nome = nome;
    this.gerarchiaId = gerarchiaId;
    this.padreId = padreId;
    this.version = version;
    this.descrizione = descrizione;
    this.variazioniCausaliId = variazioniCausaliId;
    this.priorita = priorita;
    this.operazione = operazione;
    this.flgEsecuzioneImmediata = flgEsecuzioneImmediata;
    this.flgAttivo = flgAttivo;
    this.dataCancellazione = dataCancellazione;
  }

  public static VariazioniCausaliOperazioniFilter createFilterFromMap(Object obj) {

    ObjectMapper mapper = new ObjectMapper();
    String json = null;
    try {
      json = mapper.writeValueAsString(obj);

      LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);

      VariazioniCausaliOperazioniFilter filter = new VariazioniCausaliOperazioniFilter();
      if (map != null) {
        filter.setId((String) map.get("id"));
        filter.setCodice((String) map.get("codice"));
        filter.setNome((String) map.get("nome"));
        filter.setDescrizione((String) map.get("descrizione"));
        filter.setGerarchiaId((String) map.get("gerarchiaId"));
        filter.setPadreId((String) map.get("padreId"));
        filter.setVariazioniCausaliId((String) map.get("variazioniCausaliId"));
        filter.setPriorita((Integer) map.get("priorita"));
        filter.setOperazione((String) map.get("operazione"));
        filter.setFlgEsecuzioneImmediata((String) map.get("flgEsecuzioneImmediata"));
        filter.setFlgAttivo((String) map.get("flgAttivo"));
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

  public String getGerarchiaId() {
    return this.gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getVariazioniCausaliId() {
    return this.variazioniCausaliId;
  }

  public void setVariazioniCausaliId(String variazioniCausaliId) {
    this.variazioniCausaliId = variazioniCausaliId;
  }

  public String getOperazione() {
    return this.operazione;
  }

  public void setOperazione(String operazione) {
    this.operazione = operazione;
  }

  public Integer getPriorita() {
    return this.priorita;
  }

  public void setPriorita(Integer priorita) {
    this.priorita = priorita;
  }

  public String getFlgEsecuzioneImmediata() {
    return this.flgEsecuzioneImmediata;
  }

  public void setFlgEsecuzioneImmediata(String flgEsecuzioneImmediata) {
    this.flgEsecuzioneImmediata = flgEsecuzioneImmediata;
  }

  public String getFlgAttivo() {
    return this.flgAttivo;
  }

  public void setFlgAttivo(String flgAttivo) {
    this.flgAttivo = flgAttivo;
  }

  public String getPadreId() {
    return this.padreId;
  }

  public void setPadreId(String padreId) {
    this.padreId = padreId;
  }

  public Long getVersion() {
    return this.version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public String getDataCancellazione() {
    return this.dataCancellazione;
  }

  public void setDataCancellazione(String dataCancellazione) {
    this.dataCancellazione = dataCancellazione;
  }

}
