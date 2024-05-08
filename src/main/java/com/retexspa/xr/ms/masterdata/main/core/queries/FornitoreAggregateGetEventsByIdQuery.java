package com.retexspa.xr.ms.masterdata.main.core.queries;

public class FornitoreAggregateGetEventsByIdQuery {
  private String fornitoreId;

  public FornitoreAggregateGetEventsByIdQuery(String fornitoreId) {
    this.fornitoreId = fornitoreId;
  }

  public String getFornitoreId() {
    return fornitoreId;
  }

  public void setFornitoreId(String fornitoreId) {
    this.fornitoreId = fornitoreId;
  }
}
