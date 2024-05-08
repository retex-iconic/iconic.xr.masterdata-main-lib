package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.tassonomia.TipoTassonomiaUpdateFlgNonCancellabileDTO;

import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tipo_tassonomie")
public class TipoTassonomiaUpdateFlgNonCancellabileQueryEntity {

  @Id private String id;

  @Column(name = "flg_non_cancellabile")
  private String flgNonCancellabile;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "nodo")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<TipoTassonomiaQueryEntity> figli;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  private TipoTassonomiaQueryEntity nodo;

  @ManyToOne(fetch = FetchType.LAZY)
  private TipoTassonomiaQueryEntity padre;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoTassonomia")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<TassonomiaQueryEntity> tassonomie;

  @Column(name = "version")
  private Long version;

  public TipoTassonomiaUpdateFlgNonCancellabileQueryEntity() {}

  public TipoTassonomiaUpdateFlgNonCancellabileQueryEntity(
      @NotNull String tipoTassonomiaId,
      String flgNonCancellabile,
      TipoTassonomiaUpdateFlgNonCancellabileDTO tipoTassonomiaUpdateFlgNonCancellabileDTO,
      Long version) {
    this.id = tipoTassonomiaId;
    this.flgNonCancellabile = flgNonCancellabile;
    this.version = version;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFlgNonCancellabile() {
    return this.flgNonCancellabile;
  }

  public void setFlgNonCancellabile(String flgNonCancellabile) {
    this.flgNonCancellabile = flgNonCancellabile;
  }

  public Set<TipoTassonomiaQueryEntity> getFigli() {
    return this.figli;
  }

  public void setFigli(Set<TipoTassonomiaQueryEntity> figli) {
    this.figli = figli;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return this.gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public TipoTassonomiaQueryEntity getNodo() {
    return this.nodo;
  }

  public void setNodo(TipoTassonomiaQueryEntity nodo) {
    this.nodo = nodo;
  }

  public TipoTassonomiaQueryEntity getPadre() {
    return this.padre;
  }

  public void setPadre(TipoTassonomiaQueryEntity padre) {
    this.padre = padre;
  }

  public Set<TassonomiaQueryEntity> getTassonomie() {
    return this.tassonomie;
  }

  public void setTassonomie(Set<TassonomiaQueryEntity> tassonomie) {
    this.tassonomie = tassonomie;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
