package com.retexspa.xr.ms.masterdata.main.core.dto.reparto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RepartoBaseDTO extends BaseDTO {

  @NotNull(message = "ivaId is mandatory")
  @NotEmpty(message = "ivaId is mandatory")
  @NotBlank(message = "ivaId is mandatory")
  private String ivaId;
  // TLPosWIN
  private BigDecimal scontoPercentuale;
  private BigDecimal margineFisso;
  private String accettaPagamentoTicketRestaurant;
  private String erogaPunti;
  private String erogaBuoni;
  private String erogaSconti;
  private String tracciabilitaOrtofrutta;
  private String tracciabilitaMacelleria;
  private String tracciabilitaPescheria;
  private String tracciabilitaGastronomia;

  // definizione campi aggiuntivi presenti in TL
  private Integer sconto;
  private String repEcr;
  private String repLoc;
  private String repCedi;
  private Double margine;
  // private Double iva;
  private String flgTicket;
  private String flgPunti;
  private String flgBuoni;
  private String flgSconti;
  private String dataType;
  private String dataFunc;
  private String backClr;
  private String flgOrto;
  private String flgMacel;
  private String flgPescheria;
  private String flgGastro;
  private String repEkom;
  private LocalDateTime dataCas;
  private String idSendEcr;
  private String dataOraUpd;
  private String bloccoPre;

  private String flgCancellato;

  public String getIvaId() {
    return ivaId;
  }

  public String getFlgCancellato() {
    return this.flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }

  public void setIvaId(String ivaId) {
    this.ivaId = ivaId;
  }

  public BigDecimal getScontoPercentuale() {
    return this.scontoPercentuale;
  }

  public void setScontoPercentuale(BigDecimal scontoPercentuale) {
    this.scontoPercentuale = scontoPercentuale;
  }

  public BigDecimal getMargineFisso() {
    return this.margineFisso;
  }

  public void setMargineFisso(BigDecimal margineFisso) {
    this.margineFisso = margineFisso;
  }

  public String getAccettaPagamentoTicketRestaurant() {
    return this.accettaPagamentoTicketRestaurant;
  }

  public void setAccettaPagamentoTicketRestaurant(String accettaPagamentoTicketRestaurant) {
    this.accettaPagamentoTicketRestaurant = accettaPagamentoTicketRestaurant;
  }

  public String getErogaPunti() {
    return this.erogaPunti;
  }

  public void setErogaPunti(String erogaPunti) {
    this.erogaPunti = erogaPunti;
  }

  public String getErogaBuoni() {
    return this.erogaBuoni;
  }

  public void setErogaBuoni(String erogaBuoni) {
    this.erogaBuoni = erogaBuoni;
  }

  public String getErogaSconti() {
    return this.erogaSconti;
  }

  public void setErogaSconti(String erogaSconti) {
    this.erogaSconti = erogaSconti;
  }

  public String getTracciabilitaOrtofrutta() {
    return this.tracciabilitaOrtofrutta;
  }

  public void setTracciabilitaOrtofrutta(String tracciabilitaOrtofrutta) {
    this.tracciabilitaOrtofrutta = tracciabilitaOrtofrutta;
  }

  public String getTracciabilitaMacelleria() {
    return this.tracciabilitaMacelleria;
  }

  public void setTracciabilitaMacelleria(String tracciabilitaMacelleria) {
    this.tracciabilitaMacelleria = tracciabilitaMacelleria;
  }

  public String getTracciabilitaPescheria() {
    return this.tracciabilitaPescheria;
  }

  public void setTracciabilitaPescheria(String tracciabilitaPescheria) {
    this.tracciabilitaPescheria = tracciabilitaPescheria;
  }

  public String getTracciabilitaGastronomia() {
    return this.tracciabilitaGastronomia;
  }

  public void setTracciabilitaGastronomia(String tracciabilitaGastronomia) {
    this.tracciabilitaGastronomia = tracciabilitaGastronomia;
  }

  public Integer getSconto() {
    return this.sconto;
  }

  public void setSconto(Integer sconto) {
    this.sconto = sconto;
  }

  public String getRepEcr() {
    return this.repEcr;
  }

  public void setRepEcr(String repEcr) {
    this.repEcr = repEcr;
  }

  public String getRepLoc() {
    return this.repLoc;
  }

  public void setRepLoc(String repLoc) {
    this.repLoc = repLoc;
  }

  public String getRepCedi() {
    return this.repCedi;
  }

  public void setRepCedi(String repCedi) {
    this.repCedi = repCedi;
  }

  public Double getMargine() {
    return this.margine;
  }

  public void setMargine(Double margine) {
    this.margine = margine;
  }

  public String getFlgTicket() {
    return this.flgTicket;
  }

  public void setFlgTicket(String flgTicket) {
    this.flgTicket = flgTicket;
  }

  public String getFlgPunti() {
    return this.flgPunti;
  }

  public void setFlgPunti(String flgPunti) {
    this.flgPunti = flgPunti;
  }

  public String getFlgBuoni() {
    return this.flgBuoni;
  }

  public void setFlgBuoni(String flgBuoni) {
    this.flgBuoni = flgBuoni;
  }

  public String getFlgSconti() {
    return this.flgSconti;
  }

  public void setFlgSconti(String flgSconti) {
    this.flgSconti = flgSconti;
  }

  public String getDataType() {
    return this.dataType;
  }

  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  public String getDataFunc() {
    return this.dataFunc;
  }

  public void setDataFunc(String dataFunc) {
    this.dataFunc = dataFunc;
  }

  public String getBackClr() {
    return this.backClr;
  }

  public void setBackClr(String backClr) {
    this.backClr = backClr;
  }

  public String getFlgOrto() {
    return this.flgOrto;
  }

  public void setFlgOrto(String flgOrto) {
    this.flgOrto = flgOrto;
  }

  public String getFlgMacel() {
    return this.flgMacel;
  }

  public void setFlgMacel(String flgMacel) {
    this.flgMacel = flgMacel;
  }

  public String getFlgPescheria() {
    return this.flgPescheria;
  }

  public void setFlgPescheria(String flgPescheria) {
    this.flgPescheria = flgPescheria;
  }

  public String getFlgGastro() {
    return this.flgGastro;
  }

  public void setFlgGastro(String flgGastro) {
    this.flgGastro = flgGastro;
  }

  public String getRepEkom() {
    return this.repEkom;
  }

  public void setRepEkom(String repEkom) {
    this.repEkom = repEkom;
  }

  public LocalDateTime getDataCas() {
    return this.dataCas;
  }

  public void setDataCas(LocalDateTime dataCas) {
    this.dataCas = dataCas;
  }

  public String getIdSendEcr() {
    return this.idSendEcr;
  }

  public void setIdSendEcr(String idSendEcr) {
    this.idSendEcr = idSendEcr;
  }

  public String getDataOraUpd() {
    return this.dataOraUpd;
  }

  public void setDataOraUpd(String dataOraUpd) {
    this.dataOraUpd = dataOraUpd;
  }

  public String getBloccoPre() {
    return this.bloccoPre;
  }

  public void setBloccoPre(String bloccoPre) {
    this.bloccoPre = bloccoPre;
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }

  public static String getName() {
    return "Reparto";
  }

  public static String getAggregateName() {
    return "RepartoAggregate";
  }
}
