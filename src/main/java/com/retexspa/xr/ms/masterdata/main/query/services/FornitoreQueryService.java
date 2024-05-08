package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.entities.FornitoreQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.FornitoreByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.FornitoreListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.FornitoriResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.FornitoreSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.FornitoreQueryEntity;
import org.springframework.data.domain.Page;

public interface FornitoreQueryService {
  FornitoriResponse listFornitore(FornitoreListQuery query);

  Page<FornitoreQueryEntity> searchQueryFornitore(FornitoreSearchRequest query);

  FornitoriResponse searchFornitore(FornitoreSearchRequest query);

  FornitoreQueryDTO getFornitoreById(FornitoreByIdQuery query);
}
