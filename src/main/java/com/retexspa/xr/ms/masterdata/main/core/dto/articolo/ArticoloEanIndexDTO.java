package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class ArticoloEanIndexDTO {

  private String eanId;

  public ArticoloEanIndexDTO() {}

  public ArticoloEanIndexDTO(String eanId) {
    this.eanId = eanId;
  }

  public static String getIdFromEan(String eanId) {
    return UUID.nameUUIDFromBytes(("/EanIndex/" + eanId).getBytes()).toString();
  }

  public String getEanId() {
    return this.eanId;
  }

  public static String getDeatilNameArticoloEan() {
    return "ArticoloEan";
  }

  public static String getDeatilNameArticoloEanAggregate() {
    return "ArticoloEanAggregate";
  }
}
