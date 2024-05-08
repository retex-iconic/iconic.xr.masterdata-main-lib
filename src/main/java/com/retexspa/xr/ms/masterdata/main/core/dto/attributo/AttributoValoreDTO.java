package com.retexspa.xr.ms.masterdata.main.core.dto.attributo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AttributoValoreDTO {

  @NotNull(message = "attributoId is mandatory")
  @NotEmpty(message = "attributoId is mandatory")
  @NotBlank(message = "attributoId is mandatory")
  private String attributoId;

  private String valore;

  public String getAttributoId() {
    return attributoId;
  }

  public void setAttributoId(String attributoId) {
    this.attributoId = attributoId;
  }

  public String getValore() {
    return valore;
  }

  public void setValore(String valore) {
    this.valore = valore.toUpperCase();
  }
}
