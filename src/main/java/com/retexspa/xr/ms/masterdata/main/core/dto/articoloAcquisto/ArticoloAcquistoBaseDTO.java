package com.retexspa.xr.ms.masterdata.main.core.dto.articoloAcquisto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;

import java.math.BigDecimal;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class ArticoloAcquistoBaseDTO extends BaseDTO {

  private String codiceMoltiplicatore;

  public String getCodiceMoltiplicatore() {
    return this.codiceMoltiplicatore;
  }

  public void setCodiceMoltiplicatore(String codiceMoltiplicatore) {
    this.codiceMoltiplicatore = codiceMoltiplicatore;
  }

  // @NotNull(message = "fornitoreId is mandatory")
  // @NotEmpty(message = "fornitoreId is mandatory")
  // @NotBlank(message = "fornitoreId is mandatory")
  // private String fornitoreId;

  @NotNull(message = "articoloId is mandatory")
  @NotEmpty(message = "articoloId is mandatory")
  @NotBlank(message = "articoloId is mandatory")
  private String articoloId;

  private String costoCartone;

  private BigDecimal pezziCartone;

  private Integer lottoRiordino;

  private String note;

  /*
  #define TIPOARTICOLO_GENERICO     1 /// G
  #define TIPOARTICOLO_NUOVO        2 /// N
  #define TIPOARTICOLO_PERIODICO    3 /// P
  #define TIPOARTICOLO_MARCHIO      4 /// M
  #define TIPOARTICOLO_DISCOUNT     5 /// D
  #define TIPOARTICOLO_CANCELLATO   6 /// C
  #define TIPOARTICOLO_REGALO       7 /// R
  #define TIPOARTICOLO_USOINTERNO   8 /// U
  #define TIPOARTICOLO_BUONOSCONTO  9 /// B
  #define TIPOARTICOLO_PREPARATO   10 /// S
  #define TIPOARTICOLO_GIFTCARD    11 /// F
  #define TIPOARTICOLO_RICARICA    12 /// T
  #define TIPOARTICOLO_COSTO_CONF  13 /// I Costo confezione  - IconicMobile
  #define TIPOARTICOLO_SPESA_CONF  14 /// J Spese di confezionamento - IconicMobile
  #define TIPOARTICOLO_CESTO_ADD   15 /// K extra nel cesto - IconicMobile
  #define TIPOARTICOLO_CUSTOM0     16 /// 0 Customizzabile da cliente
  #define TIPOARTICOLO_CUSTOM1     17 /// 1 Customizzabile da cliente
  #define TIPOARTICOLO_CUSTOM2     18 /// 2 Customizzabile da cliente
  #define TIPOARTICOLO_CUSTOM3     19 /// 3 Customizzabile da cliente
  #define TIPOARTICOLO_CUSTOM4     10 /// 4 Customizzabile da cliente
  #define TIPOARTICOLO_CUSTOM5     21 /// 5 Customizzabile da cliente
  #define TIPOARTICOLO_CUSTOM6     22 /// 6 Customizzabile da cliente
  #define TIPOARTICOLO_CUSTOM7     23 /// 7 Customizzabile da cliente
  #define TIPOARTICOLO_CUSTOM8     24 /// 8 Customizzabile da cliente
  #define TIPOARTICOLO_CUSTOM9     25 /// 9 Customizzabile da cliente
  */
  private String tipo;

  private Integer unitaDiMisura;

  private String quantita;

  private String codiceEsterno;

  public String getArticoloId() {
    return this.articoloId;
  }

  public void setArticoloId(String articoloId) {
    this.articoloId = articoloId;
  }

  public String getCostoCartone() {
    return this.costoCartone;
  }

  public void setCostoCartone(String costoCartone) {
    this.costoCartone = costoCartone;
  }

  public BigDecimal getPezziCartone() {
    return this.pezziCartone;
  }

  public void setPezziCartone(BigDecimal pezziCartone) {
    this.pezziCartone = pezziCartone;
  }

  public Integer getLottoRiordino() {
    return this.lottoRiordino;
  }

  public void setLottoRiordino(Integer lottoRiordino) {
    this.lottoRiordino = lottoRiordino;
  }

  public String getNote() {
    return this.note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getTipo() {
    return this.tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Integer getUnitaDiMisura() {
    return this.unitaDiMisura;
  }

  public void setUnitaDiMisura(Integer unitaDiMisura) {
    this.unitaDiMisura = unitaDiMisura;
  }

  public String getQuantita() {
    return this.quantita;
  }

  public void setQuantita(String quantita) {
    this.quantita = quantita;
  }

  public String getCodiceEsterno() {
    return this.codiceEsterno;
  }

  public void setCodiceEsterno(String codiceEsterno) {
    this.codiceEsterno = codiceEsterno;
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }
}
