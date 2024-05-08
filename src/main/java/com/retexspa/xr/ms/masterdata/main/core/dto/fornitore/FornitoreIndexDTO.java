package com.retexspa.xr.ms.masterdata.main.core.dto.fornitore;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class FornitoreIndexDTO {

  private String fornitoreId;
  private LinkedList<String> figliIds;

  public FornitoreIndexDTO() {}

  public FornitoreIndexDTO(String fornitoreId) {
    this.fornitoreId = fornitoreId;
  }

  public static String getIdFromFornitore(String fornitoreId) {
    return UUID.nameUUIDFromBytes(("/FornitoreIndex/" + fornitoreId).getBytes()).toString();
  }

  public String getFornitoreId() {
    return this.fornitoreId;
  }

  public void setFornitoreId(String fornitoreId) {
    this.fornitoreId = fornitoreId;
  }

  public LinkedList<String> getFigliIds() {
    return this.figliIds;
  }

  public void setFigliIds(LinkedList<String> figliIds) {
    this.figliIds = figliIds;
  }
}
