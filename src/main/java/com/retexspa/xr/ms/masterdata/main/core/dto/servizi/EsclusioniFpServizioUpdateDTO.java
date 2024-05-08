package com.retexspa.xr.ms.masterdata.main.core.dto.servizi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EsclusioniFpServizioUpdateDTO {

  private Double massimaleSingolo;
  private Double massimaleCumulativo;
  private String flgSegnalazione;
  private String descSegnalazione;

  public Double getMassimaleSingolo() {
    return massimaleSingolo;
  }

  public void setMassimaleSingolo(Double massimaleSingolo) {
    this.massimaleSingolo = massimaleSingolo;
  }

  public Double getMassimaleCumulativo() {
    return massimaleCumulativo;
  }

  public void setMassimaleCumulativo(Double massimaleCumulativo) {
    this.massimaleCumulativo = massimaleCumulativo;
  }

  public String getFlgSegnalazione() {
    return flgSegnalazione;
  }

  public void setFlgSegnalazione(String flgSegnalazione) {
    this.flgSegnalazione = flgSegnalazione;
  }

  public String getDescSegnalazione() {
    return descSegnalazione;
  }

  public void setDescSegnalazione(String descSegnalazione) {
    this.descSegnalazione = descSegnalazione;
  }
}
