package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.retexspa.xr.ms.main.core.dto.config.ConfigBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(
    name = "config",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "config_affiliazioni_uk",
          columnNames = {"context_id", "codice", "nodo_id"})
    },
    indexes = {
      @Index(name = "index_config_affiliazioni_context_id", columnList = "context_id"),
      @Index(name = "index_config_affiliazioni_nodo_id", columnList = "nodo_id")
    })
public class ConfigQueryEntity {

  @Id @NonNull private String id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "codice")
  private String codice;

  @Column(name = "descrizione")
  private String descrizione;

  @Column(name = "version")
  private Long version;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "config")
  @JsonIgnore
  private Set<ConfigAttributoQueryEntity> configAttributi;

  @Column(name = "flg_attivo")
  private String flgAttivo;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  @ManyToOne(fetch = FetchType.LAZY)
  private ConfigQueryEntity nodo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "context_id", referencedColumnName = "id")
  private ConfigContextQueryEntity context;

  public ConfigQueryEntity() {}

  public ConfigQueryEntity(
      @NotNull String configId,
      ConfigBaseDTO configDTO,
      Long version) {
    this.id = configId;

    this.codice = configDTO.getCodice();
    this.descrizione = configDTO.getDescrizione();
    this.nome = configDTO.getNome();
    this.flgAttivo = configDTO.getFlgAttivo();
    this.flgCancellato = configDTO.getFlgCancellato();
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
    return this.descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public Set<ConfigAttributoQueryEntity> getConfigAttributi() {
    return configAttributi;
  }

  public void setConfigAttributi(
      Set<ConfigAttributoQueryEntity> configAttributi) {
    this.configAttributi = configAttributi;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }

  public String getFlgAttivo() {
    return this.flgAttivo;
  }

  public void setFlgAttivo(String flgAttivo) {
    this.flgAttivo = flgAttivo;
  }

  public ConfigQueryEntity getNodoId() {
    return this.nodo;
  }

  public void setNodoId(ConfigQueryEntity nodo) {
    this.nodo = nodo;
  }

  public ConfigQueryEntity getNodo() {
    return this.nodo;
  }

  public void setNodo(ConfigQueryEntity nodo) {
    this.nodo = nodo;
  }

  public ConfigContextQueryEntity getContext() {
    return this.context;
  }

  public void setContext(ConfigContextQueryEntity context) {
    this.context = context;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
