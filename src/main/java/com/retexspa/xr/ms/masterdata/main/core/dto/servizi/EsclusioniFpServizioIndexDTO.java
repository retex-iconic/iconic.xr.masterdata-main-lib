package com.retexspa.xr.ms.masterdata.main.core.dto.servizi;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EsclusioniFpServizioIndexDTO {
  private String esclusioniFpServizioId;

  public EsclusioniFpServizioIndexDTO() {}

  public EsclusioniFpServizioIndexDTO(String esclusioniFpServizioId) {
    this.esclusioniFpServizioId = esclusioniFpServizioId;
  }

  public static String getIdFromEsclusioniFpServizio(String esclusioniFpServizioId) {
    return UUID.nameUUIDFromBytes(
            ("/EsclusioniFpServizioIndex/" + esclusioniFpServizioId).getBytes())
        .toString();
  }

  public String getEsclusioniFpServizioId() {
    return this.esclusioniFpServizioId;
  }

  public void setEsclusioniFpServizioId(String esclusioniFpServizioId) {
    this.esclusioniFpServizioId = esclusioniFpServizioId;
  }
}
