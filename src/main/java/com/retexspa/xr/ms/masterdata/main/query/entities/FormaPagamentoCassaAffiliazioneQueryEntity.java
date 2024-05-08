package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.util.UUID;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import org.springframework.lang.NonNull;

@Entity
@Table(
    name = "forma_pagamento_cassa_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "forma_pagamento_cassa_affiliazioni_uk",
          columnNames = {"negozio_id", "xx1mty", "xx1mnr"})
    },
    indexes = {
      @Index(
          name = "index_formapagamentocassaaffiliazioni_formapagamentocassaid",
          columnList = "forma_pagamento_cassa_id"),
      @Index(name = "index_formapagamentocassaaffiliazioni_xx1mty", columnList = "xx1mty"),
      @Index(name = "index_formapagamentocassaaffiliazioni_xx1mnr", columnList = "xx1mnr"),
      @Index(name = "index_formapagamentocassaaffiliazioni_negozio_id", columnList = "negozio_id")
    })
public class FormaPagamentoCassaAffiliazioneQueryEntity {
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
  @JoinColumn(name = "forma_pagamento_cassa_id", referencedColumnName = "id")
  private FormaPagamentoCassaQueryEntity formaPagamentoCassa;
  /*
      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "forma_pagamento_affiliazione_id", referencedColumnName = "id")
      private FormaPagamentoAffiliazioneQueryEntity formaPagamentoAffiliazione;
  */

  // UK
  @Column(name = "xx1mty")
  private Integer xx1mty;

  @Column(name = "xx1mnr")
  private Integer xx1mnr;

  public FormaPagamentoCassaAffiliazioneQueryEntity() {}

  public FormaPagamentoCassaAffiliazioneQueryEntity(
      String id,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio,
      FormaPagamentoCassaQueryEntity formaPagamentoCassa,
      Integer xx1mty,
      Integer xx1mnr
      // FormaPagamentoAffiliazioneQueryEntity formaPagamentoAffiliazione
      ) {
    this.id = id;
    this.formaPagamentoCassa = formaPagamentoCassa;
    this.xx1mty = xx1mty;
    this.xx1mnr = xx1mnr;
    this.gerarchia = gerarchia;
    this.negozio = negozio;
    // this.formaPagamentoAffiliazione = formaPagamentoAffiliazione;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getXx1mty() {
    return xx1mty;
  }

  public void setXx1mty(Integer xx1mty) {
    this.xx1mty = xx1mty;
  }

  public Integer getXx1mnr() {
    return xx1mnr;
  }

  public void setXx1mnr(Integer xx1mnr) {
    this.xx1mnr = xx1mnr;
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

  public FormaPagamentoCassaQueryEntity getFormaPagamentoCassa() {
    return formaPagamentoCassa;
  }

  public void setFormaPagamentoCassa(FormaPagamentoCassaQueryEntity formaPagamentoCassa) {
    this.formaPagamentoCassa = formaPagamentoCassa;
  }
  /*    public FormaPagamentoAffiliazioneQueryEntity getFormaPagamentoAffiliazione() {
      return formaPagamentoAffiliazione;
  }

  public void setFormaPagamentoAffiliazione(FormaPagamentoAffiliazioneQueryEntity formaPagamentoAffiliazione) {
      this.formaPagamentoAffiliazione = formaPagamentoAffiliazione;
  }*/
}
