package com.retexspa.xr.ms.masterdata.main.core.dto.pagamento;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipoPagamentoIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public TipoPagamentoIndexGerarchiaDTO() {}

  public TipoPagamentoIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getUk(TipoPagamentoBaseDTO tipo) {
    String uk = tipo.getCodice();
    return uk;
  }
}
