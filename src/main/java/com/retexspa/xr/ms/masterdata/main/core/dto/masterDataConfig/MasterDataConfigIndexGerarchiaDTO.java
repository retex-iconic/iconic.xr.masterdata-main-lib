package com.retexspa.xr.ms.masterdata.main.core.dto.masterDataConfig;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonInclude(Include.NON_NULL)
public class MasterDataConfigIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public MasterDataConfigIndexGerarchiaDTO() {}

  public MasterDataConfigIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getUk(MasterDataConfigBaseDTO master) {
    String uk =
        master.getContextId()
            + MasterDataConfigIndexGerarchiaDTO.getUkSeparator()
            + master.getCodice()
            + MasterDataConfigIndexGerarchiaDTO.getUkSeparator()
            + master.getNodoId();
    return uk;
  }

  public static String getIndexName(){
    return "MasterDataConfigIndexGerarchia";
  }

  public static String getIndexAggregateName(){
    return "MasterDataConfigIndexGerarchiaAggregate";
  }
}
