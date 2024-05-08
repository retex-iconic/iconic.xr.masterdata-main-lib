package com.retexspa.xr.ms.masterdata.main.core.dto.servizi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.AggregateIndexGerarchiaBaseDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EsclusioniFpServizioIndexGerarchiaDTO extends AggregateIndexGerarchiaBaseDTO {

  private String servizioId;
  private String formaPagamentoId;

  public EsclusioniFpServizioIndexGerarchiaDTO() {}

  public EsclusioniFpServizioIndexGerarchiaDTO(String gerarchiaId) {
    super(gerarchiaId);
  }

  public String getServizioId() {
    return servizioId;
  }

  public void setServizioId(String servizioId) {
    this.servizioId = servizioId;
  }

  public String getFormaPagamentoId() {
    return formaPagamentoId;
  }

  public void setFormaPagamentoId(String formaPagamentoId) {
    this.formaPagamentoId = formaPagamentoId;
  }

  public static String getUk(EsclusioniFpServizioBaseDTO escl) {

    String uk =
        escl.getServizioId()
            + EsclusioniFpServizioIndexGerarchiaDTO.getUkSeparator()
            + escl.getFormaPagamentoId();
    return uk;
  }
}
