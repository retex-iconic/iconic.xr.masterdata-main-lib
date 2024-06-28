package com.retexspa.xr.ms.masterdata.main.core.queries;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TabCasseAggregateGetByIdQuery {
    private String tabCasseId;

    public TabCasseAggregateGetByIdQuery(String tabCasseId) {
        this.tabCasseId = tabCasseId;
    }
}

