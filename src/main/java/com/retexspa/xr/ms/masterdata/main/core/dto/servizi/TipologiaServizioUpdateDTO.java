package com.retexspa.xr.ms.masterdata.main.core.dto.servizi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TipologiaServizioUpdateDTO {
  private String nome;
  private String descrizione;
  private Integer numMaxInScontrino;
  private Double valMaxInScontrino;

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

  public Integer getNumMaxInScontrino() {
    return numMaxInScontrino;
  }

  public void setNumMaxInScontrino(Integer numMaxInScontrino) {
    this.numMaxInScontrino = numMaxInScontrino;
  }

  public Double getValMaxInScontrino() {
    return valMaxInScontrino;
  }

  public void setValMaxInScontrino(Double valMaxInScontrino) {
    this.valMaxInScontrino = valMaxInScontrino;
  }
}
