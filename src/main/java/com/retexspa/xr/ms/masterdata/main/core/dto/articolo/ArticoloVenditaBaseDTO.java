package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;
import com.retexspa.xr.ms.main.core.dto.attributo.AttributoValoreDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ArticoloVenditaBaseDTO extends BaseDTO {

  @NotNull(message = "articoloId is mandatory")
  private String articoloId;

  // TODO: master_data_config
  @NotNull(message = "statoId is mandatory")
  private String statoId;

  // TODO: master_data_config
  @NotNull(message = "tipoId is mandatory")
  private String tipoArticoloVenditaId;
  /*
   * Tipo articolo: 1=a pezzo,
   * 2=a peso,
   * 10=a peso con forzatura prezzo,
   * 51=vuoto,
   * 63=bollone,
   * 98=servizio,
   * 99=ricarica telefonica,
   * 100=voucher emesso
   */

  // obbligatorio se tipoId = 98
  private String sottotipoArticoloVenditaId;

  // @NotNull(message = "repartoId is mandatory")
  // NON obbligatorio se tipoId = 100
  private String repartoId;

  // @NotNull(message = "ivaId is mandatory")
  // NON obbligatorio se tipoId = 100
  private String ivaId;

  private Double costo; // prezzo acquisto dal Fornitore

  private List<AttributoValoreDTO> attributi;

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

  public String getArticoloId() {
    return articoloId;
  }

  public void setArticoloId(String articoloId) {
    this.articoloId = articoloId;
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

  public String getRepartoId() {
    return repartoId;
  }

  public void setRepartoId(String repartoId) {
    this.repartoId = repartoId;
  }

  public String getIvaId() {
    return ivaId;
  }

  public void setIvaId(String ivaId) {
    this.ivaId = ivaId;
  }

  public Double getCosto() {
    return costo;
  }

  public void setCosto(Double costo) {
    this.costo = costo;
  }

  public List<AttributoValoreDTO> getAttributi() {
    return attributi;
  }

  public void setAttributi(List<AttributoValoreDTO> config) {
    this.attributi = config;
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

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }

  public static String getName() {
    return "ArticoloVendita";
  }

  public static String getAggregateName() {
    return "ArticoloVenditaAggregate";
  }
}
