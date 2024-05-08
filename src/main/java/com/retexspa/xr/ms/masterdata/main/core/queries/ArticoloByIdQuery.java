package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ArticoloByIdQuery {
  private String articoloId;
  private String gerarchiaId;

  public ArticoloByIdQuery(String articoloId) {
    this.articoloId = articoloId;
  }

  public ArticoloByIdQuery(String articoloId, String gerarchiaId) {
    this.articoloId = articoloId;
    this.gerarchiaId = gerarchiaId;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getArticoloId() {
    return articoloId;
  }

  public void setArticoloId(String articoloId) {
    this.articoloId = articoloId;
  }
}
