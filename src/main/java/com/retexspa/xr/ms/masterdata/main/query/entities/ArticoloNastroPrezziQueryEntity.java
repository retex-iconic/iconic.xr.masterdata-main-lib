package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.articolo.ArticoloNastroPrezziBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "articoli_nastro_prezzi")
public class ArticoloNastroPrezziQueryEntity implements Serializable {

  @Id @NonNull private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  private ArticoloQueryEntity articolo;

  @ManyToOne(fetch = FetchType.LAZY)
  private ArticoloNastroPrezziQueryEntity padre;

  @Column(name = "prezzoVendita")
  private Double prezzoVendita;

  @Column(name = "dataOraInizio")
  private LocalDateTime dataOraInizio;

  @Column(name = "dataOraFine")
  private LocalDateTime dataOraFine;

  @Column(name = "codice")
  private String codice; // codice del'articolo associato

  @Column(name = "version")
  private Long version; // codice del'articolo associato

  public ArticoloNastroPrezziQueryEntity() {}

  public ArticoloNastroPrezziQueryEntity(
      String articoloNastroPrezziId,
      ArticoloNastroPrezziBaseDTO articoloNastroPrezziDTO,
      Long version) {
    this.id = articoloNastroPrezziId;
    this.prezzoVendita = articoloNastroPrezziDTO.getPrezzoVendita();
    this.dataOraInizio = articoloNastroPrezziDTO.getDataOraInizio();
    this.dataOraFine = articoloNastroPrezziDTO.getDataOraFine();
    this.codice = articoloNastroPrezziDTO.getCodice();
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

  public Double getPrezzoVendita() {
    return prezzoVendita;
  }

  public void setPrezzoVendita(Double prezzoVendita) {
    this.prezzoVendita = prezzoVendita;
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

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public ArticoloNastroPrezziQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(ArticoloNastroPrezziQueryEntity padre) {
    this.padre = padre;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
