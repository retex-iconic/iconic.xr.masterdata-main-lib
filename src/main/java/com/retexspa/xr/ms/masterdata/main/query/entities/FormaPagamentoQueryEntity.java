package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.pagamento.FormaPagamentoBaseDTO;
import lombok.NonNull;

@Entity
@Table(name = "forma_pagamento")
public class FormaPagamentoQueryEntity {
  @Id @NonNull private String id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "descrizione")
  private String descrizione;

  @Column(name = "codice")
  private String codice;

  @Column(name = "flgAttivo")
  private String flgAttivo;

  @Column(name = "version")
  private Long version;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tipoPagamento_id", referencedColumnName = "id")
  private TipoPagamentoQueryEntity tipoPagamento;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  private FormaPagamentoQueryEntity padre;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "formaPagamento")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<FormaPagamentoCassaQueryEntity> formaPagamentoCassa;

  public FormaPagamentoQueryEntity() {}

  public FormaPagamentoQueryEntity(
          @NonNull String formaPagamentoId, FormaPagamentoBaseDTO formaPagamentoDTO, Long version) {
    this.id = formaPagamentoId;
    this.nome = formaPagamentoDTO.getNome();
    this.descrizione = formaPagamentoDTO.getDescrizione();
    this.codice = formaPagamentoDTO.getCodice();
    this.flgAttivo = formaPagamentoDTO.getFlgAttivo();
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

  public String getFlgAttivo() {
    return flgAttivo;
  }

  public void setFlgAttivo(String flgAttivo) {
    this.flgAttivo = flgAttivo;
  }

  public TipoPagamentoQueryEntity getTipoPagamento() {
    return tipoPagamento;
  }

  public void setTipoPagamento(TipoPagamentoQueryEntity tipoPagamento) {
    this.tipoPagamento = tipoPagamento;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public FormaPagamentoQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(FormaPagamentoQueryEntity padre) {
    this.padre = padre;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
