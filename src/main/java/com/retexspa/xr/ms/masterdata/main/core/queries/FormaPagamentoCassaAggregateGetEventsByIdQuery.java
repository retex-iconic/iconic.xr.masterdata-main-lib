package com.retexspa.xr.ms.masterdata.main.core.queries;

public class FormaPagamentoCassaAggregateGetEventsByIdQuery {
  private String formaPagamentoCassaId;

  public FormaPagamentoCassaAggregateGetEventsByIdQuery(String formaPagamentoCassaId) {
    this.formaPagamentoCassaId = formaPagamentoCassaId;
  }

  public String getFormaPagamentoCassaId() {
    return formaPagamentoCassaId;
  }

  public void setFormaPagamentoCassaId(String formaPagamentoCassaId) {
    this.formaPagamentoCassaId = formaPagamentoCassaId;
  }
}
