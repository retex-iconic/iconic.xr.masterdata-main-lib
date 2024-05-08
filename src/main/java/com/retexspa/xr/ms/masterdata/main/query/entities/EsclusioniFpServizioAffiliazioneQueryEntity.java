package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.util.UUID;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import lombok.NonNull;

@Entity
@Table(
    name = "esclusioni_fp_servizio_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "esclusioni_fp_servizio_affiliazioni_uk",
          columnNames = {"negozio_id", "anagrafica_servizio_id", "forma_pagamento_id"})
    },
    indexes = {
      @Index(
          name = "index_esclusioni_fp_servizio_affiliazioni_escl_fp_servizio_id",
          columnList = "esclusioni_fp_servizio_id"),
      @Index(
          name = "index_esclusioni_fp_servizio_affiliazioni_anag_servizio_id",
          columnList = "anagrafica_servizio_id"),
      @Index(
          name = "index_esclusioni_fp_servizio_affiliazioni_negozio_id",
          columnList = "negozio_id"),
      @Index(
          name = "index_esclusioni_fp_servizio_affiliazioni_forma_pagamento_id",
          columnList = "forma_pagamento_id")
    })
public class EsclusioniFpServizioAffiliazioneQueryEntity {

  @Id @NonNull private String id;

  @PrePersist
  public void generateId() {
    if (id == null) {
      id = UUID.randomUUID().toString();
    }
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "esclusioni_fp_servizio_id", referencedColumnName = "id")
  private EsclusioniFpServizioQueryEntity esclusioniFpServizio;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "anagrafica_servizio_id", referencedColumnName = "id")
  private AnagraficaServizioQueryEntity anagraficaServizio;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id")
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "negozio_id", referencedColumnName = "id")
  private NegozioQueryEntity negozio;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "forma_pagamento_id", referencedColumnName = "id")
  private FormaPagamentoQueryEntity formaPagamento;

  public EsclusioniFpServizioAffiliazioneQueryEntity() {}

  public EsclusioniFpServizioAffiliazioneQueryEntity(
      String id,
      EsclusioniFpServizioQueryEntity esclusioniFpServizio,
      FormaPagamentoQueryEntity formaPagamento,
      AnagraficaServizioQueryEntity anagraficaServizio,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio) {
    this.id = id;
    this.esclusioniFpServizio = esclusioniFpServizio;
    this.formaPagamento = formaPagamento;
    this.gerarchia = gerarchia;
    this.negozio = negozio;
    this.anagraficaServizio = anagraficaServizio;
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

  public EsclusioniFpServizioQueryEntity getEsclusioniFpServizio() {
    return esclusioniFpServizio;
  }

  public void setEsclusioniFpServizio(EsclusioniFpServizioQueryEntity esclusioniFpServizio) {
    this.esclusioniFpServizio = esclusioniFpServizio;
  }

  public AnagraficaServizioQueryEntity getAnagraficaServizio() {
    return anagraficaServizio;
  }

  public void setAnagraficaServizio(AnagraficaServizioQueryEntity anagraficaServizio) {
    this.anagraficaServizio = anagraficaServizio;
  }

  public FormaPagamentoQueryEntity getFormaPagamento() {
    return formaPagamento;
  }

  public void setFormaPagamento(FormaPagamentoQueryEntity formaPagamento) {
    this.formaPagamento = formaPagamento;
  }
}
