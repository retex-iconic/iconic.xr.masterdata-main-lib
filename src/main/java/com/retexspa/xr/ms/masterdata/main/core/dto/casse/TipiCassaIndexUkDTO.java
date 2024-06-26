package com.retexspa.xr.ms.masterdata.main.core.dto.casse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipiCassaIndexUkDTO extends AggregateIndexUkBaseDTO {

    public TipiCassaIndexUkDTO() {}

    public static String getUk(TipiCassaBaseDTO tipiCassa) {
        String uk = tipiCassa.getCodice();
        return uk;
    }

    public static String getIndexName(){
        return "TipiCassaIndexUk";
    }

    public static String getIndexAggregateName(){
        return "TipiCassaIndexUkAggregate";
    }
}

