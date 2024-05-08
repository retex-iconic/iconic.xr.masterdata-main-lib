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
public class ArticoloAcquistoIndexDTO {

  private String articoloAcquistoId;
  private List<String> fornitoreIds;

  public ArticoloAcquistoIndexDTO(String articoloAcquistoId) {
    this.articoloAcquistoId = articoloAcquistoId;
    this.fornitoreIds = new ArrayList<String>();
  }

  public static String getIdFromArticoloAcquisto(String articoloAcquistoId) {
    return UUID.nameUUIDFromBytes(("/ArticoloAcquistoIndex/" + articoloAcquistoId).getBytes())
        .toString();
  }

  public String getArticoloAcquistoId() {
    return this.articoloAcquistoId;
  }

  public void setArticoloAcquistoId(String articoloAcquistoId) {
    this.articoloAcquistoId = articoloAcquistoId;
  }

  public List<String> getFornitoreIds() {
    return this.fornitoreIds;
  }

  public void setFornitoreIds(List<String> fornitoreIds) {
    this.fornitoreIds = fornitoreIds;
  }
}
