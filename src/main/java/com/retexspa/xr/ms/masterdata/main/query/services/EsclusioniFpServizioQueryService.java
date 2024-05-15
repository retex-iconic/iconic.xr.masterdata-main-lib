package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.entities.EsclusioniFpServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.EsclusioniFpServizioAggregateGetByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.EsclusioniFpServizioListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.EsclusioniFpServizioResponse;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.EsclusioniFpServizioFilter;
import com.retexspa.xr.ms.masterdata.main.query.entities.EsclusioniFpServizioQueryEntity;
import org.springframework.data.domain.Page;

public interface EsclusioniFpServizioQueryService {
  EsclusioniFpServizioResponse listEsclusioniFpServizio(EsclusioniFpServizioListQuery query);

  EsclusioniFpServizioResponse searchEsclusioniFpServizio(GenericSearchRequest<EsclusioniFpServizioFilter> query);

  EsclusioniFpServizioQueryDTO getEsclusioniFpServizioById(
      EsclusioniFpServizioAggregateGetByIdQuery query);

  Page<EsclusioniFpServizioQueryEntity> searchQueryEsclusioniFpServizio(
      GenericSearchRequest<EsclusioniFpServizioFilter> query);
}
