package com.retexspa.xr.ms.masterdata.main.core.dto.pagamento;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FormaPagamentoCassaBaseDTO {
  @NotNull(message = "xx1mty is mandatory")
  private Integer xx1mty;

  @NotNull(message = "xx1mnr is mandatory")
  private Integer xx1mnr;

  @NotNull(message = "formaPagamentoId is mandatory")
  private String formaPagamentoId;

  @NotNull(message = "gerarchiaId is mandatory")
  @NotEmpty(message = "gerarchiaId is mandatory")
  @NotBlank(message = "gerarchiaId is mandatory")
  private String gerarchiaId;

  private String codice;

  public Integer getXx1mty() {
    return xx1mty;
  }

  public void setXx1mty(Integer xx1mty) {
    this.xx1mty = xx1mty;
  }

  public Integer getXx1mnr() {
    return xx1mnr;
  }

  public void setXx1mnr(Integer xx1mnr) {
    this.xx1mnr = xx1mnr;
  }

  public String getFormaPagamentoId() {
    return formaPagamentoId;
  }

  public void setFormaPagamentoId(String formaPagamentoId) {
    this.formaPagamentoId = formaPagamentoId;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }
}
