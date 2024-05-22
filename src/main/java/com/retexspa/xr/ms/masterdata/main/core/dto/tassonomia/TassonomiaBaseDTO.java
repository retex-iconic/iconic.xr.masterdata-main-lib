package com.retexspa.xr.ms.masterdata.main.core.dto.tassonomia;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TassonomiaBaseDTO extends BaseDTO {

  @NotNull(message = "Tipo Tassonomia is mandatory")
  @NotEmpty(message = "Tipo Tassonomia is mandatory")
  @NotBlank(message = "Tipo Tassonomia is mandatory")
  private String tipoTassonomiaId;

  private String nodoId;

  public String getTipoTassonomiaId() {
    return tipoTassonomiaId;
  }

  public void setTipoTassonomiaId(String tipoTassonomiaId) {
    this.tipoTassonomiaId = tipoTassonomiaId;
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }

  public String getNodoId() {
    return nodoId;
  }

  public void setNodoId(String nodoId) {
    this.nodoId = nodoId;
  }

  public static String getDetailNameTassonomia() { return "Tassonomia"; }

  public static String getDetailNameTassonomiaNodo() {
    return "TassonomiaNodo";
  }

  public static String getDetailNameTassonomiaAggregate() {
    return "TassonomiaAggregate";
  }
}
