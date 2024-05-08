package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ArticoloVenditaAggregateGetByIdQuery {
  private String articoloVenditaId;

  public ArticoloVenditaAggregateGetByIdQuery(String articoloVenditaId) {
    this.articoloVenditaId = articoloVenditaId;
  }

  public String getArticoloVenditaId() {
    return articoloVenditaId;
  }

  public void setArticoloVenditaId(String articoloVenditaId) {
    this.articoloVenditaId = articoloVenditaId;
  }
}
