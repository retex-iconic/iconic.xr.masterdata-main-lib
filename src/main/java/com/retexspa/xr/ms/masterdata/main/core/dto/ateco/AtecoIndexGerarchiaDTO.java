package com.retexspa.xr.ms.masterdata.main.core.dto.ateco;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AtecoIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  private List<Integer> atecoNrs;

  public AtecoIndexGerarchiaDTO() {}

  public AtecoIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public List<Integer> getAtecoNrs() {
    return atecoNrs;
  }

  public void setAtecoNrs(List<Integer> atecoNrs) {
    this.atecoNrs = atecoNrs;
  }

  public static Integer getUk(AtecoBaseDTO ateco) {
    Integer uk = ateco.getAtecoNr();
    return uk;
  }
}
