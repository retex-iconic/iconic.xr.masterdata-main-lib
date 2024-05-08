package com.retexspa.xr.ms.masterdata.main.query.entities;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.pagamento.FormaPagamentoCassaBaseDTO;
import lombok.NonNull;

@Entity
@Table(name = "formaPagamentoCassa")
public class FormaPagamentoCassaQueryEntity {
  @Id @NonNull private String id;

  @Column(name = "xx1mty")
  private Integer xx1mty;

  @Column(name = "xx1mnr")
  private Integer xx1mnr;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "formaPagamento_id", referencedColumnName = "id")
  private FormaPagamentoQueryEntity formaPagamento;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  @Column(name = "codice")
  private String codice;

  @Column(name = "version")
  private Long version;

  public FormaPagamentoCassaQueryEntity() {}

  public FormaPagamentoCassaQueryEntity(
          @NonNull String id, FormaPagamentoCassaBaseDTO formaPagamentoCassaBaseDTO, Long version) {
    this.id = id;
    this.xx1mty = formaPagamentoCassaBaseDTO.getXx1mty();
    this.xx1mnr = formaPagamentoCassaBaseDTO.getXx1mnr();
    this.codice = formaPagamentoCassaBaseDTO.getCodice();
    this.version = version;
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

  public FormaPagamentoQueryEntity getFormaPagamento() {
    return formaPagamento;
  }

  public void setFormaPagamento(FormaPagamentoQueryEntity formaPagamento) {
    this.formaPagamento = formaPagamento;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
