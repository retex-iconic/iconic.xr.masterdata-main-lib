package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.queries.ArticoloVenditaListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoliVenditaResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.ArticoloVenditaSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloVenditaQueryEntity;
import org.springframework.data.domain.Page;

public interface ArticoloVenditaQueryService {
  ArticoliVenditaResponse listArticoloVendita(ArticoloVenditaListQuery query);

  Page<ArticoloVenditaQueryEntity> searchQueryArticoloVendita(ArticoloVenditaSearchRequest query);

  ArticoliVenditaResponse searchArticoloVendita(ArticoloVenditaSearchRequest query);

  // ArticoloVenditaQueryDTO getArticoloVenditaById(ArticoloVenditaByIdQuery query);
}
