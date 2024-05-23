package com.retexspa.xr.ms.masterdata.main.core.dto.servizi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;

import java.util.UUID;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TipologiaServizioBaseDTO extends BaseDTO {

  private Integer numMaxInScontrino;

  private Double valMaxInScontrino;

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }

  public Integer getNumMaxInScontrino() {
    return numMaxInScontrino;
  }

  public void setNumMaxInScontrino(Integer numMaxInScontrino) {
    this.numMaxInScontrino = numMaxInScontrino;
  }

  public Double getValMaxInScontrino() {
    return valMaxInScontrino;
  }

  public void setValMaxInScontrino(Double valMaxInScontrino) {
    this.valMaxInScontrino = valMaxInScontrino;
  }

  public static String getDetailNameTipologiaServizio() {
    return "TipologiaServizio";
  }

  public static String getDetailNameTipologiaServizioAggregate() {
    return "TipologiaServizioAggregate";
  }
}
