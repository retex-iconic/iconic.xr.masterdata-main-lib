package com.retexspa.xr.ms.masterdata.main.query.entities;


import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.articolo.ArticoloEanBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "articoli_ean")
public class ArticoloEanQueryEntity implements Serializable {

  @Id @NonNull private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  private ArticoloQueryEntity articolo;

  @Column(name = "codice")
  private String codice;

  @Column(name = "descrizione")
  private String descrizione;

  @ManyToOne(fetch = FetchType.LAZY)
  private MasterDataConfigQueryEntity codiceMoltiplicatore;

  @Column(name = "moltiplicatore")
  private Integer moltiplicatore;

  @Column(name = "codiceVenditaLocale")
  private String codiceVenditaLocale;

  @Column(name = "descrizioneCodiceVendita")
  private String descrizioneCodiceVendita;

  @Column(name = "quantitaCodiceVendita")
  private Double quantitaCodiceVendita;

  @Column(name = "scontoCodiceVendita")
  private Double scontoCodiceVendita;

  @Column(name = "prezzoCodiceVendita")
  private Double prezzoCodiceVendita;

  @ManyToOne(fetch = FetchType.LAZY)
  private MasterDataConfigQueryEntity stato;

  @ManyToOne(fetch = FetchType.LAZY)
  private MasterDataConfigQueryEntity tipoEan;

  @ManyToOne(fetch = FetchType.LAZY)
  private ArticoloEanQueryEntity padre;

  // @Type(type = "json")
  private String anagBil;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  @Column(name = "data_cancellazione")
  private LocalDateTime dataCancellazione;

  @Column(name = "version")
  private Long version;

  public ArticoloEanQueryEntity() {}

  public ArticoloEanQueryEntity(
          String articoloEanId, ArticoloEanBaseDTO articoloEanDTO, Long version) {
    this.id = articoloEanId;
    this.codice = articoloEanDTO.getCodice();
    this.descrizione = articoloEanDTO.getDescrizione();
    this.moltiplicatore = articoloEanDTO.getMoltiplicatore();
    this.codiceVenditaLocale = articoloEanDTO.getCodiceVenditaLocale();
    this.descrizioneCodiceVendita = articoloEanDTO.getDescrizione();
    this.quantitaCodiceVendita = articoloEanDTO.getQuantitaCodiceVendita();
    this.scontoCodiceVendita = articoloEanDTO.getPrezzoCodiceVendita();
    this.prezzoCodiceVendita = articoloEanDTO.getPrezzoCodiceVendita();
    this.anagBil = articoloEanDTO.getAnagBil();
    this.flgCancellato = articoloEanDTO.getFlgCancellato();
    this.version = version;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public ArticoloQueryEntity getArticolo() {
    return articolo;
  }

  public void setArticolo(ArticoloQueryEntity articolo) {
    this.articolo = articolo;
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

  public Double getPrezzoCodiceVendita() {
    return prezzoCodiceVendita;
  }

  public void setPrezzoCodiceVendita(Double prezzoCodiceVendita) {
    this.prezzoCodiceVendita = prezzoCodiceVendita;
  }

  public MasterDataConfigQueryEntity getCodiceMoltiplicatore() {
    return codiceMoltiplicatore;
  }

  public void setCodiceMoltiplicatore(MasterDataConfigQueryEntity codiceMoltiplicatore) {
    this.codiceMoltiplicatore = codiceMoltiplicatore;
  }

  public MasterDataConfigQueryEntity getStato() {
    return stato;
  }

  public void setStato(MasterDataConfigQueryEntity stato) {
    this.stato = stato;
  }

  public MasterDataConfigQueryEntity getTipoEan() {
    return tipoEan;
  }

  public void setTipoEan(MasterDataConfigQueryEntity tipoEan) {
    this.tipoEan = tipoEan;
  }

  public String getAnagBil() {
    return anagBil;
  }

  public void setAnagBil(String anagBil) {
    this.anagBil = anagBil;
  }

  public ArticoloEanQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(ArticoloEanQueryEntity padre) {
    this.padre = padre;
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
