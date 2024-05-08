package com.retexspa.xr.ms.masterdata.main.core.dto.operatore;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class OperatorePosIndexDTO {

  private String operatorePosId;
  private List<String> negozioIds;

  public OperatorePosIndexDTO() {}

  public OperatorePosIndexDTO(String operatorePosId) {
    this.operatorePosId = operatorePosId;
    this.negozioIds = new ArrayList<String>();
  }

  public static String getIdFromOperatorePos(String operatorePosId) {
    return UUID.nameUUIDFromBytes(("/OperatorePosIndex/" + operatorePosId).getBytes()).toString();
  }

  public String getOperatorePosId() {
    return this.operatorePosId;
  }

  public void setOperatorePosId(String operatorePosId) {
    this.operatorePosId = operatorePosId;
  }

  public List<String> getNegozioIds() {
    return this.negozioIds;
  }

  public void setNegozioIds(List<String> negozioIds) {
    this.negozioIds = negozioIds;
  }
}
