package com.retexspa.xr.ms.masterdata.main.core.queries;

public class TipoPagamentoByIdQuery {

  private final String tipoPagamentoId;

  public TipoPagamentoByIdQuery(String tipoPagamentoId) {
    this.tipoPagamentoId = tipoPagamentoId;
  }

  public String getTipoPagamentoId() {
    return tipoPagamentoId;
  }
}
