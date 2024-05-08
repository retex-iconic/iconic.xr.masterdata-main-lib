package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import org.springframework.lang.NonNull;

@Entity
@Table(
    name = "articolo_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "articolo_affiliazioni_uk",
          columnNames = {"negozio_id", "codice"})
    },
    indexes = {
      @Index(name = "index_articolo_affiliazioni_articolo_id", columnList = "articolo_id"),
      @Index(name = "index_articolo_affiliazioni_codice", columnList = "codice"),
      @Index(name = "index_articolo_affiliazioni_negozio_id", columnList = "negozio_id")
    })
public class ArticoloAffiliazioneQueryEntity implements Serializable {

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
  @JoinColumn(name = "articolo_id", referencedColumnName = "id")
  private ArticoloQueryEntity articolo;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  // UK
  @Column(name = "codice")
  private String codice;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumns({
    @JoinColumn(name = "articolo_id", referencedColumnName = "articolo_id"),
    @JoinColumn(name = "negozio_id", referencedColumnName = "negozio_id")
  })
  private List<ArticoloTassonomiaAffiliazioneQueryEntity> articoloTassonomiaAffiliazione;

  public ArticoloAffiliazioneQueryEntity() {}

  public ArticoloAffiliazioneQueryEntity(
      String id,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio,
      ArticoloQueryEntity articolo,
      String codice,
      String flgCancellato) {
    this.id = id;
    this.articolo = articolo;
    this.codice = codice;
    this.gerarchia = gerarchia;
    this.negozio = negozio;
    this.flgCancellato = flgCancellato;
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

  public ArticoloQueryEntity getArticolo() {
    return articolo;
  }

  public void setArticolo(ArticoloQueryEntity articolo) {
    this.articolo = articolo;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }

  public List<ArticoloTassonomiaAffiliazioneQueryEntity> getArticoloTassonomiaAffiliazione() {
    return articoloTassonomiaAffiliazione;
  }

  public void setArticoloTassonomiaAffiliazione(
      List<ArticoloTassonomiaAffiliazioneQueryEntity> articoloTassonomiaAffiliazione) {
    this.articoloTassonomiaAffiliazione = articoloTassonomiaAffiliazione;
  }
}
