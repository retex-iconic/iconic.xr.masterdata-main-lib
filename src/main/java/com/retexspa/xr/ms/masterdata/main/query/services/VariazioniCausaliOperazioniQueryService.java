package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.responses.VariazioniCausaliOperazioniResponse;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.VariazioniCausaliOperazioniFilter;
import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniCausaliOperazioniQueryEntity;
import org.springframework.data.domain.Page;

public interface VariazioniCausaliOperazioniQueryService {

    VariazioniCausaliOperazioniResponse searchVariazioniCausaliOperazioni(
            GenericSearchRequest<VariazioniCausaliOperazioniFilter> query);

    Page<VariazioniCausaliOperazioniQueryEntity> searchQueryVariazioniCausaliOperazioni(
            GenericSearchRequest<VariazioniCausaliOperazioniFilter> query);
}
