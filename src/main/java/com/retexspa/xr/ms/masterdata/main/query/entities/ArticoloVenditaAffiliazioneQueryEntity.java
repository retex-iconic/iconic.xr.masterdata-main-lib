package com.retexspa.xr.ms.masterdata.main.query.entities;

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
    name = "articolo_vendita_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "articolo_vendita_affiliazioni_uk",
          columnNames = {"negozio_id", "articolo_id"})
    },
    indexes = {
      @Index(name = "index_articolo_vendita_affiliazioni_articolo_id", columnList = "articolo_id"),
      @Index(name = "index_articolo_vendita_affiliazioni_negozio_id", columnList = "negozio_id")
    })
public class ArticoloVenditaAffiliazioneQueryEntity {

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
  @JoinColumn(name = "articolo_vendita_id", referencedColumnName = "id")
  private ArticoloVenditaQueryEntity articoloVendita;

  // UK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "articolo_id", referencedColumnName = "id")
  private ArticoloQueryEntity articolo;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  public ArticoloVenditaAffiliazioneQueryEntity() {}

  public ArticoloVenditaAffiliazioneQueryEntity(
      String id,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio,
      ArticoloVenditaQueryEntity articoloVendita,
      ArticoloQueryEntity articolo,
      String flgCancellato) {
    this.id = id;
    this.gerarchia = gerarchia;
    this.negozio = negozio;
    this.articoloVendita = articoloVendita;
    this.articolo = articolo;
    this.flgCancellato = flgCancellato;
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

  public ArticoloQueryEntity getArticolo() {
    return articolo;
  }

  public void setArticolo(ArticoloQueryEntity articolo) {
    this.articolo = articolo;
  }

  public ArticoloVenditaQueryEntity getArticoloVendita() {
    return articoloVendita;
  }

  public void setArticoloVendita(ArticoloVenditaQueryEntity articoloVendita) {
    this.articoloVendita = articoloVendita;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }
}
