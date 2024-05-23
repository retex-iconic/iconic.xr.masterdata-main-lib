package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ArticoloInfoServizioBaseDTO {

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "FlgCancellato not valid")
  private String flgCancellato;

  @NotNull(message = "articoloId is mandatory")
  @NotEmpty(message = "articoloId is mandatory")
  @NotBlank(message = "articoloId is mandatory")
  private String articoloId;

  @NotNull(message = "servizioId is mandatory")
  @NotEmpty(message = "servizioId is mandatory")
  @NotBlank(message = "servizioId is mandatory")
  private String servizioId;

  @NotNull(message = "gerarchiaId is mandatory")
  @NotEmpty(message = "gerarchiaId is mandatory")
  @NotBlank(message = "gerarchiaId is mandatory")
  private String gerarchiaId;

  public String getArticoloId() {
    return articoloId;
  }

  public void setArticoloId(String articoloVenditaId) {
    this.articoloId = articoloVenditaId;
  }

  public String getServizioId() {
    return servizioId;
  }

  public void setServizioId(String servizioId) {
    this.servizioId = servizioId;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    // this.flgCancellato = flgCancellato;
    this.flgCancellato = flgCancellato;
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }

  public static String getDetailNameArticoloInfoServizio() {
    return "ArticoloInfoServizio";
  }

  public static String getDetailNameArticoloInfoServizioAggregate() {
    return "ArticoloInfoServizioAggregate";
  }
}
