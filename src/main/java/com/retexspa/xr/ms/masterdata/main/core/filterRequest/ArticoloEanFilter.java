package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public class ArticoloEanFilter {
  private String id;
  private String codice;
  private String descrizione;
  private Integer moltiplicatore;
  private String codiceVenditaLocale;
  private String descrizioneCodiceVendita;
  private Double quantitaCodiceVendita;
  private Double scontoCodiceVendita;
  private Double prezzoCodiceVendita;
  private String anagBil;
  private String flgCancellato;
  private LocalDateTime dataCancellazione;
  private String padreId;
  private String gerarchiaId;
  private String articoloId;
  private String codiceMoltiplicatoreId;
  private String statoId;
  private String tipoEanId;
  private Long version;

  public ArticoloEanFilter() {

  }

  public ArticoloEanFilter(
      @JsonProperty("id") String id,
      @JsonProperty("codice") String codice,
      @JsonProperty("descrizione") String descrizione,
      @JsonProperty("moltiplicatore") Integer moltiplicatore,
      @JsonProperty("codiceVenditaLocale") String codiceVenditaLocale,
      @JsonProperty("descrizioneCodiceVendita") String descrizioneCodiceVendita,
      @JsonProperty("quantitaCodiceVendita") Double quantitaCodiceVendita,
      @JsonProperty("scontoCodiceVendita") Double scontoCodiceVendita,
      @JsonProperty("prezzoCodiceVendita") Double prezzoCodiceVendita,
      @JsonProperty("anagBil") String anagBil,
      @JsonProperty("flgCancellato") String flgCancellato,
      @JsonProperty("dataCancellazione") LocalDateTime dataCancellazione,
      @JsonProperty("padreId") String padreId,
      @JsonProperty("gerarchiaId") String gerarchiaId,
      @JsonProperty("articoloId") String articoloId,
      @JsonProperty("codiceMoltiplicatoreId") String codiceMoltiplicatoreId,
      @JsonProperty("statoId") String statoId,
      @JsonProperty("tipoEanId") String tipoEanId,
      @JsonProperty("version") Long version) {

    this.id = id;
    this.codice = codice;
    this.descrizione = descrizione;
    this.moltiplicatore = moltiplicatore;
    this.codiceVenditaLocale = codiceVenditaLocale;
    this.descrizioneCodiceVendita = descrizioneCodiceVendita;
    this.quantitaCodiceVendita = quantitaCodiceVendita;
    this.scontoCodiceVendita = scontoCodiceVendita;
    this.prezzoCodiceVendita = prezzoCodiceVendita;
    this.anagBil = anagBil;
    this.flgCancellato = flgCancellato;
    this.dataCancellazione = dataCancellazione;
    this.padreId = padreId;
    this.gerarchiaId = gerarchiaId;
    this.articoloId = articoloId;
    this.codiceMoltiplicatoreId = codiceMoltiplicatoreId;
    this.statoId = statoId;
    this.tipoEanId = tipoEanId;
    this.version = version;
  }

  public static ArticoloEanFilter createFilterFromMap(Object obj) {

    ObjectMapper mapper = new ObjectMapper();
    String json = null;
    try {
      json = mapper.writeValueAsString(obj);

      LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);

      ArticoloEanFilter filter = new ArticoloEanFilter();
      if (map != null) {
        filter.setId((String) map.get("id"));
        filter.setCodice((String) map.get("codice"));
        filter.setDescrizione((String) map.get("descrizione"));
        filter.setMoltiplicatore((Integer) map.get("moltiplicatore"));
        filter.setCodiceVenditaLocale((String) map.get("codiceVenditaLocale"));
        filter.setDescrizioneCodiceVendita((String) map.get("descrizioneCodiceVendita"));
        filter.setQuantitaCodiceVendita((Double) map.get("quantitaCodiceVendita"));
        filter.setScontoCodiceVendita((Double) map.get("scontoCodiceVendita"));
        filter.setPrezzoCodiceVendita((Double) map.get("prezzoCodiceVendita"));
        filter.setAnagBil((String) map.get("anagBil"));
        filter.setFlgCancellato((String) map.get("flgCancellato"));
        filter.setDataCancellazione((LocalDateTime) map.get("setDataCancellazione"));
        filter.setCodiceMoltiplicatoreId((String) map.get("codiceMoltiplicatoreId"));
        filter.setStatoId((String) map.get("statoId"));
        filter.setTipoEanId((String) map.get("tipoEanId"));
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public void setMoltiplicatore(Integer moltiplicatore) {
    this.moltiplicatore = moltiplicatore;
  }

  public void setCodiceVenditaLocale(String codiceVenditaLocale) {
    this.codiceVenditaLocale = codiceVenditaLocale;
  }

  public void setDescrizioneCodiceVendita(String descrizioneCodiceVendita) {
    this.descrizioneCodiceVendita = descrizioneCodiceVendita;
  }

  public void setQuantitaCodiceVendita(Double quantitaCodiceVendita) {
    this.quantitaCodiceVendita = quantitaCodiceVendita;
  }

  public void setScontoCodiceVendita(Double scontoCodiceVendita) {
    this.scontoCodiceVendita = scontoCodiceVendita;
  }

  public void setPrezzoCodiceVendita(Double prezzoCodiceVendita) {
    this.prezzoCodiceVendita = prezzoCodiceVendita;
  }

  public void setAnagBil(String anagBil) {
    this.anagBil = anagBil;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }

  public void setDataCancellazione(LocalDateTime dataCancellazione) {
    this.dataCancellazione = dataCancellazione;
  }

  public void setPadreId(String padreId) {
    this.padreId = padreId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public void setArticoloId(String articoloId) {
    this.articoloId = articoloId;
  }

  public void setCodiceMoltiplicatoreId(String codiceMoltiplicatoreId) {
    this.codiceMoltiplicatoreId = codiceMoltiplicatoreId;
  }

  public void setStatoId(String statoId) {
    this.statoId = statoId;
  }

  public void setTipoEanId(String tipoEanId) {
    this.tipoEanId = tipoEanId;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public String getCodice() {
    return codice;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public Integer getMoltiplicatore() {
    return moltiplicatore;
  }

  public String getCodiceVenditaLocale() {
    return codiceVenditaLocale;
  }

  public String getDescrizioneCodiceVendita() {
    return descrizioneCodiceVendita;
  }

  public Double getQuantitaCodiceVendita() {
    return quantitaCodiceVendita;
  }

  public Double getScontoCodiceVendita() {
    return scontoCodiceVendita;
  }

  public Double getPrezzoCodiceVendita() {
    return prezzoCodiceVendita;
  }

  public String getAnagBil() {
    return anagBil;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public LocalDateTime getDataCancellazione() {
    return dataCancellazione;
  }

  public String getPadreId() {
    return padreId;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public String getArticoloId() {
    return articoloId;
  }

  public String getCodiceMoltiplicatoreId() {
    return codiceMoltiplicatoreId;
  }

  public String getStatoId() {
    return statoId;
  }

  public String getTipoEanId() {
    return tipoEanId;
  }

  public Long getVersion() {
    return version;
  }
}
