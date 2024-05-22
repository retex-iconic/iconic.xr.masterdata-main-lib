package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ArticoloEanBaseDTO {

  @NotNull(message = "articoloId is mandatory")
  @NotEmpty(message = "articoloId is mandatory")
  @NotBlank(message = "articoloId is mandatory")
  private String articoloId;

  @NotNull(message = "codice is mandatory")
  @NotEmpty(message = "codice is mandatory")
  @NotBlank(message = "codice is mandatory")
  private String codice;

  @NotNull(message = "descrizione is mandatory")
  private String descrizione;

  private String padreId;

  @NotNull(message = "gerarchiaId is mandatory")
  @NotEmpty(message = "gerarchiaId is mandatory")
  @NotBlank(message = "gerarchiaId is mandatory")
  private String gerarchiaId;

  // master_data_config
  private String codiceMoltiplicatoreId;
  /*
   * 0 = quantità 1
   * 1 = moltiplicatore per quantita_codice_vendita
   * 2 = divisore per quantita_codice_vendita da master_data_config per chiave
   * articolo_vendita_ean.tipo_moltiplicatore
   */

  private Integer moltiplicatore;
  private String codiceVenditaLocale; // flg S/N , inserito da negozio
  private String descrizioneCodiceVendita;
  private Double prezzoCodiceVendita;
  private Double quantitaCodiceVendita;
  private Double scontoCodiceVendita;

  // master_data_config
  private String statoId;
  /*
   * vuoto = attivo
   * P = secondo prezzo = stai dicendo che l'ean ha un altro prezzo rispetto
   * all'articolo
   * Q = vendita a peso = indica che la parte calcolata contiene il peso e non il
   * prezzo
   * B = checkout = dici che il plu va pesato in cassa
   * T = tasto reparto = gli stai dicendo che quel ean è un tasto reparto
   * Z = scadenza articolo = applica un prezzo diverso in caso di articoli in
   * scadenza
   * S = sospeso = non vendibile
   * X = in cancellazione (cioè l'ean è da cancellare e non è ancora stato inviato
   * in cassa per la ancellazione)
   */

  // master_data_config
  private String tipoEanId;

  private String anagBil;

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "FlgCancellato not valid")
  private String flgCancellato;

  public String getArticoloId() {
    return articoloId;
  }

  public void setArticoloId(String articoloId) {
    this.articoloId = articoloId;
  }

  public String getCodiceMoltiplicatoreId() {
    return codiceMoltiplicatoreId;
  }

  public void setCodiceMoltiplicatoreId(String codiceMoltiplicatoreId) {
    this.codiceMoltiplicatoreId = codiceMoltiplicatoreId;
  }

  public Integer getMoltiplicatore() {
    return moltiplicatore;
  }

  public void setMoltiplicatore(Integer moltiplicatore) {
    this.moltiplicatore = moltiplicatore;
  }

  public String getCodiceVenditaLocale() {
    return codiceVenditaLocale;
  }

  public void setCodiceVenditaLocale(String codiceVenditaLocale) {
    this.codiceVenditaLocale = codiceVenditaLocale;
  }

  public String getDescrizioneCodiceVendita() {
    return descrizioneCodiceVendita;
  }

  public void setDescrizioneCodiceVendita(String descrizioneCodiceVendita) {
    this.descrizioneCodiceVendita = descrizioneCodiceVendita;
  }

  public Double getPrezzoCodiceVendita() {
    return prezzoCodiceVendita;
  }

  public void setPrezzoCodiceVendita(Double prezzoCodiceVendita) {
    this.prezzoCodiceVendita = prezzoCodiceVendita;
  }

  public Double getQuantitaCodiceVendita() {
    return quantitaCodiceVendita;
  }

  public void setQuantitaCodiceVendita(Double quantitaCodiceVendita) {
    this.quantitaCodiceVendita = quantitaCodiceVendita;
  }

  public Double getScontoCodiceVendita() {
    return scontoCodiceVendita;
  }

  public void setScontoCodiceVendita(Double scontoCodiceVendita) {
    this.scontoCodiceVendita = scontoCodiceVendita;
  }

  public String getStatoId() {
    return statoId;
  }

  public void setStatoId(String statoId) {
    this.statoId = statoId;
  }

  public String getTipoEanId() {
    return tipoEanId;
  }

  public void setTipoEanId(String tipoEanId) {
    this.tipoEanId = tipoEanId;
  }

  public String getAnagBil() {
    return anagBil;
  }

  public void setAnagBil(String anagBil) {
    this.anagBil = anagBil;
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

  public String getPadreId() {
    return padreId;
  }

  public void setPadreId(String padreId) {
    this.padreId = padreId;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = (flgCancellato == null ? "N" : flgCancellato);
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }

  public static String getDetailNameArticoloEan() {
    return "ArticoloEan";
  }

  public static String getDetailNameArticoloEanAggregate() {
    return "ArticoloEanAggregate";
  }
}
