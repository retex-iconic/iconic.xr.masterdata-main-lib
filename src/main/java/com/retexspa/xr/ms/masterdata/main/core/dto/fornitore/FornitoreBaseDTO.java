package com.retexspa.xr.ms.masterdata.main.core.dto.fornitore;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;

import java.util.UUID;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FornitoreBaseDTO extends BaseDTO {

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

  // @NotNull(message = "negozioIds is mandatory")
  // private String[] negozioIds;

  public String getNumero() {
    return this.numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getIndirizzo() {
    return this.indirizzo;
  }

  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }

  public String getCitta() {
    return this.citta;
  }

  public void setCitta(String citta) {
    this.citta = citta;
  }

  public String getCap() {
    return this.cap;
  }

  public void setCap(String cap) {
    this.cap = cap;
  }

  public String getPiva() {
    return this.piva;
  }

  public void setPiva(String piva) {
    this.piva = piva;
  }

  public String getRagioneSociale() {
    return this.ragioneSociale;
  }

  public void setRagioneSociale(String ragioneSociale) {
    this.ragioneSociale = ragioneSociale;
  }

  public String getCodiceFiscale() {
    return this.codiceFiscale;
  }

  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }

  public String getTelefono() {
    return this.telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCodiceEsterno() {
    return this.codiceEsterno;
  }

  public void setCodiceEsterno(String codiceEsterno) {
    this.codiceEsterno = codiceEsterno;
  }

  public String getRank() {
    return this.rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  public String getTipocod() {
    return this.tipocod;
  }

  public void setTipocod(String tipocod) {
    this.tipocod = tipocod;
  }

  public String getCodiceEsterno2() {
    return this.codiceEsterno2;
  }

  public void setCodiceEsterno2(String codiceEsterno2) {
    this.codiceEsterno2 = codiceEsterno2;
  }

  public String getCodiceContabilita() {
    return this.codiceContabilita;
  }

  public void setCodiceContabilita(String codiceContabilita) {
    this.codiceContabilita = codiceContabilita;
  }

  public String getCodicePrecedenteBackOffice() {
    return this.codicePrecedenteBackOffice;
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

  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }
}
