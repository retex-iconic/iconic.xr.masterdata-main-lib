package com.retexspa.xr.ms.masterdata.main.core.queries;

public class TipoPagamentoAggregateGetEventsByIdQuery {
  private String tipoPagamentoId;

  public TipoPagamentoAggregateGetEventsByIdQuery(String tipoPagamentoId) {
    this.tipoPagamentoId = tipoPagamentoId;
  }

  public String getTipoPagamentoId() {
    return tipoPagamentoId;
  }

  public void setTipoPagamentoId(String tipoPagamentoId) {
    this.tipoPagamentoId = tipoPagamentoId;
  }
}
