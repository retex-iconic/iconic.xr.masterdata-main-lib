package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.ArticoloFilter;
import com.retexspa.xr.ms.masterdata.main.core.queries.ArticoliByGerarchiaIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.ArticoloListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoliResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloQueryEntity;
import org.springframework.data.domain.Page;

public interface ArticoloQueryService {
  ArticoliResponse listArticolo(ArticoloListQuery query);

  ArticoliResponse searchArticolo(GenericSearchRequest<ArticoloFilter>  query);

  ArticoliResponse getArticoliByGerarchiaId(ArticoliByGerarchiaIdQuery query);

  Page<ArticoloQueryEntity> searchQueryArticolo(GenericSearchRequest<ArticoloFilter> query);
}
