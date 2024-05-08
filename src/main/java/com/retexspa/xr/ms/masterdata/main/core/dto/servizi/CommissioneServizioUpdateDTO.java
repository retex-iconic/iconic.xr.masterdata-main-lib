package com.retexspa.xr.ms.masterdata.main.core.dto.servizi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommissioneServizioUpdateDTO {
  private String flgDefault;

  public String getFlgDefault() {
    return flgDefault;
  }

  public void setFlgDefault(String flgDefault) {
    this.flgDefault = flgDefault;
  }
}
