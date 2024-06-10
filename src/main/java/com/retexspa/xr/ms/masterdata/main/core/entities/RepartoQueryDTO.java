package com.retexspa.xr.ms.masterdata.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
@Data
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public class RepartoQueryDTO {
  private String id;
  private String gerarchiaId;
  private String padreId;
  private String ivaId;

  // TLPosWIN
  private String nome;
  private String codice;
  private String descrizione;
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
  private Integer Sconto;
  private String RepEcr;
  private String RepLoc;
  private String RepCedi;
  private Double Margine;
  private String FlgTicket;
  private String FlgPunti;
  private String FlgBuoni;
  private String FlgSconti;
  private String DataType;
  private String DataFunc;
  private String BackClr;
  private String FlgOrto;
  private String FlgMacel;
  private String FlgPescheria;
  private String FlgGastro;
  private String RepEkom;
  private LocalDateTime DataCas;
  private String IdSendEcr;
  private String DataOraUpd;
  private String BloccoPre;
  private Long version;


  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getGerarchiaId() {
    return this.gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getPadreId() {
    return this.padreId;
  }

  public void setPadreId(String padreId) {
    this.padreId = padreId;
  }

  public String getIvaId() {
    return this.ivaId;
  }

  public void setIvaId(String ivaId) {
    this.ivaId = ivaId;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCodice() {
    return this.codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public String getDescrizione() {
    return this.descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
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
    return this.Sconto;
  }

  public void setSconto(Integer Sconto) {
    this.Sconto = Sconto;
  }

  public String getRepEcr() {
    return this.RepEcr;
  }

  public void setRepEcr(String RepEcr) {
    this.RepEcr = RepEcr;
  }

  public String getRepLoc() {
    return this.RepLoc;
  }

  public void setRepLoc(String RepLoc) {
    this.RepLoc = RepLoc;
  }

  public String getRepCedi() {
    return this.RepCedi;
  }

  public void setRepCedi(String RepCedi) {
    this.RepCedi = RepCedi;
  }

  public Double getMargine() {
    return this.Margine;
  }

  public void setMargine(Double Margine) {
    this.Margine = Margine;
  }

  public String getFlgTicket() {
    return this.FlgTicket;
  }

  public void setFlgTicket(String FlgTicket) {
    this.FlgTicket = FlgTicket;
  }

  public String getFlgPunti() {
    return this.FlgPunti;
  }

  public void setFlgPunti(String FlgPunti) {
    this.FlgPunti = FlgPunti;
  }

  public String getFlgBuoni() {
    return this.FlgBuoni;
  }

  public void setFlgBuoni(String FlgBuoni) {
    this.FlgBuoni = FlgBuoni;
  }

  public String getFlgSconti() {
    return this.FlgSconti;
  }

  public void setFlgSconti(String FlgSconti) {
    this.FlgSconti = FlgSconti;
  }

  public String getDataType() {
    return this.DataType;
  }

  public void setDataType(String DataType) {
    this.DataType = DataType;
  }

  public String getDataFunc() {
    return this.DataFunc;
  }

  public void setDataFunc(String DataFunc) {
    this.DataFunc = DataFunc;
  }

  public String getBackClr() {
    return this.BackClr;
  }

  public void setBackClr(String BackClr) {
    this.BackClr = BackClr;
  }

  public String getFlgOrto() {
    return this.FlgOrto;
  }

  public void setFlgOrto(String FlgOrto) {
    this.FlgOrto = FlgOrto;
  }

  public String getFlgMacel() {
    return this.FlgMacel;
  }

  public void setFlgMacel(String FlgMacel) {
    this.FlgMacel = FlgMacel;
  }

  public String getFlgPescheria() {
    return this.FlgPescheria;
  }

  public void setFlgPescheria(String FlgPescheria) {
    this.FlgPescheria = FlgPescheria;
  }

  public String getFlgGastro() {
    return this.FlgGastro;
  }

  public void setFlgGastro(String FlgGastro) {
    this.FlgGastro = FlgGastro;
  }

  public String getRepEkom() {
    return this.RepEkom;
  }

  public void setRepEkom(String RepEkom) {
    this.RepEkom = RepEkom;
  }

  public LocalDateTime getDataCas() {
    return this.DataCas;
  }

  public void setDataCas(LocalDateTime DataCas) {
    this.DataCas = DataCas;
  }

  public String getIdSendEcr() {
    return this.IdSendEcr;
  }

  public void setIdSendEcr(String IdSendEcr) {
    this.IdSendEcr = IdSendEcr;
  }

  public String getDataOraUpd() {
    return this.DataOraUpd;
  }

  public void setDataOraUpd(String DataOraUpd) {
    this.DataOraUpd = DataOraUpd;
  }

  public String getBloccoPre() {
    return this.BloccoPre;
  }

  public void setBloccoPre(String BloccoPre) {
    this.BloccoPre = BloccoPre;
  }

  public Long getVersion() {
    return this.version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }




}
