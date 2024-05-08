package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.pagamento.TipoPagamentoBaseDTO;
import lombok.NonNull;

@Entity
@Table(name = "tipo_pagamento")
public class TipoPagamentoQueryEntity {
  @Id @NonNull private String id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "descrizione")
  private String descrizione;

  @Column(name = "codice")
  private String codice;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  private TipoPagamentoQueryEntity padre;

  @Column(name = "indicatoreFts")
  private String indicatoreFts;

  @Column(name = "version")
  private Long version;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoPagamento")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<FormaPagamentoQueryEntity> formaPagamento;

  public TipoPagamentoQueryEntity() {}

  public TipoPagamentoQueryEntity(
          @NonNull String tipoPagamentoId, TipoPagamentoBaseDTO tipoPagamentoDTO, Long version) {
    this.id = tipoPagamentoId;
    this.nome = tipoPagamentoDTO.getNome();
    this.descrizione = tipoPagamentoDTO.getDescrizione();
    this.codice = tipoPagamentoDTO.getCodice();
    this.indicatoreFts = tipoPagamentoDTO.getIndicatoreFts();
    this.version = version;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public String getIndicatoreFts() {
    return indicatoreFts;
  }

  public void setIndicatoreFts(String indicatoreFts) {
    this.indicatoreFts = indicatoreFts;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public TipoPagamentoQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(TipoPagamentoQueryEntity padre) {
    this.padre = padre;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
