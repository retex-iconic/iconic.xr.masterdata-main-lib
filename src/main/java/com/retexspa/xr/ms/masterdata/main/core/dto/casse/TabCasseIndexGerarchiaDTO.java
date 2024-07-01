package com.retexspa.xr.ms.masterdata.main.core.dto.casse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;
import com.retexspa.xr.ms.masterdata.main.core.dto.iva.IvaBaseDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TabCasseIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

    public TabCasseIndexGerarchiaDTO() {}

    public TabCasseIndexGerarchiaDTO(String gerarchiaId) {
        super(gerarchiaId);
    }

    public static String getUk(TabCasseBaseDTO tabCasse) {
        String uk = tabCasse.getCodice();
        return uk;
    }

    public static String getIndexName(){
        return "TabCasseIndexGerarchia";
    }

    public static String getIndexAggregateName(){
        return "TabCasseIndexGerarchiaAggregate";
    }
}
