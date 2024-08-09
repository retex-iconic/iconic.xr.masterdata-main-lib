package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.IOException;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.articolo.ArticoloTassonomiaBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "articoli_tassonomie", uniqueConstraints = {
        @UniqueConstraint(name = "articoli_tassonomie_uk", columnNames = { "articolo_id","tassonomia_id","gerarchia_id" })})
public class ArticoloTassonomiaQueryEntity {

  @Id @NonNull private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_articoli_tassonomie_gerarchia"))
  private GerarchiaQueryEntity gerarchia;

  /*@ManyToOne(
      fetch = FetchType.LAZY,
      targetEntity = ArticoloQueryEntity.class,
      cascade = {CascadeType.PERSIST})*/
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "articolo_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_articoli_tassonomie_articolo"))
  @JsonIgnore
  private ArticoloQueryEntity articolo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tassonomia_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_articoli_tassonomie_tassonomia"))
  private TassonomiaQueryEntity tassonomia;

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
}
