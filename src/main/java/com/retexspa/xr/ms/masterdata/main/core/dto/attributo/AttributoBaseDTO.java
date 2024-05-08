package com.retexspa.xr.ms.masterdata.main.core.dto.attributo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AttributoBaseDTO {

  @NotNull(message = "chiave is mandatory")
  @NotEmpty(message = "chiave is mandatory")
  @NotBlank(message = "chiave is mandatory")
  private String chiave;
  @NotNull(message = "descrizione is mandatory")
  @NotEmpty(message = "descrizione is mandatory")
  @NotBlank(message = "descrizione is mandatory")
  private String descrizione;
  @NotNull(message = "aggregato is mandatory")
  @NotEmpty(message = "aggregato is mandatory")
  @NotBlank(message = "aggregato is mandatory")
  private String aggregato;

  private List<String> checkValue;


  public String getChiave() {
    return chiave;
  }

  public void setChiave(String chiave) {
    this.chiave = chiave.toUpperCase();
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getAggregato() {
    return aggregato;
  }

  public void setAggregato(String aggregato) {
    this.aggregato = aggregato;
  }

  public List<String> getCheckValue() {
    return checkValue;
  }

  public void setCheckValue(List<String> checkValue) {
    checkValue.replaceAll(String::toUpperCase);
    this.checkValue = checkValue;
  }

  @JsonIgnore
  public String getCheckValueSeparator() {
    return "/#/";
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }
}
