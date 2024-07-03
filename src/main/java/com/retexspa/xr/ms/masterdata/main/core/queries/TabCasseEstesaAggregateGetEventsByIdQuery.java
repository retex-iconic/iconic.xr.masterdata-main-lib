package com.retexspa.xr.ms.masterdata.main.core.queries;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TabCasseEstesaAggregateGetEventsByIdQuery {
    private String tabCasseEstesaId;

    public TabCasseEstesaAggregateGetEventsByIdQuery(String tabCasseEstesaId) {
        this.tabCasseEstesaId = tabCasseEstesaId;
    }
}
