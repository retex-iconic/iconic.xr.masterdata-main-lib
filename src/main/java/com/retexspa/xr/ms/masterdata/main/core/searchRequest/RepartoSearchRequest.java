package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.BaseSortPagination;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class RepartoSearchRequest extends BaseSortPagination {
  private String id;
  private String nome;
  private String codice;
  private String descrizione;
  private String gerarchiaId;
  private String ivaId;
  private String padreId;
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
  private Integer sconto;
  private String repEcr;
  private String repLoc;
  private String repCedi;
  private Double margine;
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
  private Long version;

  public RepartoSearchRequest(Integer page, Integer limit, List<BaseSort> sort, String id, String nome, String codice,
      String descrizione,
      String gerarchiaId,
      String ivaId,
      String padreId,
      BigDecimal scontoPercentuale,
      BigDecimal margineFisso,
      String accettaPagamentoTicketRestaurant,
      String erogaPunti,
      String erogaBuoni,
      String erogaSconti,
      String tracciabilitaOrtofrutta,
      String tracciabilitaMacelleria,
      String tracciabilitaPescheria,
      String tracciabilitaGastronomia,
      Integer sconto,
      String repEcr,
      String repLoc,
      String repCedi,
      Double margine,
      String flgTicket,
      String flgPunti,
      String flgBuoni,
      String flgSconti,
      String dataType,
      String dataFunc,
      String backClr,
      String flgOrto,
      String flgMacel,
      String flgPescheria,
      String flgGastro,
      String repEkom,
      LocalDateTime dataCas,
      String idSendEcr,
      String dataOraUpd,
      String bloccoPre,
      Long version)

  {
    super(page, limit, sort);
    this.id = id;
    this.nome = nome;
    this.codice = codice;
    this.descrizione = descrizione;
    this.scontoPercentuale = scontoPercentuale;
    this.margineFisso = margineFisso;
    this.accettaPagamentoTicketRestaurant = accettaPagamentoTicketRestaurant;
    this.erogaPunti = erogaPunti;
    this.erogaBuoni = erogaBuoni;
    this.erogaSconti = erogaSconti;
    this.tracciabilitaOrtofrutta = tracciabilitaOrtofrutta;
    this.tracciabilitaMacelleria = tracciabilitaMacelleria;
    this.tracciabilitaPescheria = tracciabilitaPescheria;
    this.tracciabilitaGastronomia = tracciabilitaGastronomia;
    this.sconto = sconto;
    this.repEcr = repEcr;
    this.repLoc = repLoc;
    this.repCedi = repCedi;
    this.margine = margine;
    this.flgTicket = flgTicket;
    this.flgPunti = flgPunti;
    this.flgBuoni = flgBuoni;
    this.flgSconti = flgSconti;
    this.dataType = dataType;
    this.dataFunc = dataFunc;
    this.backClr = backClr;
    this.flgOrto = flgOrto;
    this.flgMacel = flgMacel;
    this.flgPescheria = flgPescheria;
    this.flgGastro = flgGastro;
    this.repEkom = repEkom;
    this.dataCas = dataCas;
    this.idSendEcr = idSendEcr;
    this.dataOraUpd = dataOraUpd;
    this.bloccoPre = bloccoPre;
    this.ivaId = ivaId;
    this.gerarchiaId = gerarchiaId;
    this.padreId = padreId;
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

  public BigDecimal getScontoPercentuale() {
    return scontoPercentuale;
  }

  public void setScontoPercentuale(BigDecimal scontoPercentuale) {
    this.scontoPercentuale = scontoPercentuale;
  }

  public BigDecimal getMargineFisso() {
    return margineFisso;
  }

  public void setMargineFisso(BigDecimal margineFisso) {
    this.margineFisso = margineFisso;
  }

  public String getAccettaPagamentoTicketRestaurant() {
    return accettaPagamentoTicketRestaurant;
  }

  public void setAccettaPagamentoTicketRestaurant(String accettaPagamentoTicketRestaurant) {
    this.accettaPagamentoTicketRestaurant = accettaPagamentoTicketRestaurant;
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

  public Integer getSconto() {
    return sconto;
  }

  public void setSconto(Integer sconto) {
    this.sconto = sconto;
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

  public Double getMargine() {
    return margine;
  }

  public void setMargine(Double margine) {
    this.margine = margine;
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

  public String getDataType() {
    return dataType;
  }

  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  public String getDataFunc() {
    return dataFunc;
  }

  public void setDataFunc(String dataFunc) {
    this.dataFunc = dataFunc;
  }

  public String getBackClr() {
    return backClr;
  }

  public void setBackClr(String backClr) {
    this.backClr = backClr;
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

  public String getRepEkom() {
    return repEkom;
  }

  public void setRepEkom(String repEkom) {
    this.repEkom = repEkom;
  }

  public LocalDateTime getDataCas() {
    return dataCas;
  }

  public void setDataCas(LocalDateTime dataCas) {
    this.dataCas = dataCas;
  }

  public String getIdSendEcr() {
    return idSendEcr;
  }

  public void setIdSendEcr(String idSendEcr) {
    this.idSendEcr = idSendEcr;
  }

  public String getDataOraUpd() {
    return dataOraUpd;
  }

  public void setDataOraUpd(String dataOraUpd) {
    this.dataOraUpd = dataOraUpd;
  }

  public String getBloccoPre() {
    return bloccoPre;
  }

  public void setBloccoPre(String bloccoPre) {
    this.bloccoPre = bloccoPre;
  }

  public String getIvaId() {
    return ivaId;
  }

  public void setIvaId(String ivaId) {
    this.ivaId = ivaId;
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

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

}
