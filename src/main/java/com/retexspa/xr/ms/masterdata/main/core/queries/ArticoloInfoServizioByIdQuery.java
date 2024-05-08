package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ArticoloInfoServizioByIdQuery {
  private String articoloInfoServizoId;
  private String gerarchiaId;

  public ArticoloInfoServizioByIdQuery(String articoloId) {
    this.articoloInfoServizoId = articoloId;
  }

  public ArticoloInfoServizioByIdQuery(String articoloId, String gerarchiaId) {
    this.articoloInfoServizoId = articoloId;
    this.gerarchiaId = gerarchiaId;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getArticoloInfoServizoId() {
    return articoloInfoServizoId;
  }

  public void setArticoloInfoServizoId(String articoloId) {
    this.articoloInfoServizoId = articoloId;
  }
}
