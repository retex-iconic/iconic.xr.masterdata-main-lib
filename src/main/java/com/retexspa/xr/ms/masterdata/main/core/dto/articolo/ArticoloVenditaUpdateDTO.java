package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDateTime;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ArticoloVenditaUpdateDTO {
  private String nome;
  private String descrizione;
  private String statoId;
  private String tipoArticoloVenditaId;
  private String sottotipoArticoloVenditaId;
  private Double costo; // prezzo acquisto dal Fornitore
  private Integer tara; // espressa in grammi da -1 a 99 (default 0)
  private Integer
      maxArt; // Permette di limitare il numero massimo di pezzi vendibili in uno scontrino
  private String oraInizio;
  private String oraFine;
  private LocalDateTime dataOraInizio;
  private LocalDateTime dataOraFine;
  private Integer aa3; // 1=articolo che appartiene al gruppo UDIGS1; 0 = non appartiene
  private Integer
      aa4; // 1 = articolo appartiene al gruppo STAMPA_CODICI_UNI VOCI; 0 = non appartiene

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

  public String getStatoId() {
    return statoId;
  }

  public void setStatoId(String statoId) {
    this.statoId = statoId;
  }

  public String getTipoArticoloVenditaId() {
    return tipoArticoloVenditaId;
  }

  public void setTipoArticoloVenditaId(String tipoId) {
    this.tipoArticoloVenditaId = tipoId;
  }

  public String getSottotipoArticoloVenditaId() {
    return sottotipoArticoloVenditaId;
  }

  public void setSottotipoArticoloVenditaId(String sottotipoId) {
    this.sottotipoArticoloVenditaId = sottotipoId;
  }

  public Double getCosto() {
    return costo;
  }

  public void setCosto(Double costo) {
    this.costo = costo;
  }

  public Integer getTara() {
    return tara;
  }

  public void setTara(Integer tara) {
    this.tara = tara;
  }

  public Integer getMaxArt() {
    return maxArt;
  }

  public void setMaxArt(Integer maxArt) {
    this.maxArt = maxArt;
  }

  public String getOraInizio() {
    return oraInizio;
  }

  public void setOraInizio(String oraInizio) {
    this.oraInizio = oraInizio;
  }

  public String getOraFine() {
    return oraFine;
  }

  public void setOraFine(String oraFine) {
    this.oraFine = oraFine;
  }

  public LocalDateTime getDataOraInizio() {
    return dataOraInizio;
  }

  public void setDataOraInizio(LocalDateTime dataOraInizio) {
    this.dataOraInizio = dataOraInizio;
  }

  public LocalDateTime getDataOraFine() {
    return dataOraFine;
  }

  public void setDataOraFine(LocalDateTime dataOraFine) {
    this.dataOraFine = dataOraFine;
  }

  public Integer getAa3() {
    return aa3;
  }

  public void setAa3(Integer aa3) {
    this.aa3 = aa3;
  }

  public Integer getAa4() {
    return aa4;
  }

  public void setAa4(Integer aa4) {
    this.aa4 = aa4;
  }
}
