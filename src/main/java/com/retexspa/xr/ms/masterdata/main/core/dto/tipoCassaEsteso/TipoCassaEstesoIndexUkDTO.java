package com.retexspa.xr.ms.masterdata.main.core.dto.tipoCassaEsteso;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexUkBaseDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipoCassaEstesoIndexUkDTO  extends AggregateIndexUkBaseDTO {

    public TipoCassaEstesoIndexUkDTO() {}

    public static String getUk(TipoCassaEstesoBaseDTO tipoCassaEsteso) {
        String uk = tipoCassaEsteso.getCodice();
        return uk;
    }

    public static String getIndexName(){
        return "TipoCassaEstesoIndexUk";
    }

    public static String getIndexAggregateName(){
        return "TipoCassaEstesoIndexUkAggregate";
    }
}


