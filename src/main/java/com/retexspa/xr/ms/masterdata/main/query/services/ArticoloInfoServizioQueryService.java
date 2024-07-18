package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloInfoServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.ArticoloInfoServizioFilter;
import com.retexspa.xr.ms.masterdata.main.core.queries.ArticoloInfoServizioByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoloInfoServizioResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloInfoServizioQueryEntity;
import org.springframework.data.domain.Page;

public interface ArticoloInfoServizioQueryService {

  Page<ArticoloInfoServizioQueryEntity> searchQueryArticoloInfoServizio(
          GenericSearchRequest<ArticoloInfoServizioFilter> query);

  ArticoloInfoServizioResponse searchArticoloInfoServizio(GenericSearchRequest <ArticoloInfoServizioFilter> query);

  ArticoloInfoServizioQueryDTO getArticoloInfoServizioById(ArticoloInfoServizioByIdQuery query);
}
