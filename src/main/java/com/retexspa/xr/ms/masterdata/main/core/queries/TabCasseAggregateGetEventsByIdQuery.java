package com.retexspa.xr.ms.masterdata.main.core.queries;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TabCasseAggregateGetEventsByIdQuery {
    private String tabCasseId;

    public TabCasseAggregateGetEventsByIdQuery(String tabCasseId) {
        this.tabCasseId = tabCasseId;
    }
}
