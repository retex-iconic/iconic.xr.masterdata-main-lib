package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.articolo.ArticoloVenditaBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "articoli_vendita")
public class ArticoloVenditaQueryEntity {

  @Id @NonNull private String id;

  @ManyToOne(
      fetch = FetchType.LAZY,
      targetEntity = ArticoloQueryEntity.class,
      cascade = {CascadeType.PERSIST})
  @JsonIgnore
  private ArticoloQueryEntity articolo;

  @ManyToOne(fetch = FetchType.LAZY)
  private ArticoloVenditaQueryEntity padre;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  @Column(name = "nome")
  private String nome;

  @Column(name = "descrizione")
  private String descrizione;

  @Column(name = "codice")
  private String codice;

  @ManyToOne(fetch = FetchType.LAZY)
  private ConfigQueryEntity stato;

  @ManyToOne(fetch = FetchType.LAZY)
  private ConfigQueryEntity tipoArticoloVendita;

  @ManyToOne(fetch = FetchType.LAZY)
  private ConfigQueryEntity sottotipoArticoloVendita;

  @ManyToOne private RepartoQueryEntity reparto;

  @ManyToOne private IvaQueryEntity iva;

  @Column(name = "costo")
  private Double costo;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "articoloVendita")
  @JsonIgnore
  private Set<ArticoloVenditaAttributoQueryEntity> articoloVenditaAttributi;

  @Column(name = "tara")
  private Integer tara;

  @Column(name = "maxArt")
  private Integer maxArt;

  @Column(name = "dataOraInizio")
  private LocalDateTime dataOraInizio;

  @Column(name = "dataOraFine")
  private LocalDateTime dataOraFine;

  @Column(name = "oraInizio")
  private String oraInizio;

  @Column(name = "oraFine")
  private String oraFine;

  @Column(name = "aa3")
  private Integer aa3;

  @Column(name = "aa4")
  private Integer aa4;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  @Column(name = "data_cancellazione")
  private LocalDateTime dataCancellazione;

  @Column(name = "version")
  private Long version;

  public ArticoloVenditaQueryEntity() {}

  public ArticoloVenditaQueryEntity(
          String codiceVenditaId, ArticoloVenditaBaseDTO articoloVenditaDTO, Long version) {
    this.id = codiceVenditaId;
    this.codice = articoloVenditaDTO.getCodice();
    this.nome = articoloVenditaDTO.getNome();
    this.descrizione = articoloVenditaDTO.getDescrizione();
    this.costo = articoloVenditaDTO.getCosto();
    this.tara = articoloVenditaDTO.getTara();
    this.maxArt = articoloVenditaDTO.getMaxArt();
    this.oraInizio = articoloVenditaDTO.getOraInizio();
    this.oraFine = articoloVenditaDTO.getOraFine();
    this.dataOraInizio = articoloVenditaDTO.getDataOraInizio();
    this.dataOraFine = articoloVenditaDTO.getDataOraFine();
    this.aa3 = articoloVenditaDTO.getAa3();
    this.aa4 = articoloVenditaDTO.getAa4();
    this.flgCancellato = articoloVenditaDTO.getFlgCancellato();
    this.version = version;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ArticoloQueryEntity getArticolo() {
    return articolo;
  }

  public void setArticolo(ArticoloQueryEntity articolo) {
    this.articolo = articolo;
  }

  public ArticoloVenditaQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(ArticoloVenditaQueryEntity padre) {
    this.padre = padre;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

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

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public ConfigQueryEntity getStato() {
    return stato;
  }

  public void setStato(ConfigQueryEntity stato) {
    this.stato = stato;
  }

  public ConfigQueryEntity getTipoArticoloVendita() {
    return tipoArticoloVendita;
  }

  public void setTipoArticoloVendita(ConfigQueryEntity tipoArticoloVendita) {
    this.tipoArticoloVendita = tipoArticoloVendita;
  }

  public ConfigQueryEntity getSottotipoArticoloVendita() {
    return sottotipoArticoloVendita;
  }

  public void setSottotipoArticoloVendita(ConfigQueryEntity sottotipoArticoloVendita) {
    this.sottotipoArticoloVendita = sottotipoArticoloVendita;
  }

  public RepartoQueryEntity getReparto() {
    return reparto;
  }

  public void setReparto(RepartoQueryEntity reparto) {
    this.reparto = reparto;
  }

  public IvaQueryEntity getIva() {
    return iva;
  }

  public void setIva(IvaQueryEntity iva) {
    this.iva = iva;
  }

  public Double getCosto() {
    return costo;
  }

  public void setCosto(Double costo) {
    this.costo = costo;
  }

  public Set<ArticoloVenditaAttributoQueryEntity> getArticoloVenditaAttributi() {
    return articoloVenditaAttributi;
  }

  public void setArticoloVenditaAttributi(
      Set<ArticoloVenditaAttributoQueryEntity> articoloVenditaAttributo) {
    this.articoloVenditaAttributi = articoloVenditaAttributo;
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
