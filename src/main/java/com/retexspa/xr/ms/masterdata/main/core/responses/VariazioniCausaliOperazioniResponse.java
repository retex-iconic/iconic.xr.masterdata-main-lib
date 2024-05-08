package com.retexspa.xr.ms.masterdata.main.core.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.responses.BasePaginationResponse;
import com.retexspa.xr.ms.masterdata.main.core.entities.VariazioniCausaliOperazioniQueryDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class VariazioniCausaliOperazioniResponse
    extends BasePaginationResponse<VariazioniCausaliOperazioniQueryDTO> {

  public VariazioniCausaliOperazioniResponse() {
    super();
  }
}
