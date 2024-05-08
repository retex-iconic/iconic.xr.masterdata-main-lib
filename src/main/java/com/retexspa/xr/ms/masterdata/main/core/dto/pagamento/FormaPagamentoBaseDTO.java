package com.retexspa.xr.ms.masterdata.main.core.dto.pagamento;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FormaPagamentoBaseDTO extends BaseDTO {

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "flgAttivo not valid")
  private String flgAttivo;

  private String tipoPagamentoId;

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }

  public String getFlgAttivo() {
    return flgAttivo;
  }

  public void setFlgAttivo(String flgAttivo) {
    this.flgAttivo = flgAttivo;
  }

  public String getTipoPagamentoId() {
    return tipoPagamentoId;
  }

  public void setTipoPagamentoId(String tipoPagamentoId) {
    this.tipoPagamentoId = tipoPagamentoId;
  }
}
