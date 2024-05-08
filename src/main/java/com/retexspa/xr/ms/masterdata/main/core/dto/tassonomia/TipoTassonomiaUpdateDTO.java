package com.retexspa.xr.ms.masterdata.main.core.dto.tassonomia;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TipoTassonomiaUpdateDTO {

  public enum GruppoTassonomia {
    NEGOZIO,
    ARTICOLO,
    FORNITORE;
  }

  private String nome;

  private String descrizione;

  @EnumValidator(enumClazz = GruppoTassonomia.class, message = "gruppoTassonomia not valid")
  private String gruppoTassonomia;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getGruppoTassonomia() {
    return gruppoTassonomia;
  }

  public void setGruppoTassonomia(String gruppoTassonomia) {
    this.gruppoTassonomia = gruppoTassonomia;
  }
}
