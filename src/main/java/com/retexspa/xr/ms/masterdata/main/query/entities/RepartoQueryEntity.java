package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.reparto.RepartoBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "reparto", uniqueConstraints = {
  @UniqueConstraint(name = "reparto_uk", columnNames = { "codice","gerarchia_id" })
})
public class RepartoQueryEntity {

  @Id @NonNull private String id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "codice")
  private String codice;

  @Column(name = "descrizione")
  private String descrizione;

  @Column(name = "scontoPercentuale")
  private BigDecimal scontoPercentuale;

  @Column(name = "margineFisso")
  private BigDecimal margineFisso;

  @Column(name = "accettaPagamentoTicketRestaurant")
  private String accettaPagamentoTicketRestaurant;

  @Column(name = "erogaPunti")
  private String erogaPunti;

  @Column(name = "erogaBuoni")
  private String erogaBuoni;

  @Column(name = "erogaSconti")
  private String erogaSconti;

  @Column(name = "tracciabilitaOrtofrutta")
  private String tracciabilitaOrtofrutta;

  @Column(name = "tracciabilitaMacelleria")
  private String tracciabilitaMacelleria;

  @Column(name = "tracciabilitaPescheria")
  private String tracciabilitaPescheria;

  @Column(name = "tracciabilitaGastronomia")
  private String tracciabilitaGastronomia;

  @Column(name = "sconto")
  private Integer sconto;

  @Column(name = "repEcr")
  private String repEcr;

  @Column(name = "repLoc")
  private String repLoc;

  @Column(name = "repCedi")
  private String repCedi;

  @Column(name = "margine")
  private Double margine;

  @Column(name = "flgTicket")
  private String flgTicket;

  @Column(name = "flgPunti")
  private String flgPunti;

  @Column(name = "flgBuoni")
  private String flgBuoni;

  @Column(name = "flgSconti")
  private String flgSconti;

  @Column(name = "dataType")
  private String dataType;

  @Column(name = "dataFunc")
  private String dataFunc;

  @Column(name = "backClr")
  private String backClr;

  @Column(name = "flgOrto")
  private String flgOrto;

  @Column(name = "flgMacel")
  private String flgMacel;

  @Column(name = "flgPescheria")
  private String flgPescheria;

  @Column(name = "flgGastro")
  private String flgGastro;

  @Column(name = "repEkom")
  private String repEkom;

  @Column(name = "dataCas")
  private LocalDateTime dataCas;

  @Column(name = "idSendEcr")
  private String idSendEcr;

  @Column(name = "dataOraUpd")
  private String dataOraUpd;

  @Column(name = "bloccoPre")
  private String bloccoPre;

  @Column(name = "flgcancellato")
  private String flgCancellato;

  @Column(name = "data_cancellazione")
  private LocalDateTime dataCancellazione;

  @Column(name = "version")
  private Long version;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "iva_id", referencedColumnName = "id")
  @JsonBackReference
  private IvaQueryEntity iva;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ateco_gerarchia"))
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "padre_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_reparto_padre"))
  private RepartoQueryEntity padre;

  public RepartoQueryEntity() {}

  public RepartoQueryEntity(@NotNull String repartoId, RepartoBaseDTO repartoDTO, Long version)
      throws IOException {
    this.id = repartoId;
    this.nome = repartoDTO.getNome();
    this.codice = repartoDTO.getCodice();

    this.scontoPercentuale = repartoDTO.getScontoPercentuale();
    this.margineFisso = repartoDTO.getMargineFisso();
    this.accettaPagamentoTicketRestaurant = repartoDTO.getAccettaPagamentoTicketRestaurant();
    this.erogaPunti = repartoDTO.getErogaPunti();
    this.erogaBuoni = repartoDTO.getErogaBuoni();
    this.erogaSconti = repartoDTO.getErogaSconti();
    this.tracciabilitaOrtofrutta = repartoDTO.getTracciabilitaOrtofrutta();
    this.tracciabilitaMacelleria = repartoDTO.getTracciabilitaMacelleria();
    this.tracciabilitaPescheria = repartoDTO.getTracciabilitaPescheria();
    this.tracciabilitaGastronomia = repartoDTO.getTracciabilitaGastronomia();
    this.descrizione = repartoDTO.getDescrizione();
    this.sconto = repartoDTO.getSconto();
    this.repEcr = repartoDTO.getRepEcr();
    this.repLoc = repartoDTO.getRepLoc();
    this.repCedi = repartoDTO.getRepCedi();
    this.margine = repartoDTO.getMargine();
    this.flgTicket = repartoDTO.getFlgTicket();
    this.flgPunti = repartoDTO.getFlgPunti();
    this.flgBuoni = repartoDTO.getFlgBuoni();
    this.flgSconti = repartoDTO.getFlgSconti();
    this.dataType = repartoDTO.getDataType();
    this.dataFunc = repartoDTO.getDataFunc();
    this.backClr = repartoDTO.getBackClr();
    this.flgOrto = repartoDTO.getFlgOrto();
    this.flgMacel = repartoDTO.getFlgMacel();
    this.flgPescheria = repartoDTO.getFlgPescheria();
    this.flgGastro = repartoDTO.getFlgGastro();
    this.repEkom = repartoDTO.getRepEkom();
    this.dataCas = repartoDTO.getDataCas();
    this.idSendEcr = repartoDTO.getIdSendEcr();
    this.dataOraUpd = repartoDTO.getDataOraUpd();
    this.bloccoPre = repartoDTO.getBloccoPre();
    this.version = version;
    this.flgCancellato = repartoDTO.getFlgCancellato();
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
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

  public GerarchiaQueryEntity getGerarchia() {
    return this.gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public RepartoQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(RepartoQueryEntity padre) {
    this.padre = padre;
  }

  public String getDescrizione() {
    return this.descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
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

  public IvaQueryEntity getIva() {
    return this.iva;
  }

  public void setIva(IvaQueryEntity iva) {
    this.iva = iva;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }

  public LocalDateTime getDataCancellazione() {
    return dataCancellazione;
  }

  public void setDataCancellazione(LocalDateTime dataCancellazione) {
    this.dataCancellazione = dataCancellazione;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
