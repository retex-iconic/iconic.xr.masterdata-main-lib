package com.retexspa.xr.ms.masterdata.main.core.dto.ateco;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AtecoBaseDTO extends BaseDTO {

  public AtecoBaseDTO() {}

  private Integer atecoNr;

  public AtecoBaseDTO(Integer atecoNr) {
    this.atecoNr = atecoNr;
  }

  public Integer getAtecoNr() {
    return this.atecoNr;
  }

  public void setAtecoNr(Integer atecoNr) {
    this.atecoNr = atecoNr;
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }

  public static String getName() {
    return "Ateco";
  }

  public static String getAggregateName() {
    return "AtecoAggregate";
  }
}
