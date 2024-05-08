package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.entities.AnagraficaServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.AnagraficaServizioByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.AnagraficaServizioListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.AnagraficaServizioResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.AnagraficaServizioSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.AnagraficaServizioQueryEntity;
import org.springframework.data.domain.Page;

public interface AnagraficaServizioQueryService {
  AnagraficaServizioResponse listAnagraficaServizio(AnagraficaServizioListQuery query);

  AnagraficaServizioResponse searchAnagraficaServizio(AnagraficaServizioSearchRequest query);

  Page<AnagraficaServizioQueryEntity> searchQueryAnagraficaServizio(
      AnagraficaServizioSearchRequest query);

  AnagraficaServizioQueryDTO getAnagraficaServizioById(AnagraficaServizioByIdQuery query);
}
