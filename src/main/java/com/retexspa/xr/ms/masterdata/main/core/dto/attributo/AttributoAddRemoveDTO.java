package com.retexspa.xr.ms.masterdata.main.core.dto.attributo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AttributoAddRemoveDTO {

  @NotNull(message = "attributi is mandatory")
  @NotEmpty(message = "attributi is mandatory")
  @NotBlank(message = "attributi is mandatory")
  private List<AttributoValoreDTO> attributi;

  @NotNull(message = "event is mandatory")
  @NotEmpty(message = "event is mandatory")
  @NotBlank(message = "event is mandatory")
  private String event;

  public AttributoAddRemoveDTO() {}

  public AttributoAddRemoveDTO(
      @NotNull(message = "attributi is mandatory")
          @NotEmpty(message = "attributi is mandatory")
          @NotBlank(message = "attributi is mandatory")
          List<AttributoValoreDTO> attributi,
      @NotNull(message = "event is mandatory")
          @NotEmpty(message = "event is mandatory")
          @NotBlank(message = "event is mandatory")
          String event) {
    this.attributi = attributi;
    this.event = event;
  }

  public List<AttributoValoreDTO> getAttributi() {
    return attributi;
  }

  public void setAttributi(List<AttributoValoreDTO> attributi) {
    this.attributi = attributi;
  }

  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }
}
