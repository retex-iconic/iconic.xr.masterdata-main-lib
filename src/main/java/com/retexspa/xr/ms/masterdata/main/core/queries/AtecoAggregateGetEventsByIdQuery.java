package com.retexspa.xr.ms.masterdata.main.core.queries;

public class AtecoAggregateGetEventsByIdQuery {
  private String atecoId;

  public AtecoAggregateGetEventsByIdQuery(String atecoId) {
    this.atecoId = atecoId;
  }

  public String getAtecoId() {
    return atecoId;
  }

  public void setAtecoId(String atecoId) {
    this.atecoId = atecoId;
  }
}
