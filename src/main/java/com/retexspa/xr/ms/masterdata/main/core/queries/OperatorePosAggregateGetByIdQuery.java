package com.retexspa.xr.ms.masterdata.main.core.queries;

public class OperatorePosAggregateGetByIdQuery {
  private String operatorePosId;

  public OperatorePosAggregateGetByIdQuery(String operatorePosId) {
    this.operatorePosId = operatorePosId;
  }

  public String getOperatorePosId() {
    return operatorePosId;
  }

  public void setOperatorePosId(String operatorePosId) {
    this.operatorePosId = operatorePosId;
  }
}
