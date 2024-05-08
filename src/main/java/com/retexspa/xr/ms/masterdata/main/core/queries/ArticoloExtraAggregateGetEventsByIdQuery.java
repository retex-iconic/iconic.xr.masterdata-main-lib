package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ArticoloExtraAggregateGetEventsByIdQuery {
  private String articoloExtraId;

  public ArticoloExtraAggregateGetEventsByIdQuery(String articoloExtraId) {
    this.articoloExtraId = articoloExtraId;
  }

  public String getArticoloExtraId() {
    return articoloExtraId;
  }

  public void setArticoloExtraId(String articoloExtraId) {
    this.articoloExtraId = articoloExtraId;
  }
}
