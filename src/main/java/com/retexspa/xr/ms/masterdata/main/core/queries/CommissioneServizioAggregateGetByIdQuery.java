package com.retexspa.xr.ms.masterdata.main.core.queries;

public class CommissioneServizioAggregateGetByIdQuery {
  private String commissioneServizioId;

  public CommissioneServizioAggregateGetByIdQuery(String commissioneServizioId) {
    this.commissioneServizioId = commissioneServizioId;
  }

  public String getCommissioneServizioId() {
    return commissioneServizioId;
  }

  public void setCommissioneServizioId(String commissioneServizioId) {
    this.commissioneServizioId = commissioneServizioId;
  }
}
