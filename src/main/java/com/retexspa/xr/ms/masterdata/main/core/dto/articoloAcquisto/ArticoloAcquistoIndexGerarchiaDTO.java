package com.retexspa.xr.ms.masterdata.main.core.dto.articoloAcquisto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class ArticoloAcquistoIndexGerarchiaDTO {

  private String gerarchiaId;
  private List<String> articoliIds;

  public ArticoloAcquistoIndexGerarchiaDTO() {}

  public ArticoloAcquistoIndexGerarchiaDTO(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
    this.articoliIds = new ArrayList<String>();
  }

  public static String getIdFromGerarchia(String gerarchiaId, String string) {
    return UUID.nameUUIDFromBytes(("/ArticoloAcquistoIndexGerarchia/" + gerarchiaId).getBytes())
        .toString();
  }

  public static String getIdFromGerarchia(String gerarchiaId) {
    return UUID.nameUUIDFromBytes(("/ArticoloAcquistoIndexGerarchia/" + gerarchiaId).getBytes())
        .toString();
  }

  public String getGerarchiaId() {
    return this.gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public List<String> getArticoliIds() {
    return this.articoliIds;
  }

  public void setArticoliIds(List<String> articoliIds) {
    this.articoliIds = articoliIds;
  }
}
