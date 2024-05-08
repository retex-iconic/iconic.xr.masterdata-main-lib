package com.retexspa.xr.ms.masterdata.main.query.services;

import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

@Service
public class ArticoloAcquistoQueryServiceImpl implements ArticoloAcquistoQueryService {

  private final QueryGateway queryGateway;

  public ArticoloAcquistoQueryServiceImpl(QueryGateway queryGateway) {
    this.queryGateway = queryGateway;
  }
}
