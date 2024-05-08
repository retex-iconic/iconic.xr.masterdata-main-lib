package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ArticoloAggregateGetByIdQuery {
  private String articoloId;

  public ArticoloAggregateGetByIdQuery(String articoloId) {
    this.articoloId = articoloId;
  }

  public String getArticoloId() {
    return articoloId;
  }

  public void setArticoloId(String articoloId) {
    this.articoloId = articoloId;
  }
}
