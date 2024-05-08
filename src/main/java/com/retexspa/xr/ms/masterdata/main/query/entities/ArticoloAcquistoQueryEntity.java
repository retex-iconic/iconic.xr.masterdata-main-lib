package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.IOException;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.articoloAcquisto.ArticoloAcquistoBaseDTO;
import com.retexspa.xr.ms.masterdata.main.core.dto.articoloAcquisto.ArticoloAcquistoIndexDTO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.lang.NonNull;

@ConditionalOnExpression("${iconic.xr.ms.masterdata.query:true} ")
@Entity
@Table(name = "articolo_acquisto")
public class ArticoloAcquistoQueryEntity {

  @Id @NonNull private String id;

  @ManyToOne(
      fetch = FetchType.LAZY,
      targetEntity = FornitoreQueryEntity.class,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JsonIgnore
  private FornitoreQueryEntity fornitore;

  @ManyToOne(
      fetch = FetchType.LAZY,
      targetEntity = ArticoloQueryEntity.class,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JsonIgnore
  private ArticoloQueryEntity articolo;

  @Column(name = "costoCartone")
  private String costoCartone;

  @Column(name = "pezziPerCartone")
  private BigDecimal pezziPerCartone;

  @Column(name = "lottoRiordino")
  private Integer lottoRiordino;

  @Column(name = "codice3")
  private String codice3;

  @Column(name = "note")
  private String note;

  // @ManyToOne(
  //   fetch = FetchType.LAZY,
  //   targetEntity = ArticoloQueryEntity.class,
  //   cascade = {CascadeType.PERSIST})
  @Column(name = "codice")
  private String codice;

  @Column(name = "nome")
  private String nome;

  @Column(name = "pezziCartone")
  private String pezziCartone;

  @Column(name = "descrizione")
  private String descrizione;

  @Column(name = "tipo")
  private String tipo;

  @Column(name = "unitaDiMisura")
  private Integer unitaDiMisura;

  @Column(name = "quantita")
  private String quantita;

  @Column(name = "codiceExt")
  private String codiceExt;

  @ManyToOne(fetch = FetchType.LAZY)
  private ArticoloQueryEntity padre;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  // @Column(name = "articoloFornitoreIds")
  // private List<ArticoloAcquistoQueryEntity> articoloFornitoreIds;

  // constructors
  public ArticoloAcquistoQueryEntity() {}

  public ArticoloAcquistoQueryEntity(
      String articoloFornitoreId, ArticoloAcquistoBaseDTO articoloFornitoreDTO) throws IOException {
    // ObjectMapper objectMapper = new ObjectMapper();
    // ObjectReader objectReader = objectMapper.readerForUpdating(this);
    // String jsonInString = objectMapper.writeValueAsString(articoloFornitoreDTO);
    // Object t = objectReader.readValue(jsonInString, ArticoloAcquistoQueryEntity.class);

    this.id = articoloFornitoreId;
    this.nome = articoloFornitoreDTO.getNome();
    this.codice = articoloFornitoreDTO.getCodice();
    this.descrizione = articoloFornitoreDTO.getDescrizione();
    this.costoCartone = articoloFornitoreDTO.getCostoCartone();
    this.pezziPerCartone = articoloFornitoreDTO.getPezziCartone();
    this.lottoRiordino = articoloFornitoreDTO.getLottoRiordino();
    this.note = articoloFornitoreDTO.getNote();
  }

  public ArticoloAcquistoQueryEntity(
      String articoloFornitoreId, ArticoloAcquistoIndexDTO articoloFornitoreIndexDTO)
      throws IOException {
    // this.articoloFornitoreIds = articoloFornitoreIndexDTO.getArticoloAcquistoIds();
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public FornitoreQueryEntity getFornitore() {
    return this.fornitore;
  }

  public void setFornitore(FornitoreQueryEntity fornitore) {
    this.fornitore = fornitore;
  }

  public ArticoloQueryEntity getArticolo() {
    return this.articolo;
  }

  public void setArticolo(ArticoloQueryEntity articolo) {
    this.articolo = articolo;
  }

  public String getCostoCartone() {
    return this.costoCartone;
  }

  public void setCostoCartone(String costoCartone) {
    this.costoCartone = costoCartone;
  }

  public BigDecimal getPezziPerCartone() {
    return this.pezziPerCartone;
  }

  public void setPezziPerCartone(BigDecimal pezziPerCartone) {
    this.pezziPerCartone = pezziPerCartone;
  }

  public Integer getLottoRiordino() {
    return this.lottoRiordino;
  }

  public void setLottoRiordino(Integer lottoRiordino) {
    this.lottoRiordino = lottoRiordino;
  }

  public String getCodice3() {
    return this.codice3;
  }

  public void setCodice3(String codice3) {
    this.codice3 = codice3;
  }

  public String getNote() {
    return this.note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getCodice() {
    return this.codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public String getPezziCartone() {
    return this.pezziCartone;
  }

  public void setPezziCartone(String pezziCartone) {
    this.pezziCartone = pezziCartone;
  }

  public String getDescrizione() {
    return this.descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
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

  public String getCodiceExt() {
    return this.codiceExt;
  }

  public void setCodiceExt(String codiceExt) {
    this.codiceExt = codiceExt;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return this.gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public ArticoloQueryEntity getPadre() {
    return this.padre;
  }

  public void setPadre(ArticoloQueryEntity padre) {
    this.padre = padre;
  }
}
