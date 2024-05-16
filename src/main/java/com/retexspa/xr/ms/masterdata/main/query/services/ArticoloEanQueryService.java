package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.ArticoloEanFilter;
import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoloEanResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloEanQueryEntity;
import org.springframework.data.domain.Page;

public interface ArticoloEanQueryService {
  Page<ArticoloEanQueryEntity> searchQueryArticoloEan(GenericSearchRequest<ArticoloEanFilter>  query);

  ArticoloEanResponse searchArticoloEan(GenericSearchRequest<ArticoloEanFilter> query);
}
