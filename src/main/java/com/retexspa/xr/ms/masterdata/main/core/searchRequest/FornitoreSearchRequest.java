package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;

import java.util.List;

public class FornitoreSearchRequest extends BaseSortPagination {

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

  public FornitoreSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String nome,
      String codice,
      String descrizione,
      String gerarchiaId,
      String padreId,
      String numero,
      String indirizzo,
      String citta,
      String cap,
      String piva,
      String magazzino,
      String codiceEsterno,
      String ragioneSociale,
      String codiceFiscale,
      String telefono,
      String rank,
      String tipoCod,
      String email,
      String codiceEsterno2,
      String codiceContabilita,
      String codicePrecedenteBackOffice,
      Long version) {
    super(page, limit, sort);
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
