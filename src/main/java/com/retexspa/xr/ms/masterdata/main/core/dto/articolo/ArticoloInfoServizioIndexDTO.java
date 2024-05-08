package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.UUID;

@JsonInclude(Include.NON_NULL)
public class ArticoloInfoServizioIndexDTO {

  private String articoloInfoServizioId;

  public ArticoloInfoServizioIndexDTO() {}

  public ArticoloInfoServizioIndexDTO(String articoloInfoServizioId) {
    this.articoloInfoServizioId = articoloInfoServizioId;
  }

  public static String getIdFromArticoloInfoServizio(String articoloInfoServizioId) {
    return UUID.nameUUIDFromBytes(
            ("/ArticoloInfoServizioIndex/" + articoloInfoServizioId).getBytes())
        .toString();
  }

  public String getArticoloInfoServizioId() {
    return this.articoloInfoServizioId;
  }

  public void setArticoloInfoServizioId(String articoloInfoServizioId) {
    this.articoloInfoServizioId = articoloInfoServizioId;
  }
}
