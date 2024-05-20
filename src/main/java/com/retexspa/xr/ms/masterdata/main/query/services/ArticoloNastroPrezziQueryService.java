package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.ArticoloNastroPrezziFilter;
import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoloNastroPrezziResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloNastroPrezziQueryEntity;
import org.springframework.data.domain.Page;

public interface ArticoloNastroPrezziQueryService {
  Page<ArticoloNastroPrezziQueryEntity> searchQueryArticoloNastroPrezzi(
          GenericSearchRequest<ArticoloNastroPrezziFilter> query);

  ArticoloNastroPrezziResponse searchArticoloNastroPrezzi(GenericSearchRequest<ArticoloNastroPrezziFilter> query);
}
