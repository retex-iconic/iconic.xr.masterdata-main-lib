package com.retexspa.xr.ms.masterdata.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
@Data
public class ArticoloVenditaMyTradeQueryDTO {
  // MYTRADE
  private String codArt;
  private String flgVarACaldo; // S o N
  private String codReparto;
  private Integer codIva;
  private Integer prezzoVendita;
  private String ean;
  private String plulinkId;
  private String anagrBilId;
  private String infoServizio;
  private String sottotipo;
}
