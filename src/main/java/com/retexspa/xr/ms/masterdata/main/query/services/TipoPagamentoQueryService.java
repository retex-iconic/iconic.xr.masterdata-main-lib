package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.entities.TipoPagamentoQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.TipoPagamentoByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.TipoPagamentoResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.TipoPagamentoSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.TipoPagamentoQueryEntity;
import org.springframework.data.domain.Page;

public interface TipoPagamentoQueryService {
  TipoPagamentoQueryDTO getTipoPagamentoById(TipoPagamentoByIdQuery query);

  Page<TipoPagamentoQueryEntity> searchQueryTipoPagamento(TipoPagamentoSearchRequest query);

  TipoPagamentoResponse searchTipoPagamento(TipoPagamentoSearchRequest query);
}
