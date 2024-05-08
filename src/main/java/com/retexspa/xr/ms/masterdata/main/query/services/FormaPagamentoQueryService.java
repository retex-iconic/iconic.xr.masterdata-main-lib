package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.entities.FormaPagamentoQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.FormaPagamentoByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.FormaPagamentoResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.FormaPagamentoSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.FormaPagamentoQueryEntity;
import org.springframework.data.domain.Page;

public interface FormaPagamentoQueryService {
  FormaPagamentoQueryDTO getFormaPagamentoById(FormaPagamentoByIdQuery query);

  Page<FormaPagamentoQueryEntity> searchQueryFormaPagamento(FormaPagamentoSearchRequest query);

  FormaPagamentoResponse searchFormaPagamento(FormaPagamentoSearchRequest query);
}
