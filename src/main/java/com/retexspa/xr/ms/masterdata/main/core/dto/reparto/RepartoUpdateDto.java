package com.retexspa.xr.ms.masterdata.main.core.dto.reparto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RepartoUpdateDto {
  @NotNull(message = "nome is mandatory")
  private String nome;

  @NotNull(message = "descrizione is mandatory")
  private String descrizione;

  private String backClr;
  private String bloccoPre;
  private LocalDateTime dataCas;
  private String dataOraUpd;
  private String dataFunc;
  private String dataType;
  private String erogaPunti;
  private String erogaBuoni;
  private String erogaSconti;
  private String flgTicket;
  private String flgPunti;
  private String flgBuoni;
  private String flgSconti;
  private String accettaPagamentoTicketRestaurant;
  private String idSendEcr;
  private Double margine;

  private BigDecimal margineFisso;

  private String repEcr;
  private String repLoc;
  private String repCedi;
  private String repEkom;
  private BigDecimal scontoPercentuale;

  private Integer sconto;
  private String tracciabilitaOrtofrutta;
  private String tracciabilitaMacelleria;
  private String tracciabilitaPescheria;
  private String tracciabilitaGastronomia;

  private String flgOrto;
  private String flgMacel;
  private String flgPescheria;
  private String flgGastro;

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

  public String getBackClr() {
    return backClr;
  }

  public void setBackClr(String backClr) {
    this.backClr = backClr;
  }

  public String getBloccoPre() {
    return bloccoPre;
  }

  public void setBloccoPre(String bloccoPre) {
    this.bloccoPre = bloccoPre;
  }

  public LocalDateTime getDataCas() {
    return dataCas;
  }

  public void setDataCas(LocalDateTime dataCas) {
    this.dataCas = dataCas;
  }

  public String getDataOraUpd() {
    return dataOraUpd;
  }

  public void setDataOraUpd(String dataOraUpd) {
    this.dataOraUpd = dataOraUpd;
  }

  public String getDataFunc() {
    return dataFunc;
  }

  public void setDataFunc(String dataFunc) {
    this.dataFunc = dataFunc;
  }

  public String getDataType() {
    return dataType;
  }

  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  public String getErogaPunti() {
    return erogaPunti;
  }

  public void setErogaPunti(String erogaPunti) {
    this.erogaPunti = erogaPunti;
  }

  public String getErogaBuoni() {
    return erogaBuoni;
  }

  public void setErogaBuoni(String erogaBuoni) {
    this.erogaBuoni = erogaBuoni;
  }

  public String getErogaSconti() {
    return erogaSconti;
  }

  public void setErogaSconti(String erogaSconti) {
    this.erogaSconti = erogaSconti;
  }

  public String getFlgTicket() {
    return flgTicket;
  }

  public void setFlgTicket(String flgTicket) {
    this.flgTicket = flgTicket;
  }

  public String getFlgPunti() {
    return flgPunti;
  }

  public void setFlgPunti(String flgPunti) {
    this.flgPunti = flgPunti;
  }

  public String getFlgBuoni() {
    return flgBuoni;
  }

  public void setFlgBuoni(String flgBuoni) {
    this.flgBuoni = flgBuoni;
  }

  public String getFlgSconti() {
    return flgSconti;
  }

  public void setFlgSconti(String flgSconti) {
    this.flgSconti = flgSconti;
  }

  public String getAccettaPagamentoTicketRestaurant() {
    return accettaPagamentoTicketRestaurant;
  }

  public void setAccettaPagamentoTicketRestaurant(String accettaPagamentoTicketRestaurant) {
    this.accettaPagamentoTicketRestaurant = accettaPagamentoTicketRestaurant;
  }

  public String getIdSendEcr() {
    return idSendEcr;
  }

  public void setIdSendEcr(String idSendEcr) {
    this.idSendEcr = idSendEcr;
  }

  public Double getMargine() {
    return margine;
  }

  public void setMargine(Double margine) {
    this.margine = margine;
  }

  public BigDecimal getMargineFisso() {
    return margineFisso;
  }

  public void setMargineFisso(BigDecimal margineFisso) {
    this.margineFisso = margineFisso;
  }

  public String getRepEcr() {
    return repEcr;
  }

  public void setRepEcr(String repEcr) {
    this.repEcr = repEcr;
  }

  public String getRepLoc() {
    return repLoc;
  }

  public void setRepLoc(String repLoc) {
    this.repLoc = repLoc;
  }

  public String getRepCedi() {
    return repCedi;
  }

  public void setRepCedi(String repCedi) {
    this.repCedi = repCedi;
  }

  public String getRepEkom() {
    return repEkom;
  }

  public void setRepEkom(String repEkom) {
    this.repEkom = repEkom;
  }

  public BigDecimal getScontoPercentuale() {
    return scontoPercentuale;
  }

  public void setScontoPercentuale(BigDecimal scontoPercentuale) {
    this.scontoPercentuale = scontoPercentuale;
  }

  public Integer getSconto() {
    return sconto;
  }

  public void setSconto(Integer sconto) {
    this.sconto = sconto;
  }

  public String getTracciabilitaOrtofrutta() {
    return tracciabilitaOrtofrutta;
  }

  public void setTracciabilitaOrtofrutta(String tracciabilitaOrtofrutta) {
    this.tracciabilitaOrtofrutta = tracciabilitaOrtofrutta;
  }

  public String getTracciabilitaMacelleria() {
    return tracciabilitaMacelleria;
  }

  public void setTracciabilitaMacelleria(String tracciabilitaMacelleria) {
    this.tracciabilitaMacelleria = tracciabilitaMacelleria;
  }

  public String getTracciabilitaPescheria() {
    return tracciabilitaPescheria;
  }

  public void setTracciabilitaPescheria(String tracciabilitaPescheria) {
    this.tracciabilitaPescheria = tracciabilitaPescheria;
  }

  public String getTracciabilitaGastronomia() {
    return tracciabilitaGastronomia;
  }

  public void setTracciabilitaGastronomia(String tracciabilitaGastronomia) {
    this.tracciabilitaGastronomia = tracciabilitaGastronomia;
  }

  public String getFlgOrto() {
    return flgOrto;
  }

  public void setFlgOrto(String flgOrto) {
    this.flgOrto = flgOrto;
  }

  public String getFlgMacel() {
    return flgMacel;
  }

  public void setFlgMacel(String flgMacel) {
    this.flgMacel = flgMacel;
  }

  public String getFlgPescheria() {
    return flgPescheria;
  }

  public void setFlgPescheria(String flgPescheria) {
    this.flgPescheria = flgPescheria;
  }

  public String getFlgGastro() {
    return flgGastro;
  }

  public void setFlgGastro(String flgGastro) {
    this.flgGastro = flgGastro;
  }
}
