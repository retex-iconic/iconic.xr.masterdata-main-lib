package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.util.UUID;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import org.springframework.lang.NonNull;

@Entity
@Table(
    name = "tipo_pagamento_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "tipo_pagamento_affiliazioni_uk",
          columnNames = {"negozio_id", "codice"})
    },
    indexes = {
      @Index(
          name = "index_tipo_pagamento_affiliazioni_tipo_pagamento_id",
          columnList = "tipo_pagamento_id"),
      @Index(name = "index_tipo_pagamento_affiliazioni_codice", columnList = "codice"),
      @Index(name = "index_tipo_pagamento_affiliazioni_negozio_id", columnList = "negozio_id")
    })
public class TipoPagamentoAffiliazioneQueryEntity {
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
  @JoinColumn(name = "tipo_pagamento_id", referencedColumnName = "id")
  private TipoPagamentoQueryEntity tipoPagamento;

  // UK
  @Column(name = "codice")
  private String codice;

  public TipoPagamentoAffiliazioneQueryEntity() {}

  public TipoPagamentoAffiliazioneQueryEntity(
      String id,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio,
      TipoPagamentoQueryEntity tipoPagamento,
      String codice) {
    this.id = id;
    this.tipoPagamento = tipoPagamento;
    this.codice = codice;
    this.gerarchia = gerarchia;
    this.negozio = negozio;
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

  public void setCodice(String codice) {
    this.codice = codice;
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

  public TipoPagamentoQueryEntity getTipoPagamento() {
    return tipoPagamento;
  }

  public void setTipoPagamento(TipoPagamentoQueryEntity tipoPagamento) {
    this.tipoPagamento = tipoPagamento;
  }
}
