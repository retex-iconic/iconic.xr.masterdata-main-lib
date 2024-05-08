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
    name = "tassonomie_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "tassonomie_affiliazioni_uk",
          columnNames = {"negozio_id", "tipo_tassonomia_id", "nodo_id", "codice"})
    },
    indexes = {
      @Index(name = "tassonomie_affiliazioni_codice", columnList = "codice"),
      @Index(name = "tassonomie_affiliazioni_index_negozio_id", columnList = "negozio_id")
    })
public class TassonomiaAffiliazioneQueryEntity {

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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tassonomia_id", referencedColumnName = "id")
  private TassonomiaQueryEntity tassonomia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tipo_tassonomia_id", referencedColumnName = "id")
  private TipoTassonomiaQueryEntity tipoTassonomia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "nodo_id", referencedColumnName = "id")
  private TassonomiaQueryEntity nodo;

  @Column(name = "codice")
  private String codice;

  public TassonomiaAffiliazioneQueryEntity() {}

  public TassonomiaAffiliazioneQueryEntity(
      String id,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio,
      TassonomiaQueryEntity tassonomia,
      TipoTassonomiaQueryEntity tipoTassonomia,
      TassonomiaQueryEntity nodo,
      String codice) {
    this.id = id;
    this.gerarchia = gerarchia;
    this.negozio = negozio;
    this.tassonomia = tassonomia;
    this.tipoTassonomia = tipoTassonomia;
    this.nodo = nodo;
    this.codice = codice;
  }

  public String getId() {
    return id;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public NegozioQueryEntity getNegozio() {
    return negozio;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public void setNegozio(NegozioQueryEntity negozio) {
    this.negozio = negozio;
  }

  public TassonomiaQueryEntity getTassonomia() {
    return tassonomia;
  }

  public void setTassonomia(TassonomiaQueryEntity tassonomia) {
    this.tassonomia = tassonomia;
  }

  public TipoTassonomiaQueryEntity getTipoTassonomia() {
    return tipoTassonomia;
  }

  public void setTipoTassonomia(TipoTassonomiaQueryEntity tipoTassonomia) {
    this.tipoTassonomia = tipoTassonomia;
  }

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public TassonomiaQueryEntity getNodo() {
    return nodo;
  }

  public void setNodo(TassonomiaQueryEntity nodo) {
    this.nodo = nodo;
  }
}
