package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ArticoloAggregateGetEventsByIdQuery {
  private String articoloId;

  public ArticoloAggregateGetEventsByIdQuery(String articoloId) {
    this.articoloId = articoloId;
  }

  public String getArticoloId() {
    return articoloId;
  }

  public void setArticoloId(String articoloId) {
    this.articoloId = articoloId;
  }
}
