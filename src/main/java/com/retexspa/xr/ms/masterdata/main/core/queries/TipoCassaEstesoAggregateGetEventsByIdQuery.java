package com.retexspa.xr.ms.masterdata.main.core.queries;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoCassaEstesoAggregateGetEventsByIdQuery {

    private String tipoCassaEstesoId;

    public TipoCassaEstesoAggregateGetEventsByIdQuery(String tipoCassaEstesoId) {
        this.tipoCassaEstesoId = tipoCassaEstesoId;
    }

}
