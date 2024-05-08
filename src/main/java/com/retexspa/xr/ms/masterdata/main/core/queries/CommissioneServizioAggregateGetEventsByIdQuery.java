package com.retexspa.xr.ms.masterdata.main.core.queries;

public class CommissioneServizioAggregateGetEventsByIdQuery {

  private String commissioneServizioId;

  public CommissioneServizioAggregateGetEventsByIdQuery(String commissioneServizioId) {
    this.commissioneServizioId = commissioneServizioId;
  }

  public String getCommissioneServizioId() {
    return commissioneServizioId;
  }

  public void setCommissioneServizioId(String commissioneServizioId) {
    this.commissioneServizioId = commissioneServizioId;
  }
}
