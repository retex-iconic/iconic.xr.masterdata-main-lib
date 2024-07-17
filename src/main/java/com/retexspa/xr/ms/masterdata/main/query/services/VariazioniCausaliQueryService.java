package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.responses.VariazioniCausaliResponse;
import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.VariazioniCausaliFilter;
import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniCausaliQueryEntity;
import org.springframework.data.domain.Page;

public interface VariazioniCausaliQueryService {
  Page<VariazioniCausaliQueryEntity> searchQueryVariazioniCausali(GenericSearchRequest<VariazioniCausaliFilter> query);

  VariazioniCausaliResponse searchVariazioniCausali(GenericSearchRequest<VariazioniCausaliFilter> query);
}
