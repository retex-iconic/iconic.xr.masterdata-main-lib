package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticoloTassonomiaIndexDTO {

  private String articoloTassonomiaId;

  public ArticoloTassonomiaIndexDTO() {}

  public ArticoloTassonomiaIndexDTO(String articoloTassonomiaId) {
    this.articoloTassonomiaId = articoloTassonomiaId;
  }

  public String getArticoloTassonomiaId() {
    return articoloTassonomiaId;
  }

  public void setArticoloTassonomiaId(String articoloTassonomiaId) {
    this.articoloTassonomiaId = articoloTassonomiaId;
  }

  public static String getIdFromArticoloTassonomia(String articoloTassonomiaId) {
    return UUID.nameUUIDFromBytes(("/ArticoloTassonomiaIndex/" + articoloTassonomiaId).getBytes())
        .toString();
  }
  
  public static String getDetailNameArticoloTassonomia() {
    return "ArticoloTassonomia";
  }

  public static String getDetailNameArticoloTassonomiaAggregate() {
    return "ArticoloTassonomiaAggregate";
  }
}
