package com.retexspa.xr.ms.masterdata.main.query.services;

import com.retexspa.xr.ms.masterdata.main.core.entities.OperatorePosQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.queries.OperatorePosByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.OperatorePosResponse;
import com.retexspa.xr.ms.masterdata.main.core.searchRequest.OperatorePosSearchRequest;
import com.retexspa.xr.ms.masterdata.main.query.entities.OperatorePOSQueryEntity;
import org.springframework.data.domain.Page;

public interface OperatorePosQueryService {

  OperatorePosQueryDTO getOperatorePosById(OperatorePosByIdQuery query);

  Page<OperatorePOSQueryEntity> searchQueryOperatorePos(OperatorePosSearchRequest query);

  OperatorePosResponse searchOperatorePos(OperatorePosSearchRequest query);
}
