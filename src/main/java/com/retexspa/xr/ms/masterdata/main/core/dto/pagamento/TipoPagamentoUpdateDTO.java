package com.retexspa.xr.ms.masterdata.main.core.dto.pagamento;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TipoPagamentoUpdateDTO {

  @NotNull(message = "nome is mandatory")
  private String nome;

  @NotNull(message = "descrizione is mandatory")
  private String descrizione;

  @Size(min = 1, max = 1, message = "Field must have exactly 1 character")
  @Pattern(regexp = ".", message = "Field must have exactly 1 character")
  private String indicatoreFts;

  public String getIndicatoreFts() {
    return this.indicatoreFts;
  }

  public void setIndicatoreFts(String indicatoreFts) {
    this.indicatoreFts = indicatoreFts;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescrizione() {
    return this.descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }
}
