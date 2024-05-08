package com.retexspa.xr.ms.masterdata.main.core.dto.tassonomia;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class TipoTassonomiaUpdateFlgNonCancellabileDTO {
  private String flgNonCancellabile;
}
