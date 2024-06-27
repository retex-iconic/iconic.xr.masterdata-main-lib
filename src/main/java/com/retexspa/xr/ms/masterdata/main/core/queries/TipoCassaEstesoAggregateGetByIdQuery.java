package com.retexspa.xr.ms.masterdata.main.core.queries;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoCassaEstesoAggregateGetByIdQuery {
    private String tipoCassaEstesoId;

    public TipoCassaEstesoAggregateGetByIdQuery(String tipoCassaEstesoId) {
        this.tipoCassaEstesoId = tipoCassaEstesoId;
    }
}
