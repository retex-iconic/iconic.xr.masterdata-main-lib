package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;


import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

public class ArticoloEanIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public ArticoloEanIndexGerarchiaDTO() {}

  public ArticoloEanIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getIndexName() {
    return "ArticoloEanIndexGerarchia";
  }

  public static String getIndexAggregateName() {
    return "ArticoloEanIndexGerarchiaAggregate";
  }
}
