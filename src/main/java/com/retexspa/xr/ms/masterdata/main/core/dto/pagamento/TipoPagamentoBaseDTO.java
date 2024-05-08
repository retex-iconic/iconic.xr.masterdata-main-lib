package com.retexspa.xr.ms.masterdata.main.core.dto.pagamento;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;

import java.util.UUID;
import javax.validation.constraints.*;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TipoPagamentoBaseDTO extends BaseDTO {

  @Size(min = 1, max = 1, message = "Field must have exactly 1 character")
  @Pattern(regexp = ".", message = "Field must have exactly 1 character")
  private String indicatoreFts;

  @JsonIgnore
  public String getAggregateId() {
    // return UUID.nameUUIDFromBytes(("/TipoPagamento/" + this.getCodice()).getBytes()).toString();
    return UUID.randomUUID().toString();
  }

  public String getIndicatoreFts() {
    return indicatoreFts;
  }

  public void setIndicatoreFts(String indicatoreFts) {
    this.indicatoreFts = indicatoreFts;
  }
}
