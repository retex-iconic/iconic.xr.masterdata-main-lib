package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.io.Serializable;
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

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import org.springframework.lang.NonNull;

@Entity
@Table(
    name = "articolo_info_servizio_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "articolo_info_servizio_affiliazioni_uk",
          columnNames = {"negozio_id", "articolo_id"})
    },
    indexes = {
      @Index(
          name = "index_art_info_serv_aff_art_info_serv_id",
          columnList = "anagrafica_servizio_id"),
      @Index(name = "index_art_info_serv_aff_articolo_id", columnList = "articolo_id"),
      @Index(name = "index_art_info_serv_aff_negozio_id", columnList = "negozio_id")
    })
public class ArticoloInfoServizioAffiliazioneQueryEntity implements Serializable {

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
  //

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "anagrafica_servizio_id", referencedColumnName = "id")
  private AnagraficaServizioQueryEntity anagraficaServizio;

  public ArticoloInfoServizioAffiliazioneQueryEntity() {}

  public ArticoloInfoServizioAffiliazioneQueryEntity(
      String id,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio,
      AnagraficaServizioQueryEntity anagraficaServizio,
      ArticoloQueryEntity articolo) {
    this.id = id;
    this.gerarchia = gerarchia;
    this.negozio = negozio;
    this.anagraficaServizio = anagraficaServizio;
    this.articolo = articolo;
  }

  public String getId() {
    return id;
  }

  public AnagraficaServizioQueryEntity getAnagraficaServizio() {
    return anagraficaServizio;
  }

  public void setAnagraficaServizio(AnagraficaServizioQueryEntity anagraficaServizio) {
    this.anagraficaServizio = anagraficaServizio;
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
}
