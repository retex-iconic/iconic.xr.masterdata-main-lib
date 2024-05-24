package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ArticoloTassonomiaBaseDTO {

  @NotNull(message = "articoloId is mandatory")
  @NotEmpty(message = "articoloId is mandatory")
  @NotBlank(message = "articoloId is mandatory")
  private String articoloId;

  @NotNull(message = "gerarchiaId is mandatory")
  @NotEmpty(message = "gerarchiaId is mandatory")
  @NotBlank(message = "gerarchiaId is mandatory")
  private String gerarchiaId;

  @NotNull(message = "tassonomiaId is mandatory")
  @NotEmpty(message = "tassonomiaId is mandatory")
  @NotBlank(message = "tassonomiaId is mandatory")
  private String tassonomiaId;

  public String getArticoloId() {
    return articoloId;
  }

  public void setArticoloId(String articoloVenditaId) {
    this.articoloId = articoloVenditaId;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getTassonomiaId() {
    return tassonomiaId;
  }

  public void setTassonomiaId(String tassonomiaId) {
    this.tassonomiaId = tassonomiaId;
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }

  public static String getName() {
    return "ArticoloTassonomia";
  }

  public static String getAggregateName() {
    return "ArticoloTassonomiaAggregate";
  }
}
