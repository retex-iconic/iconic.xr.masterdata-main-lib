package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.queries.ArticoliByGerarchiaIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.ArticoloListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoliResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.ArticoloSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloQueryEntity;
import org.springframework.data.domain.Page;

public interface ArticoloQueryService {
  ArticoliResponse listArticolo(ArticoloListQuery query);

  ArticoliResponse searchArticolo(ArticoloSearchRequest query);

  ArticoliResponse getArticoliByGerarchiaId(ArticoliByGerarchiaIdQuery query);

  Page<ArticoloQueryEntity> searchQueryArticolo(ArticoloSearchRequest query);
}
