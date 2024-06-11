package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.entities.FornitoreQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.FornitoreByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.FornitoreListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.FornitoriResponse;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.FornitoreFilter;
import com.retexspa.xr.ms.masterdata.main.query.entities.FornitoreQueryEntity;
import org.springframework.data.domain.Page;

public interface FornitoreQueryService {
  FornitoriResponse listFornitore(FornitoreListQuery query);

  Page<FornitoreQueryEntity> searchQueryFornitore(GenericSearchRequest<FornitoreFilter> query);

  FornitoriResponse searchFornitore(GenericSearchRequest<FornitoreFilter> query);

  FornitoreQueryDTO getFornitoreById(FornitoreByIdQuery query);
}
