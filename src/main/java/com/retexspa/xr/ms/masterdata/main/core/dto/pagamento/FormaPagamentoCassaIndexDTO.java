package com.retexspa.xr.ms.masterdata.main.core.dto.pagamento;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormaPagamentoCassaIndexDTO {
  private String formaPagamentoCassaId;

  public FormaPagamentoCassaIndexDTO() {}

  public FormaPagamentoCassaIndexDTO(String formaPagamentoId) {
    this.formaPagamentoCassaId = formaPagamentoId;
  }

  public String getFormaPagamentoCassaId() {
    return formaPagamentoCassaId;
  }

  public void setFormaPagamentoCassaId(String formaPagamentoCassaId) {
    this.formaPagamentoCassaId = formaPagamentoCassaId;
  }

  public static String getIdFromFormaPagamentoCassa(String formaPagamentoCassaId) {
    return UUID.nameUUIDFromBytes(("/FormaPagamentoCassaIndex/" + formaPagamentoCassaId).getBytes())
        .toString();
  }
}
