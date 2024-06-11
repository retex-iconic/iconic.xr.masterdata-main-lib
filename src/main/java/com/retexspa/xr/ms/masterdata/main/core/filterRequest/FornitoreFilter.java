package com.retexspa.xr.ms.masterdata.main.core.filterRequest;

import java.util.LinkedHashMap;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FornitoreFilter {
  private String id;
  private String nome;
  private String codice;
  private String descrizione;
  private String gerarchiaId;
  private String padreId;
  private String numero;
  private String indirizzo;
  private String citta;
  private String cap;
  private String piva;
  private String magazzino;
  private String codiceEsterno;
  private String ragioneSociale;
  private String codiceFiscale;
  private String telefono;
  private String rank;
  private String tipoCod;
  private String email;
  private String codiceEsterno2;
  private String codiceContabilita;
  private String codicePrecedenteBackOffice;
  private Long version;

  public FornitoreFilter() {
  }

  public FornitoreFilter(
      @JsonProperty("id") String id,
      @JsonProperty("nome") String nome,
      @JsonProperty("codice") String codice,
      @JsonProperty("descrizione") String descrizione,
      @JsonProperty("gerarchiaId") String gerarchiaId,
      @JsonProperty("padreId") String padreId,
      @JsonProperty("numero") String numero,
      @JsonProperty("indirizzo") String indirizzo,
      @JsonProperty("citta") String citta,
      @JsonProperty("cap") String cap,
      @JsonProperty("piva") String piva,
      @JsonProperty("magazzino") String magazzino,
      @JsonProperty("codiceEsterno") String codiceEsterno,
      @JsonProperty("ragioneSociale") String ragioneSociale,
      @JsonProperty("codiceFiscale") String codiceFiscale,
      @JsonProperty("telefono") String telefono,
      @JsonProperty("rank") String rank,
      @JsonProperty("tipoCod") String tipoCod,
      @JsonProperty("email") String email,
      @JsonProperty("codiceEsterno2") String codiceEsterno2,
      @JsonProperty("codiceContabilita") String codiceContabilita,
      @JsonProperty("codicePrecedenteBackOffice") String codicePrecedenteBackOffice,
      @JsonProperty("version") Long version) {
    this.id = id;
    this.nome = nome;
    this.codice = codice;
    this.descrizione = descrizione;
    this.gerarchiaId = gerarchiaId;
    this.padreId = padreId;
    this.numero = numero;
    this.indirizzo = indirizzo;
    this.citta = citta;
    this.cap = cap;
    this.piva = piva;
    this.magazzino = magazzino;
    this.codiceEsterno = codiceEsterno;
    this.ragioneSociale = ragioneSociale;
    this.codiceFiscale = codiceFiscale;
    this.telefono = telefono;
    this.rank = rank;
    this.tipoCod = tipoCod;
    this.email = email;
    this.codiceEsterno2 = codiceEsterno2;
    this.codiceContabilita = codiceContabilita;
    this.codicePrecedenteBackOffice = codicePrecedenteBackOffice;
    this.version = version;
  }

  public static FornitoreFilter createFilterFromMap(Object obj) {

    ObjectMapper mapper = new ObjectMapper();
    String json = null;
    try {
      json = mapper.writeValueAsString(obj);
      LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);
      FornitoreFilter filter = new FornitoreFilter();
      if (map != null) {
        filter.setId((String) map.get("id"));
        filter.setCodice((String) map.get("codice"));
        filter.setNome((String) map.get("nome"));
        filter.setDescrizione((String) map.get("descrizione"));
        filter.setPadreId((String) map.get("padreId"));
        filter.setGerarchiaId((String) map.get("gerarchiaId"));

        filter.setNumero((String) map.get("numero"));
        filter.setIndirizzo((String) map.get("indirizzo"));
        filter.setCitta((String) map.get("citta"));
        filter.setCap((String) map.get("cap"));
        filter.setPiva((String) map.get("piva"));
        filter.setRagioneSociale((String) map.get("ragionesociale"));
        filter.setCodiceFiscale((String) map.get("codiceFiscale"));
        filter.setTelefono((String) map.get("telefono"));
        filter.setEmail((String) map.get("email"));
        filter.setEmail((String) map.get("codiceEsterno"));
        filter.setEmail((String) map.get("rank"));
        filter.setTipoCod((String) map.get("tipocod"));
        filter.setCodiceEsterno2((String) map.get("codiceEsterno2"));
        filter.setCodiceContabilita((String) map.get("codiceContabilita"));
        filter.setcodicePrecedenteBackOffice((String) map.get("codicePrecedenteBackOffice"));
        filter.setMagazzino((String) map.get("magazzino"));
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

  private void setcodicePrecedenteBackOffice(String string) {
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

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getIndirizzo() {
    return indirizzo;
  }

  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }

  public String getCitta() {
    return citta;
  }

  public void setCitta(String citta) {
    this.citta = citta;
  }

  public String getCap() {
    return cap;
  }

  public void setCap(String cap) {
    this.cap = cap;
  }

  public String getPiva() {
    return piva;
  }

  public void setPiva(String piva) {
    this.piva = piva;
  }

  public String getMagazzino() {
    return magazzino;
  }

  public void setMagazzino(String magazzino) {
    this.magazzino = magazzino;
  }

  public String getCodiceEsterno() {
    return codiceEsterno;
  }

  public void setCodiceEsterno(String codiceEsterno) {
    this.codiceEsterno = codiceEsterno;
  }

  public String getRagioneSociale() {
    return ragioneSociale;
  }

  public void setRagioneSociale(String ragioneSociale) {
    this.ragioneSociale = ragioneSociale;
  }

  public String getCodiceFiscale() {
    return codiceFiscale;
  }

  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  public String getTipoCod() {
    return tipoCod;
  }

  public void setTipoCod(String tipoCod) {
    this.tipoCod = tipoCod;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCodiceEsterno2() {
    return codiceEsterno2;
  }

  public void setCodiceEsterno2(String codiceEsterno2) {
    this.codiceEsterno2 = codiceEsterno2;
  }

  public String getCodiceContabilita() {
    return codiceContabilita;
  }

  public void setCodiceContabilita(String codiceContabilita) {
    this.codiceContabilita = codiceContabilita;
  }

  public String getCodicePrecedenteBackOffice() {
    return codicePrecedenteBackOffice;
  }

  public void setCodicePrecedenteBackOffice(String codicePrecedenteBackOffice) {
    this.codicePrecedenteBackOffice = codicePrecedenteBackOffice;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
