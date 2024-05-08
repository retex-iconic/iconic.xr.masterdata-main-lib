package com.retexspa.xr.ms.masterdata.main.core.dto.articoloExtra;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonInclude(Include.NON_NULL)
public class ArticoloExtraIndexGerarchiaDTO {

  private String gerarchiaId;
  private List<String> articoliExtraIds;

  public ArticoloExtraIndexGerarchiaDTO() {}

  public ArticoloExtraIndexGerarchiaDTO(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
    this.articoliExtraIds = new ArrayList<String>();
  }

  public static String getIdFromGerarchia(String gerarchiaId, String string) {
    return UUID.nameUUIDFromBytes(("/ArticoloExtraIndexGerarchia/" + gerarchiaId).getBytes())
        .toString();
  }

  public String getGerarchiaId() {
    return this.gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public List<String> getArticoliIds() {
    return this.articoliExtraIds;
  }

  public void setArticoliIds(List<String> articoliExtraIds) {
    this.articoliExtraIds = articoliExtraIds;
  }
}
