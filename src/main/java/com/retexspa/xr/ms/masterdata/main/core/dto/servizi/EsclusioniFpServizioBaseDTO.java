package com.retexspa.xr.ms.masterdata.main.core.dto.servizi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class EsclusioniFpServizioBaseDTO {
  private String codice;

  @NotNull(message = "gerarchiaId is mandatory")
  @NotEmpty(message = "gerarchiaId is mandatory")
  @NotBlank(message = "gerarchiaId is mandatory")
  private String gerarchiaId;

  @NotNull(message = "servizioId is mandatory")
  private String servizioId;

  @NotNull(message = "formaPagamentoId is mandatory")
  private String formaPagamentoId;

  @NotNull(message = "massimaleSingolo is mandatory")
  private Double massimaleSingolo;

  @NotNull(message = "massimaleCumulativo is mandatory")
  private Double massimaleCumulativo;

  private String flgSegnalazione;
  private String descSegnalazione;

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }

  public static String getName() {
    return "EsclusioniFpServizio";
  }

  public static String getAggregateName() {
    return "EsclusioniFpServizioAggregate";
  }
}
