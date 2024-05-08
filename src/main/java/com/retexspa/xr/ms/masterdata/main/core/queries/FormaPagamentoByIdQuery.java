package com.retexspa.xr.ms.masterdata.main.core.queries;

public class FormaPagamentoByIdQuery {
  private final String formaPagamentoId;

  public FormaPagamentoByIdQuery(String formaPagamentoId) {
    this.formaPagamentoId = formaPagamentoId;
  }

  public String getFormaPagamentoId() {
    return formaPagamentoId;
  }
}
