package com.retexspa.xr.ms.masterdata.main.core.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.responses.BasePaginationResponse;
import com.retexspa.xr.ms.masterdata.main.core.entities.AnagraficaServizioQueryDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AnagraficaServizioResponse extends BasePaginationResponse<AnagraficaServizioQueryDTO> {

  public AnagraficaServizioResponse() {
    super();
  }
}
