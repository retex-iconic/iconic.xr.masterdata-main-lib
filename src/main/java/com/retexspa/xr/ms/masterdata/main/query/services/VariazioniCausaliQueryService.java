package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.responses.VariazioniCausaliResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.VariazioniCausaliSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniCausaliQueryEntity;
import org.springframework.data.domain.Page;

public interface VariazioniCausaliQueryService {
  Page<VariazioniCausaliQueryEntity> searchQueryVariazioniCausali(
      VariazioniCausaliSearchRequest query);

  VariazioniCausaliResponse searchVariazioniCausali(VariazioniCausaliSearchRequest query);
}
