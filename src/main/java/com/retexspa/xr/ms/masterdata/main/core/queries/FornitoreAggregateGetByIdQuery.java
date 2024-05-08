package com.retexspa.xr.ms.masterdata.main.core.queries;

public class FornitoreAggregateGetByIdQuery {
  private String fornitoreId;

  public FornitoreAggregateGetByIdQuery(String fornitoreId) {
    this.fornitoreId = fornitoreId;
  }

  public String getFornitoreId() {
    return fornitoreId;
  }

  public void setFornitoreId(String fornitoreId) {
    this.fornitoreId = fornitoreId;
  }
}
