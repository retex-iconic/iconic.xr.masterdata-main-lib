package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloInfoServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.ArticoloInfoServizioByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoloInfoServizioResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.ArticoloInfoServizioSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloInfoServizioQueryEntity;
import org.springframework.data.domain.Page;

public interface ArticoloInfoServizioQueryService {

  Page<ArticoloInfoServizioQueryEntity> searchQueryArticoloInfoServizio(
      ArticoloInfoServizioSearchRequest query);

  ArticoloInfoServizioResponse searchArticoloInfoServizio(ArticoloInfoServizioSearchRequest query);

  ArticoloInfoServizioQueryDTO getArticoloInfoServizioById(ArticoloInfoServizioByIdQuery query);
}
