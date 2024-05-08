package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ArticoloVenditaListQuery {

  private final Integer page;
  private final Integer limit;

  public ArticoloVenditaListQuery(Integer page, Integer limit) {
    this.page = page;
    this.limit = limit;
  }

  public Integer getPage() {
    return page;
  }

  public Integer getLimit() {
    return limit;
  }
}
