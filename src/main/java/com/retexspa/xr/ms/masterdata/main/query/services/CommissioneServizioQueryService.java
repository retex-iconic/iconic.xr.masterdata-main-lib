package com.retexspa.xr.ms.masterdata.main.query.services;


import com.retexspa.xr.ms.main.core.queries.GenericSearchRequest;
import com.retexspa.xr.ms.masterdata.main.core.entities.CommissioneServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.filterRequest.CommissioneServizioFilter;
import com.retexspa.xr.ms.masterdata.main.core.queries.CommissioneServizioAggregateGetByIdQuery;
import com.retexspa.xr.ms.masterdata.main.core.queries.CommissioneServizioListQuery;
import com.retexspa.xr.ms.masterdata.main.core.responses.CommissioneServizioResponse;
import com.retexspa.xr.ms.masterdata.main.query.entities.CommissioneServizioQueryEntity;
import org.springframework.data.domain.Page;

public interface CommissioneServizioQueryService {

  Page<CommissioneServizioQueryEntity> searchQueryCommissioneServizio(GenericSearchRequest<CommissioneServizioFilter> query);
  CommissioneServizioResponse searchCommissioneServizio(GenericSearchRequest<CommissioneServizioFilter> query);
  CommissioneServizioResponse listCommissioneServizio(CommissioneServizioListQuery query);
  CommissioneServizioQueryDTO getCommissioneServizioById(CommissioneServizioAggregateGetByIdQuery query);
}
