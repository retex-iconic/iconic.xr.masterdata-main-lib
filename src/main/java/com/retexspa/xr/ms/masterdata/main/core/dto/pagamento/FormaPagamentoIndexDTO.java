package com.retexspa.xr.ms.masterdata.main.core.dto.pagamento;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.LinkedList;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormaPagamentoIndexDTO {
  private String formaPagamentoId;
  private LinkedList<String> formaPagamentoCassaIds;
  private LinkedList<String> esclusioniFPServizioIds;
  private LinkedList<String> figliIds;

  public FormaPagamentoIndexDTO() {
  }

  public FormaPagamentoIndexDTO(String formaPagamentoId) {
    this.formaPagamentoId = formaPagamentoId;
  }

  public String getFormaPagamentoId() {
    return formaPagamentoId;
  }

  public void setFormaPagamentoId(String formaPagamentoId) {
    this.formaPagamentoId = formaPagamentoId;
  }

  public static String getIdFromFormaPagamento(String formaPagamentoId) {
    return UUID.nameUUIDFromBytes(("/FormaPagamentoIndex/" + formaPagamentoId).getBytes())
        .toString();
  }

  public LinkedList<String> getFormaPagamentoCassaIds() {
    return formaPagamentoCassaIds;
  }

  public void setFormaPagamentoCassaIds(LinkedList<String> formaPagamentoCassaIds) {
    this.formaPagamentoCassaIds = formaPagamentoCassaIds;
  }

  public LinkedList<String> getEsclusioniFPServizioIds() {
    return esclusioniFPServizioIds;
  }

  public void setEsclusioniFPServizioIds(LinkedList<String> esclusioniFPServizioIds) {
    this.esclusioniFPServizioIds = esclusioniFPServizioIds;
  }

  public LinkedList<String> getFigliIds() {
    return figliIds;
  }

  public void setFigliIds(LinkedList<String> figliIds) {
    this.figliIds = figliIds;
  }

  public static String getDetailNameFormaPagamentoCassaIds() {
    return "formaPagamentoCassaIds";
  }

  public static String getDetailNameEsclusioniFPServizioIds() {
    return "esclusioniFPServizioIds";
  }

  public static String getDetailNameFigliIds() {
    return "figliIds";
  }

}
