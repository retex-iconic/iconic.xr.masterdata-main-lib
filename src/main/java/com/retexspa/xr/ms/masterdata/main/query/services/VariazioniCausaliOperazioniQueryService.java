package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.responses.VariazioniCausaliOperazioniResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.VariazioniCausaliOperazioniSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniCausaliOperazioniQueryEntity;
import org.springframework.data.domain.Page;

public interface VariazioniCausaliOperazioniQueryService {

  VariazioniCausaliOperazioniResponse searchVariazioniCausaliOperazioni(
      VariazioniCausaliOperazioniSearchRequest query);

  Page<VariazioniCausaliOperazioniQueryEntity> searchQueryVariazioniCausaliOperazioni(
      VariazioniCausaliOperazioniSearchRequest query);
}
