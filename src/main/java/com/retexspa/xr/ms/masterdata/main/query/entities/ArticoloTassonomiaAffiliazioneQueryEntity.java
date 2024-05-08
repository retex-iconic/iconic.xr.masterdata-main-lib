package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.io.IOException;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.articolo.ArticoloTassonomiaBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(
    name = "articoli_tassonomie_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "articolo_tassonomia_affiliazioni_uk",
          columnNames = {"negozio_id", "tassonomia_id", "articolo_id"})
    },
    indexes = {
      @Index(
          name = "index_articolo_tassonomia_affiliazioni_articolo_id",
          columnList = "articolo_id"),
      @Index(
          name = "index_articolo_tassonomia_affiliazioni_tassonomia_id",
          columnList = "tassonomia_id"),
      @Index(name = "index_articolo_tassonomia_affiliazioni_negozio_id", columnList = "negozio_id")
    })
public class ArticoloTassonomiaAffiliazioneQueryEntity {

  @Id @NonNull private String id;

  @PrePersist
  public void generateId() {
    if (id == null) {
      id = UUID.randomUUID().toString();
    }
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id")
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "negozio_id", referencedColumnName = "id")
  private NegozioQueryEntity negozio;

  // UK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "articolo_id", referencedColumnName = "id")
  private ArticoloQueryEntity articolo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tassonomia_id", referencedColumnName = "id")
  private TassonomiaQueryEntity tassonomia;

  public ArticoloTassonomiaAffiliazioneQueryEntity() {}

  public ArticoloTassonomiaAffiliazioneQueryEntity(
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

  public NegozioQueryEntity getNegozio() {
    return negozio;
  }

  public void setNegozio(NegozioQueryEntity negozio) {
    this.negozio = negozio;
  }
}
