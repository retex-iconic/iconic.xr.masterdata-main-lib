package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import org.springframework.lang.NonNull;

@Entity
@Table(
    name = "articolo_nastro_prezzi_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "articolo_nastro_prezzi_affiliazioni_uk",
          columnNames = {"negozio_id", "articolo_id", "data_ora_inizio"})
    },
    indexes = {
      @Index(
          name = "index_articolo_nastro_prezzi_affiliazioni_articolo_id",
          columnList = "articolo_id"),
      @Index(
          name = "index_articolo_nastro_prezzi_affiliazioni_data_ora_inizio",
          columnList = "data_ora_inizio"),
      @Index(
          name = "index_articolo_nastro_prezzi_affiliazioni_negozio_id",
          columnList = "negozio_id")
    })
public class ArticoloNastroPrezziAffiliazioneQueryEntity {

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

  // aggregato_id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "nastro_prezzi", referencedColumnName = "id")
  @JsonIgnore
  private ArticoloNastroPrezziQueryEntity nastroPrezzi;

  // UK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "articolo_id", referencedColumnName = "id")
  @JsonIgnore
  private ArticoloQueryEntity articolo;

  @Column(name = "data_ora_inizio")
  private LocalDateTime dataOraInizio;

  public ArticoloNastroPrezziAffiliazioneQueryEntity() {}

  public ArticoloNastroPrezziAffiliazioneQueryEntity(
      String id,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio,
      ArticoloNastroPrezziQueryEntity nastroPrezzi,
      ArticoloQueryEntity articolo,
      LocalDateTime dataOraInizio) {
    this.id = id;
    this.gerarchia = gerarchia;
    this.negozio = negozio;
    this.nastroPrezzi = nastroPrezzi;
    this.articolo = articolo;
    this.dataOraInizio = dataOraInizio;
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

  public NegozioQueryEntity getNegozio() {
    return negozio;
  }

  public void setNegozio(NegozioQueryEntity negozio) {
    this.negozio = negozio;
  }

  public ArticoloNastroPrezziQueryEntity getNastroPrezzi() {
    return nastroPrezzi;
  }

  public void setNastroPrezzi(ArticoloNastroPrezziQueryEntity nastroPrezzi) {
    this.nastroPrezzi = nastroPrezzi;
  }

  public ArticoloQueryEntity getArticolo() {
    return articolo;
  }

  public void setArticolo(ArticoloQueryEntity articolo) {
    this.articolo = articolo;
  }

  public LocalDateTime getDataOraInizio() {
    return dataOraInizio;
  }

  public void setDataOraInizio(LocalDateTime dataOraInizio) {
    this.dataOraInizio = dataOraInizio;
  }
}
