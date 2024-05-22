package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;

import java.util.UUID;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ArticoloBaseDTO extends BaseDTO {
  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }

  public static String getDetailNameArticolo() {
    return "Articolo";
  }

  public static String getDetailNameArticoloAggregate() {
    return "ArticoloAggregate";
  }
}
