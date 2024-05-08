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

import com.retexspa.xr.ms.masterdata.main.core.dto.masterDataConfig.MasterDataConfigBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(
    name = "masterDataConfig",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "masterDataConfig_affiliazioni_uk",
          columnNames = {"context_id", "codice", "nodo_id"})
    },
    indexes = {
      @Index(name = "index_masterDataConfig_affiliazioni_context_id", columnList = "context_id"),
      @Index(name = "index_masterDataConfig_affiliazioni_nodo_id", columnList = "nodo_id")
    })
public class MasterDataConfigQueryEntity {

  @Id @NonNull private String id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "codice")
  private String codice;

  @Column(name = "descrizione")
  private String descrizione;

  @Column(name = "version")
  private Long version;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "masterDataConfig")
  @JsonIgnore
  private Set<MasterDataConfigAttributoQueryEntity> masterDataConfigAttributi;

  @Column(name = "flg_attivo")
  private String flgAttivo;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  @ManyToOne(fetch = FetchType.LAZY)
  private MasterDataConfigQueryEntity nodo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "context_id", referencedColumnName = "id")
  private MasterDataConfigContextQueryEntity context;

  public MasterDataConfigQueryEntity() {}

  public MasterDataConfigQueryEntity(
      @NotNull String masterDataConfigId,
      MasterDataConfigBaseDTO masterDataConfigDTO,
      Long version) {
    this.id = masterDataConfigId;

    this.codice = masterDataConfigDTO.getCodice();
    this.descrizione = masterDataConfigDTO.getDescrizione();
    this.nome = masterDataConfigDTO.getNome();
    this.flgAttivo = masterDataConfigDTO.getFlgAttivo();
    this.flgCancellato = masterDataConfigDTO.getFlgCancellato();
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

  public Set<MasterDataConfigAttributoQueryEntity> getMasterDataConfigAttributi() {
    return masterDataConfigAttributi;
  }

  public void setMasterDataConfigAttributi(
      Set<MasterDataConfigAttributoQueryEntity> masterDataConfigAttributi) {
    this.masterDataConfigAttributi = masterDataConfigAttributi;
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

  public MasterDataConfigQueryEntity getNodoId() {
    return this.nodo;
  }

  public void setNodoId(MasterDataConfigQueryEntity nodo) {
    this.nodo = nodo;
  }

  public MasterDataConfigQueryEntity getNodo() {
    return this.nodo;
  }

  public void setNodo(MasterDataConfigQueryEntity nodo) {
    this.nodo = nodo;
  }

  public MasterDataConfigContextQueryEntity getContext() {
    return this.context;
  }

  public void setContext(MasterDataConfigContextQueryEntity context) {
    this.context = context;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
