package com.retexspa.xr.ms.masterdata.main.core.queries;

public class AtecoAggregateGetByIdQuery {

  private String atecoId;

  public AtecoAggregateGetByIdQuery(String atecoId) {
    this.atecoId = atecoId;
  }

  public String getAtecoId() {
    return this.atecoId;
  }

  public void setAtecoId(String atecoId) {
    this.atecoId = atecoId;
  }
}
