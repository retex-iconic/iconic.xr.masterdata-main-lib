package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.tassonomia.TipoTassonomiaBaseDTO;

import java.io.IOException;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tipo_tassonomie")
public class TipoTassonomiaQueryEntity {

  @Id private String id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "codice")
  private String codice;

  @Column(name = "descrizione")
  private String descrizione;

  // @Column(name = "livello")
  // private Integer livello;

  @Column(name = "gruppo_tassonomia")
  private String gruppoTassonomia;

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

  public TipoTassonomiaQueryEntity() {}

  public TipoTassonomiaQueryEntity(
          @NotNull String tipoTassonomiaId, TipoTassonomiaBaseDTO tipoTassonomiaDTO, Long version)
      throws IOException {
    this.id = tipoTassonomiaId;
    this.nome = tipoTassonomiaDTO.getNome();
    this.codice = tipoTassonomiaDTO.getCodice();
    this.descrizione = tipoTassonomiaDTO.getDescrizione();
    // this.livello = tipoTassonomiaDTO.getLivello();
    this.gruppoTassonomia = tipoTassonomiaDTO.getGruppoTassonomia();
    this.flgNonCancellabile = tipoTassonomiaDTO.getFlgNonCancellabile();
    this.version = version;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCodice() {
    return this.codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  // public Integer getLivello() {
  //   return livello;
  // }

  // public void setLivello(Integer livello) {
  //   this.livello = livello;
  // }

  public String getGruppoTassonomia() {
    return gruppoTassonomia;
  }

  public void setGruppoTassonomia(String gruppoTassonomia) {
    this.gruppoTassonomia = gruppoTassonomia;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public TipoTassonomiaQueryEntity getNodo() {
    return nodo;
  }

  public void setNodo(TipoTassonomiaQueryEntity nodo) {
    this.nodo = nodo;
  }

  public Set<TipoTassonomiaQueryEntity> getFigli() {
    return figli;
  }

  public void setFigli(Set<TipoTassonomiaQueryEntity> figli) {
    this.figli = figli;
  }

  public Set<TassonomiaQueryEntity> getTassonomie() {
    return tassonomie;
  }

  public void setTassonomie(Set<TassonomiaQueryEntity> tassonomie) {
    this.tassonomie = tassonomie;
  }

  public TipoTassonomiaQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(TipoTassonomiaQueryEntity padre) {
    this.padre = padre;
  }

  public String getFlgNonCancellabile() {
    return this.flgNonCancellabile;
  }

  public void setFlgNonCancellabile(String flgNonCancellabile) {
    this.flgNonCancellabile = flgNonCancellabile;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
