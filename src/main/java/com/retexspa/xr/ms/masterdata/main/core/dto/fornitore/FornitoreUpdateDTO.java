package com.retexspa.xr.ms.masterdata.main.core.dto.fornitore;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FornitoreUpdateDTO {

  private String nome;

  private String descrizione;

  private String numero;

  private String indirizzo;

  private String citta;

  private String cap;

  private String piva;

  private String ragioneSociale;

  private String codiceFiscale;

  private String telefono;

  private String email;

  private String codiceEsterno;

  private String rank;

  private String tipocod;

  private String codiceEsterno2;

  private String codiceContabilita;

  private String codicePrecedenteBackOffice;

  private String magazzino;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCodiceEsterno() {
    return codiceEsterno;
  }

  public void setCodiceEsterno(String codiceEsterno) {
    this.codiceEsterno = codiceEsterno;
  }

  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  public String getTipocod() {
    return tipocod;
  }

  public void setTipocod(String tipocod) {
    this.tipocod = tipocod;
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

  public String getMagazzino() {
    return magazzino;
  }

  public void setMagazzino(String magazzino) {
    this.magazzino = magazzino;
  }
}
