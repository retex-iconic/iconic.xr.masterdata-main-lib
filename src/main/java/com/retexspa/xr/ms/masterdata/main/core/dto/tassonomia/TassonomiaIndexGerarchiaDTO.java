package com.retexspa.xr.ms.masterdata.main.core.dto.tassonomia;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonInclude(Include.NON_NULL)
public class TassonomiaIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public TassonomiaIndexGerarchiaDTO() {}

  public TassonomiaIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getUk(TassonomiaBaseDTO tassonomia) {
    String uk =
        tassonomia.getTipoTassonomiaId()
            + TassonomiaIndexGerarchiaDTO.getUkSeparator()
            + tassonomia.getCodice()
            + TassonomiaIndexGerarchiaDTO.getUkSeparator()
            + (tassonomia.getNodoId() != null ? tassonomia.getNodoId() : "");
    return uk;
  }
  public static String getIndexName(){
    return "TassonomiaIndexGerarchia";
  }

  public static String getIndexAggregateName(){
    return "TassonomiaIndexGerarchiaAggregate";
  }

}
