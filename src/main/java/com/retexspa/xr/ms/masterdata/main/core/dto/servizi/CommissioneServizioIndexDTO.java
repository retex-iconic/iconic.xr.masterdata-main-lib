package com.retexspa.xr.ms.masterdata.main.core.dto.servizi;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommissioneServizioIndexDTO {

  private String commissioneServizioId;

  public CommissioneServizioIndexDTO() {}

  public CommissioneServizioIndexDTO(String commissioneServizioId) {
    this.commissioneServizioId = commissioneServizioId;
  }

  public static String getIdFromCommissioneServizio(String commissioneServizioId) {
    return UUID.nameUUIDFromBytes(("/CommissioneServizioIndex/" + commissioneServizioId).getBytes())
        .toString();
  }

  public String getCommissioneServizioId() {
    return this.commissioneServizioId;
  }

  public void setCommissioneServizioId(String commissioneServizioId) {
    this.commissioneServizioId = commissioneServizioId;
  }
}
