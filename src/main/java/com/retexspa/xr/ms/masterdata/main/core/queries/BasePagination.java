package com.retexspa.xr.ms.masterdata.main.core.queries;

public class BasePagination {

  private final Integer page;
  private final Integer limit;

  public BasePagination(Integer page, Integer limit) {
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
