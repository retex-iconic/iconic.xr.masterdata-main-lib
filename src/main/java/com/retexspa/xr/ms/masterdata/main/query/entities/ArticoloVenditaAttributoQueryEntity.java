package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

@Entity
@Table(
    name = "articoli_vendita_attributi",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "articoli_vendita_attributi_uk",
          columnNames = {"articolo_vendita_id", "attributo_id"})
    })
public class ArticoloVenditaAttributoQueryEntity {

  @Id @NonNull private String id;

  @ManyToOne(
      fetch = FetchType.LAZY,
      targetEntity = ArticoloVenditaQueryEntity.class,
      cascade = {CascadeType.PERSIST})
  @JsonIgnore
  private ArticoloVenditaQueryEntity articoloVendita;

  @ManyToOne(fetch = FetchType.LAZY)
  private AttributoQueryEntity attributo;

  @Column(name = "valore")
  private String valore;

  public ArticoloVenditaAttributoQueryEntity() {}

  public ArticoloVenditaAttributoQueryEntity(
      @NotNull String id,
      ArticoloVenditaQueryEntity articoloVendita,
      AttributoQueryEntity attributo,
      String valore) {
    this.id = id;
    this.articoloVendita = articoloVendita;
    this.attributo = attributo;
    this.valore = valore;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ArticoloVenditaQueryEntity getArticoloVendita() {
    return articoloVendita;
  }

  public void setArticoloVendita(ArticoloVenditaQueryEntity articoloVendita) {
    this.articoloVendita = articoloVendita;
  }

  public AttributoQueryEntity getAttributo() {
    return attributo;
  }

  public void setAttributo(AttributoQueryEntity attributo) {
    this.attributo = attributo;
  }

  public String getValore() {
    return valore;
  }

  public void setValore(String valore) {
    this.valore = valore;
  }
}
