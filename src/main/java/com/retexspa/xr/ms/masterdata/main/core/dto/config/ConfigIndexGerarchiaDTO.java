package com.retexspa.xr.ms.masterdata.main.core.dto.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;
import com.retexspa.xr.ms.main.core.dto.config.ConfigBaseDTO;

@JsonInclude(Include.NON_NULL)
public class ConfigIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public ConfigIndexGerarchiaDTO() {}

  public ConfigIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getUk(ConfigBaseDTO master) {
    String uk =
        master.getContextId()
            + ConfigIndexGerarchiaDTO.getUkSeparator()
            + master.getCodice()
            + ConfigIndexGerarchiaDTO.getUkSeparator()
            + master.getNodoId();
    return uk;
  }

  public static String getIndexName(){
    return "ConfigIndexGerarchia";
  }

  public static String getIndexAggregateName(){
    return "ConfigIndexGerarchiaAggregate";
  }
}
