package com.retexspa.xr.ms.masterdata.main.core.dto.tassonomia;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipoTassonomiaBaseDTO extends BaseDTO {

  // private Integer livello;
  private String nodoId;

  @EnumValidator(enumClazz = Enums.GruppoTassonomia.class, message = "gruppoTassonomia not valid")
  @NotNull(message = "Gruppo Tassonomia is mandatory")
  @NotEmpty(message = "Gruppo Tassonomia is mandatory")
  @NotBlank(message = "Gruppo Tassonomia is mandatory")
  private String gruppoTassonomia;

  private String flgNonCancellabile;

  public String getGruppoTassonomia() {
    return gruppoTassonomia;
  }

  public void setGruppoTassonomia(String gruppo_tassonomia) {
    this.gruppoTassonomia = gruppo_tassonomia;
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

  public String getFlgNonCancellabile() {
    return this.flgNonCancellabile;
  }

  public void setFlgNonCancellabile(String flgNonCancellabile) {
    this.flgNonCancellabile = flgNonCancellabile;
  }

  public static String getName() { return "TipoTassonomia"; }

  public static String getNameNodo() {
    return "TipoTassonomiaNodo";
  }

  public static String getAggregateName() {
    return "TipoTassonomiaAggregate";
  }
}
