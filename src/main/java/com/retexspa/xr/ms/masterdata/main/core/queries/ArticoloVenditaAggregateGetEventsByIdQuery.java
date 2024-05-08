package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ArticoloVenditaAggregateGetEventsByIdQuery {
  private String articoloVenditaId;

  public ArticoloVenditaAggregateGetEventsByIdQuery(String articoloVenditaId) {
    this.articoloVenditaId = articoloVenditaId;
  }

  public String getArticoloVenditaId() {
    return articoloVenditaId;
  }

  public void setArticoloVenditaId(String articoloVenditaId) {
    this.articoloVenditaId = articoloVenditaId;
  }
}
