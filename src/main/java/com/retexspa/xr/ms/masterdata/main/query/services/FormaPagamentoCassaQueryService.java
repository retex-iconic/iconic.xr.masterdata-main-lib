package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.entities.FormaPagamentoCassaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.FormaPagamentoCassaByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.FormaPagamentoCassaResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.FormaPagamentoCassaSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.FormaPagamentoCassaQueryEntity;
import org.springframework.data.domain.Page;

public interface FormaPagamentoCassaQueryService {
  FormaPagamentoCassaQueryDTO getFormaPagamentoCassaById(FormaPagamentoCassaByIdQuery query);

  Page<FormaPagamentoCassaQueryEntity> searchQueryFormaPagamentoCassa(
      FormaPagamentoCassaSearchRequest query);

  FormaPagamentoCassaResponse searchFormaPagamentoCassa(FormaPagamentoCassaSearchRequest query);
}
