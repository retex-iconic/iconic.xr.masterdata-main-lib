package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.responses.VariazioniRegoleMonitoraggioResponse;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.VariazioniRegoleMonitoraggioFilter;
import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniRegoleMonitoraggioQueryEntity;
import org.springframework.data.domain.Page;

public interface VariazioniRegoleMonitoraggioQueryService {

  Page<VariazioniRegoleMonitoraggioQueryEntity> searchQueryVariazioniRegoleMonitoraggio(
    GenericSearchRequest<VariazioniRegoleMonitoraggioFilter>  query);

  VariazioniRegoleMonitoraggioResponse searchVariazioniRegole(
    GenericSearchRequest<VariazioniRegoleMonitoraggioFilter> query);
}
