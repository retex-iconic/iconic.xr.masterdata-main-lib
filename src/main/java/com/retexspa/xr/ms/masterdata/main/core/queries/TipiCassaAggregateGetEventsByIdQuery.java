package com.retexspa.xr.ms.masterdata.main.core.queries;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipiCassaAggregateGetEventsByIdQuery {
    private String tipiCassaId;

    public TipiCassaAggregateGetEventsByIdQuery(String tipiCassaId) {
        this.tipiCassaId = tipiCassaId;
    }
}
