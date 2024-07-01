package com.retexspa.xr.ms.masterdata.main.core.queries;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TabCasseEstesaAggregateGetByIdQuery {
    private String tabCasseEstesaId;

    public TabCasseEstesaAggregateGetByIdQuery(String tabCasseEstesaId) {
        this.tabCasseEstesaId = tabCasseEstesaId;
    }
}
