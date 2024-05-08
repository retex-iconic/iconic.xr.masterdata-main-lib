package com.retexspa.xr.ms.masterdata.main.core.queries;

public class ArticoloVenditaByIdQuery {
  private String fornitoreId;
  private String gerarchiaId;

  public ArticoloVenditaByIdQuery(String fornitoreId) {
    this.fornitoreId = fornitoreId;
  }

  public ArticoloVenditaByIdQuery(String fornitoreId, String gerarchiaId) {
    this.fornitoreId = fornitoreId;
    this.gerarchiaId = gerarchiaId;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getArticoloVenditaId() {
    return fornitoreId;
  }

  public void setArticoloVenditaId(String fornitoreId) {
    this.fornitoreId = fornitoreId;
  }
}
