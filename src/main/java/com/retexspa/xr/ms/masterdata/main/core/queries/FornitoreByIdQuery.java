package com.retexspa.xr.ms.masterdata.main.core.queries;

public class FornitoreByIdQuery {
  private String fornitoreId;
  private String gerarchiaId;

  public FornitoreByIdQuery(String fornitoreId) {
    this.fornitoreId = fornitoreId;
  }

  public FornitoreByIdQuery(String fornitoreId, String gerarchiaId) {
    this.fornitoreId = fornitoreId;
    this.gerarchiaId = gerarchiaId;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getFornitoreId() {
    return fornitoreId;
  }

  public void setFornitoreId(String fornitoreId) {
    this.fornitoreId = fornitoreId;
  }
}
