package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoloEanResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.ArticoloEanSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloEanQueryEntity;
import org.springframework.data.domain.Page;

public interface ArticoloEanQueryService {
  Page<ArticoloEanQueryEntity> searchQueryArticoloEan(ArticoloEanSearchRequest query);

  ArticoloEanResponse searchArticoloEan(ArticoloEanSearchRequest query);
}
