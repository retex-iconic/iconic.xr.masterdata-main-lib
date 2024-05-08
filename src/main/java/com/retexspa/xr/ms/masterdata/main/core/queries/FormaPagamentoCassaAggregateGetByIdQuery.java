package com.retexspa.xr.ms.masterdata.main.core.queries;

public class FormaPagamentoCassaAggregateGetByIdQuery {
  private String formaPagamentoCassaId;

  public FormaPagamentoCassaAggregateGetByIdQuery(String formaPagamentoCassaId) {
    this.formaPagamentoCassaId = formaPagamentoCassaId;
  }

  public String getFormaPagamentoCassaId() {
    return formaPagamentoCassaId;
  }

  public void setFormaPagamentoCassaId(String formaPagamentoCassaId) {
    this.formaPagamentoCassaId = formaPagamentoCassaId;
  }
}
