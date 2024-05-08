package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.entities.TipologiaServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.TipologiaServizioByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.TipologiaServizioListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.TipologiaServizioResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.TipologiaServizioSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.TipologiaServizioQueryEntity;
import org.springframework.data.domain.Page;

public interface TipologiaServizioQueryService {
  TipologiaServizioResponse listTipologiaServizio(TipologiaServizioListQuery query);

  TipologiaServizioResponse searchTipologiaServizio(TipologiaServizioSearchRequest query);

  Page<TipologiaServizioQueryEntity> searchQueryTipologiaServizio(
      TipologiaServizioSearchRequest query);

  TipologiaServizioQueryDTO getTipologiaServizioById(TipologiaServizioByIdQuery query);
}
