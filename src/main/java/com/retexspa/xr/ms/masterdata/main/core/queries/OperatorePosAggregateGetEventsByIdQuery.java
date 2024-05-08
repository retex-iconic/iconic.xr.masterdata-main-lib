package com.retexspa.xr.ms.masterdata.main.core.queries;

public class OperatorePosAggregateGetEventsByIdQuery {
  private String operatorePosId;

  public OperatorePosAggregateGetEventsByIdQuery(String operatorePosId) {
    this.operatorePosId = operatorePosId;
  }

  public String getOperatorePosId() {
    return operatorePosId;
  }

  public void setOperatorePosId(String operatorePosId) {
    this.operatorePosId = operatorePosId;
  }
}
