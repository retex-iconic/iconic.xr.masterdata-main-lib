package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.entities.AnagraficaServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.AnagraficaServizioByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.AnagraficaServizioListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.AnagraficaServizioResponse;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.AnagraficaServizioFilter;
import com.retexspa.xr.ms.masterdata.main.query.entities.AnagraficaServizioQueryEntity;
import org.springframework.data.domain.Page;

public interface AnagraficaServizioQueryService {
  AnagraficaServizioResponse listAnagraficaServizio(AnagraficaServizioListQuery query);

  AnagraficaServizioResponse searchAnagraficaServizio(GenericSearchRequest<AnagraficaServizioFilter> query);

  Page<AnagraficaServizioQueryEntity> searchQueryAnagraficaServizio(
    GenericSearchRequest<AnagraficaServizioFilter> query);

  AnagraficaServizioQueryDTO getAnagraficaServizioById(AnagraficaServizioByIdQuery query);
}
