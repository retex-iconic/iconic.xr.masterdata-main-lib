package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ArticoloExtraAggregateGetByIdQuery {
  private String articoloExtraId;

  public ArticoloExtraAggregateGetByIdQuery(String articoloExtraId) {
    this.articoloExtraId = articoloExtraId;
  }

  public String getArticoloExtraId() {
    return articoloExtraId;
  }

  public void setArticoloExtraId(String articoloExtraId) {
    this.articoloExtraId = articoloExtraId;
  }
}
