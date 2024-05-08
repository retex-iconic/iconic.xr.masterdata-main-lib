package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.responses.VariazioniRegoleMonitoraggioResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.VariazioniRegoleMonitoraggioSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniRegoleMonitoraggioQueryEntity;
import org.springframework.data.domain.Page;

public interface VariazioniRegoleMonitoraggioQueryService {

  Page<VariazioniRegoleMonitoraggioQueryEntity> searchQueryVariazioniRegoleMonitoraggio(
      VariazioniRegoleMonitoraggioSearchRequest query);

  VariazioniRegoleMonitoraggioResponse searchVariazioniRegole(
      VariazioniRegoleMonitoraggioSearchRequest query);
}
