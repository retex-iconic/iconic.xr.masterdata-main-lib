package com.retexspa.xr.ms.masterdata.main.core.queries;

public class FormaPagamentoAggregateGetByIdQuery {
  private String formaPagamentoId;

  public FormaPagamentoAggregateGetByIdQuery(String formaPagamentoId) {
    this.formaPagamentoId = formaPagamentoId;
  }

  public String getFormaPagamentoId() {
    return formaPagamentoId;
  }

  public void setTipoPagamentoId(String formaPagamentoId) {
    this.formaPagamentoId = formaPagamentoId;
  }
}
