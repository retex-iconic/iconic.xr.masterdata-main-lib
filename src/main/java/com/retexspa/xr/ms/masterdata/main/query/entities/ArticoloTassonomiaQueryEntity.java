package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.IOException;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.articolo.ArticoloTassonomiaBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "articoli_tassonomie")
public class ArticoloTassonomiaQueryEntity {

  @Id @NonNull private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  /*@ManyToOne(
      fetch = FetchType.LAZY,
      targetEntity = ArticoloQueryEntity.class,
      cascade = {CascadeType.PERSIST})*/
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "articolo_id")
  @JsonIgnore
  private ArticoloQueryEntity articolo;

  @ManyToOne(fetch = FetchType.LAZY)
  private TassonomiaQueryEntity tassonomia;

  @ManyToOne(fetch = FetchType.LAZY)
  private ArticoloTassonomiaQueryEntity padre;

  public ArticoloTassonomiaQueryEntity() {}

  public ArticoloTassonomiaQueryEntity(
      @NotNull String articoloTassonomiaId, ArticoloTassonomiaBaseDTO articoloTassonomiaDTO)
      throws IOException {
    this.id = articoloTassonomiaId;
  }

  // getters and setters
  public String getId() {
    return this.id;
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

  public TassonomiaQueryEntity getTassonomia() {
    return tassonomia;
  }

  public void setTassonomia(TassonomiaQueryEntity tassonomia) {
    this.tassonomia = tassonomia;
  }

  public ArticoloTassonomiaQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(ArticoloTassonomiaQueryEntity padre) {
    this.padre = padre;
  }
}
