package com.retexspa.xr.ms.masterdata.main.core.dto.pagamento;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormaPagamentoIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  public FormaPagamentoIndexGerarchiaDTO() {}

  public FormaPagamentoIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public static String getUk(FormaPagamentoBaseDTO forma) {
    String uk = forma.getCodice();
    return uk;
  }
}
