package com.retexspa.xr.ms.masterdata.main.core.queries;

public class NegozioByIdQuery {
  private String negozioId;
  private String gerarchiaId;

  public NegozioByIdQuery(String negozioId) {
    this.negozioId = negozioId;
  }

  public NegozioByIdQuery(String negozioId, String gerarchiaId) {
    this.negozioId = negozioId;
    this.gerarchiaId = gerarchiaId;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getNegozioId() {
    return negozioId;
  }

  public void setNegozioId(String negozioId) {
    this.negozioId = negozioId;
  }
}
