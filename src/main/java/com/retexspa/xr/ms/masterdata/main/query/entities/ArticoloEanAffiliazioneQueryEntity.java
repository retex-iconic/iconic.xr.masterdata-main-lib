package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    name = "articolo_ean_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "articolo_ean_affiliazioni_uk",
          columnNames = {"negozio_id", "codice"})
    },
    indexes = {
      /*@Index(name = "index_articolo_ean_affiliazioni_articolo_id", columnList = "articolo_id"),*/
      @Index(name = "index_articolo_ean_affiliazioni_codice", columnList = "codice"),
      @Index(name = "index_articolo_ean_affiliazioni_negozio_id", columnList = "negozio_id")
    })
public class ArticoloEanAffiliazioneQueryEntity {

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
  @JoinColumn(name = "ean", referencedColumnName = "id")
  @JsonIgnore
  private ArticoloEanQueryEntity ean;

  /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "articolo_id", referencedColumnName = "id")
    @JsonIgnore
    private ArticoloQueryEntity articolo;
  */

  // UK
  @Column(name = "codice")
  private String codice;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  public ArticoloEanAffiliazioneQueryEntity() {}

  public ArticoloEanAffiliazioneQueryEntity(
      String id,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio,
      // ArticoloQueryEntity articolo,
      ArticoloEanQueryEntity ean,
      String codice,
      String flgCancellato) {
    this.id = id;
    this.ean = ean;
    this.codice = codice;
    this.gerarchia = gerarchia;
    this.negozio = negozio;
    this.flgCancellato = flgCancellato;
    // this.articolo = articolo;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCodice() {
    return codice;
  }

  public void setCodice(String atecoNr) {
    this.codice = atecoNr;
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

  public ArticoloEanQueryEntity getArticoloEan() {
    return ean;
  }

  public void setArticoloEan(ArticoloEanQueryEntity ean) {
    this.ean = ean;
  }

  /*  public ArticoloQueryEntity getArticolo() {
    return articolo;
  }

  public void setArticolo(ArticoloQueryEntity articolo) {
    this.articolo = articolo;
  }*/

  public ArticoloEanQueryEntity getEan() {
    return ean;
  }

  public void setEan(ArticoloEanQueryEntity ean) {
    this.ean = ean;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }
}
