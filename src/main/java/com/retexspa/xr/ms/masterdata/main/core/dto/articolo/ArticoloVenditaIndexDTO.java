package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class ArticoloVenditaIndexDTO {

  private String articoloVenditaId;

  public ArticoloVenditaIndexDTO(String articoloVenditaId) {
    this.articoloVenditaId = articoloVenditaId;
  }

  public static String getIdFromArticoloVendita(String articoloVenditaId) {
    return UUID.nameUUIDFromBytes(("/ArticoloVenditaIndex/" + articoloVenditaId).getBytes())
        .toString();
  }

  public String getArticoloVenditaId() {
    return this.articoloVenditaId;
  }

  public void setArticoloVenditaId(String articoloVenditaId) {
    this.articoloVenditaId = articoloVenditaId;
  }

  public static String getDeatilNameArticoloVendita() {
    return "ArticoloVendita";
  }

  public static String getDeatilNameArticoloVendita2() {
    return "Articolo Vendita";
  }

  public static String getDeatilNameArticoloVenditaAggregate() {
    return "ArticoloVenditaAggregate";
  }
}
