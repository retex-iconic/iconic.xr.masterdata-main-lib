package com.retexspa.xr.ms.masterdata.main.core.dto.pagamento;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipoPagamentoIndexDTO {
  private String tipoPagamentoId;
  private LinkedList<String> formaPagamentoIds;
  private LinkedList<String> figliIds;

  public TipoPagamentoIndexDTO() {}

  public TipoPagamentoIndexDTO(String tipoPagamentoId) {
    this.tipoPagamentoId = tipoPagamentoId;
  }

  public String getTipoPagamentoId() {
    return tipoPagamentoId;
  }

  public void setTipoPagamentoId(String tipoPagamentoId) {
    this.tipoPagamentoId = tipoPagamentoId;
  }

  public static String getIdFromTipoPagamento(String tipoPagamentoId) {
    return UUID.nameUUIDFromBytes(("/TipoPagamentoIndex/" + tipoPagamentoId).getBytes()).toString();
  }

  public LinkedList<String> getFormaPagamentoIds() {
    return formaPagamentoIds;
  }

  public void setFormaPagamentoIds(LinkedList<String> formaPagamentoIds) {
    this.formaPagamentoIds = formaPagamentoIds;
  }

  public LinkedList<String> getFigliIds() {
    return figliIds;
  }

  public void setFigliIds(LinkedList<String> figliIds) {
    this.figliIds = figliIds;
  }
}
