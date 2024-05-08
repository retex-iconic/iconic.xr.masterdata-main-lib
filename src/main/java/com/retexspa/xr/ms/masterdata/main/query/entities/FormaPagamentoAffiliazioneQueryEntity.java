package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.util.UUID;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import org.springframework.lang.NonNull;

@Entity
@Table(
    name = "forma_pagamento_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "forma_pagamento_affiliazioni_uk",
          columnNames = {"negozio_id", "codice"})
    },
    indexes = {
      @Index(
          name = "index_forma_pagamento_affiliazioni_forma_pagamento_id",
          columnList = "forma_pagamento_id"),
      @Index(name = "index_forma_pagamento_affiliazioni_codice", columnList = "codice"),
      @Index(name = "index_forma_pagamento_affiliazioni_negozio_id", columnList = "negozio_id")
    })
public class FormaPagamentoAffiliazioneQueryEntity {
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
  @JoinColumn(name = "forma_pagamento_id", referencedColumnName = "id")
  private FormaPagamentoQueryEntity formaPagamento;

  // UK
  @Column(name = "codice")
  private String codice;

  public FormaPagamentoAffiliazioneQueryEntity() {}

  public FormaPagamentoAffiliazioneQueryEntity(
      String id,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio,
      FormaPagamentoQueryEntity formaPagamento,
      String codice,
      TipoPagamentoQueryEntity tipoPagamento) {
    this.id = id;
    this.formaPagamento = formaPagamento;
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

  public FormaPagamentoQueryEntity getFormaPagamento() {
    return formaPagamento;
  }

  public void setFormaPagamento(FormaPagamentoQueryEntity formaPagamento) {
    this.formaPagamento = formaPagamento;
  }
}
