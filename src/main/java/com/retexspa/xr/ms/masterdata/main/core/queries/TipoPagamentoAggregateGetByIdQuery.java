package com.retexspa.xr.ms.masterdata.main.core.queries;

public class TipoPagamentoAggregateGetByIdQuery {
  public String getTipoPagamentoId() {
    return tipoPagamentoId;
  }

  public void setTipoPagamentoId(String tipoPagamentoId) {
    this.tipoPagamentoId = tipoPagamentoId;
  }

  private String tipoPagamentoId;

  public TipoPagamentoAggregateGetByIdQuery(String tipoPagamentoId) {
    this.tipoPagamentoId = tipoPagamentoId;
  }
}
