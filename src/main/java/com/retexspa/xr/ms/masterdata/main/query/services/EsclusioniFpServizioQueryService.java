package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.entities.EsclusioniFpServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.EsclusioniFpServizioAggregateGetByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.EsclusioniFpServizioListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.EsclusioniFpServizioResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.EsclusioniFpServizioSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.EsclusioniFpServizioQueryEntity;
import org.springframework.data.domain.Page;

public interface EsclusioniFpServizioQueryService {
  EsclusioniFpServizioResponse listEsclusioniFpServizio(EsclusioniFpServizioListQuery query);

  EsclusioniFpServizioResponse searchEsclusioniFpServizio(EsclusioniFpServizioSearchRequest query);

  EsclusioniFpServizioQueryDTO getEsclusioniFpServizioById(
      EsclusioniFpServizioAggregateGetByIdQuery query);

  Page<EsclusioniFpServizioQueryEntity> searchQueryEsclusioniFpServizio(
      EsclusioniFpServizioSearchRequest query);
}
