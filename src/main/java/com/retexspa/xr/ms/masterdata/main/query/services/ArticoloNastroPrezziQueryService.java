package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoloNastroPrezziResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.ArticoloNastroPrezziSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloNastroPrezziQueryEntity;
import org.springframework.data.domain.Page;

public interface ArticoloNastroPrezziQueryService {
  Page<ArticoloNastroPrezziQueryEntity> searchQueryArticoloNastroPrezzi(
      ArticoloNastroPrezziSearchRequest query);

  ArticoloNastroPrezziResponse searchArticoloNastroPrezzi(ArticoloNastroPrezziSearchRequest query);
}
