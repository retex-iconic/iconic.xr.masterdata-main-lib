package com.retexspa.xr.ms.masterdata.main.core.dto.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonInclude(Include.NON_NULL)
public class ConfigContextIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public ConfigContextIndexGerarchiaDTO() {}

  public ConfigContextIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getIndexName(){
    return "ConfigContextIndexGerarchia";
  }

  public static String getIndexAggregateName(){
    return "ConfigContextIndexGerarchiaAggregate";
  }
}
