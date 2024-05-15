package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public class EsclusioniFpServizioFilter {
  private String id;
  private String codice;
  private String descSegnalazione;
  private String flgSegnalazione;
  private Double massimaleCumulativo;
  private Double massimaleSingolo;
  private String formaPagamentoId;
  private String servizioId;
  private String gerarchiaId;
  private Long version;

  public EsclusioniFpServizioFilter() {

  }

  public EsclusioniFpServizioFilter(
      @JsonProperty("id") String id,
      @JsonProperty("codice") String codice,
      @JsonProperty("descSegnalazione") String descSegnalazione,
      @JsonProperty("flgSegnalazione") String flgSegnalazione,
      @JsonProperty("massimaleCumulativo") Double massimaleCumulativo,
      @JsonProperty("massimaleSingolo") Double massimaleSingolo,
      @JsonProperty("formaPagamentoId") String formaPagamentoId,
      @JsonProperty("servizioId") String servizioId,
      @JsonProperty("gerarchiaId") String gerarchiaId,
      @JsonProperty("version") Long version) {

    this.id = id;
    this.codice = codice;
    this.descSegnalazione = descSegnalazione;
    this.flgSegnalazione = flgSegnalazione;
    this.massimaleCumulativo = massimaleCumulativo;
    this.massimaleSingolo = massimaleSingolo;
    this.formaPagamentoId = formaPagamentoId;
    this.servizioId = servizioId;
    this.gerarchiaId = gerarchiaId;
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

  public String getDescSegnalazione() {
    return descSegnalazione;
  }

  public void setDescSegnalazione(String descSegnalazione) {
    this.descSegnalazione = descSegnalazione;
  }

  public String getFlgSegnalazione() {
    return flgSegnalazione;
  }

  public void setFlgSegnalazione(String flgSegnalazione) {
    this.flgSegnalazione = flgSegnalazione;
  }

  public Double getMassimaleCumulativo() {
    return massimaleCumulativo;
  }

  public void setMassimaleCumulativo(Double massimaleCumulativo) {
    this.massimaleCumulativo = massimaleCumulativo;
  }

  public Double getMassimaleSingolo() {
    return massimaleSingolo;
  }

  public void setMassimaleSingolo(Double massimaleSingolo) {
    this.massimaleSingolo = massimaleSingolo;
  }

  public String getFormaPagamentoId() {
    return formaPagamentoId;
  }

  public void setFormaPagamentoId(String formaPagamentoId) {
    this.formaPagamentoId = formaPagamentoId;
  }

  public String getServizioId() {
    return servizioId;
  }

  public void setServizioId(String servizioId) {
    this.servizioId = servizioId;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public static EsclusioniFpServizioFilter createFilterFromMap(Object obj) {

    ObjectMapper mapper = new ObjectMapper();
    String json = null;
    try {
      json = mapper.writeValueAsString(obj);

      LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);

      EsclusioniFpServizioFilter filter = new EsclusioniFpServizioFilter();
      if (map != null) {
        filter.setId((String) map.get("id"));
        filter.setCodice((String) map.get("codice"));
        filter.setDescSegnalazione((String) map.get("descSegnalazione"));
        filter.setFlgSegnalazione((String) map.get("flgSegnalazione"));
        filter.setMassimaleCumulativo((Double) map.get("massimaleCumulativo"));
        filter.setMassimaleSingolo((Double) map.get("massimaleSingolo"));
        filter.setFormaPagamentoId((String) map.get("formaPagamentoId"));
        filter.setServizioId((String) map.get("servizioId"));
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

}
