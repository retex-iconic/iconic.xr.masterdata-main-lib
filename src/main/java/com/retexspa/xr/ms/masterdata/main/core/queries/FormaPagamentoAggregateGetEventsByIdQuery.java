package com.retexspa.xr.ms.masterdata.main.core.queries;

public class FormaPagamentoAggregateGetEventsByIdQuery {
  private String formaPagamentoId;

  public FormaPagamentoAggregateGetEventsByIdQuery(String formaPagamentoId) {
    this.formaPagamentoId = formaPagamentoId;
  }

  public String getFormaPagamentoId() {
    return formaPagamentoId;
  }

  public void setFormaPagamentoId(String formaPagamentoId) {
    this.formaPagamentoId = formaPagamentoId;
  }
}
