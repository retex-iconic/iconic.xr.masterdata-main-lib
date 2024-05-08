package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ArticoliByGerarchiaIdQuery extends BasePagination {

  private String gerarchiaId;

  public ArticoliByGerarchiaIdQuery(Integer page, Integer limit, String gerarchiaId) {
    super(page, limit);
    this.gerarchiaId = gerarchiaId;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }
}
