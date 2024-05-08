package com.retexspa.xr.ms.masterdata.main.core.dto.pagamento;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormaPagamentoCassaIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public FormaPagamentoCassaIndexGerarchiaDTO() {}

  public FormaPagamentoCassaIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }
}
