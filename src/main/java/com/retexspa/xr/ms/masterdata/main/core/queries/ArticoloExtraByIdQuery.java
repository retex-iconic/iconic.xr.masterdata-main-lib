package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ArticoloExtraByIdQuery {
  private String articoloExtraId;
  private String gerarchiaId;

  public ArticoloExtraByIdQuery(String articoloExtraId) {
    this.articoloExtraId = articoloExtraId;
  }

  public ArticoloExtraByIdQuery(String articoloExtraId, String gerarchiaId) {
    this.articoloExtraId = articoloExtraId;
    this.gerarchiaId = gerarchiaId;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getArticoloExtraId() {
    return articoloExtraId;
  }

  public void setArticoloExtraId(String articoloExtraId) {
    this.articoloExtraId = articoloExtraId;
  }
}
