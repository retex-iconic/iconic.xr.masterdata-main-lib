package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.entities.TipologiaServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.TipologiaServizioByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.TipologiaServizioListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.TipologiaServizioResponse;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.TipologiaServizioFilter;
import com.retexspa.xr.ms.masterdata.main.query.entities.TipologiaServizioQueryEntity;

import org.springframework.data.domain.Page;

public interface TipologiaServizioQueryService {
  TipologiaServizioResponse listTipologiaServizio(TipologiaServizioListQuery query);

  TipologiaServizioResponse searchTipologiaServizio(GenericSearchRequest<TipologiaServizioFilter>  query);

  Page<TipologiaServizioQueryEntity> searchQueryTipologiaServizio(
    GenericSearchRequest<TipologiaServizioFilter> query);

  TipologiaServizioQueryDTO getTipologiaServizioById(TipologiaServizioByIdQuery query);
}
