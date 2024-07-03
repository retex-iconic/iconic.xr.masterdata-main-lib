package com.retexspa.xr.ms.masterdata.main.core.dto.tabCasseEstesa;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TabCasseEstesaIndexUkDTO extends AggregateIndexUkBaseDTO {

    public TabCasseEstesaIndexUkDTO() {
    }

    public static String getUk(TabCasseEstesaBaseDTO tabCasseEstesa) {
        String uk = tabCasseEstesa.getCassaId() + TabCasseEstesaIndexUkDTO.getUkSeparator()
                + tabCasseEstesa.getTipoCassaEstesoId() + TabCasseEstesaIndexUkDTO.getUkSeparator()
                + tabCasseEstesa.getDataInizio();
        return uk;
    }

    public static String getIndexName() {
        return "TabCasseEstesaIndexUk";
    }

    public static String getIndexAggregateName() {
        return "TabCasseEstesaIndexUkAggregate";
    }
}
