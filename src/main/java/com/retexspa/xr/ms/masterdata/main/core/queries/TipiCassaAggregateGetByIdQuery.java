package com.retexspa.xr.ms.masterdata.main.core.queries;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipiCassaAggregateGetByIdQuery {
    private String tipiCassaId;

    public TipiCassaAggregateGetByIdQuery(String tipiCassaId) {
        this.tipiCassaId = tipiCassaId;
    }
}
