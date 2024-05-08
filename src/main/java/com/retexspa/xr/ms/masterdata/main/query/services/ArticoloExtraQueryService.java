package com.retexspa.xr.ms.masterdata.main.query.services;


import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloExtraQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.ArticoloExtraByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.ArticoloExtraListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.ArticoliExtraResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.ArticoloExtraSearchRequest;

public interface ArticoloExtraQueryService {
  ArticoliExtraResponse listArticoloExtra(ArticoloExtraListQuery query);

  ArticoliExtraResponse searchArticoloExtra(ArticoloExtraSearchRequest query);

  ArticoloExtraQueryDTO getArticoloExtraById(ArticoloExtraByIdQuery query);
}
