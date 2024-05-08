package com.retexspa.xr.ms.masterdata.main.core.dto.masterDataConfig;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;
import com.retexspa.xr.ms.masterdata.main.core.dto.attributo.AttributoValoreDTO;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MasterDataConfigBaseDTO {

  @NotNull(message = "codice is mandatory")
  private String codice;

  @NotNull(message = "nome is mandatory")
  private String nome;

  @NotNull(message = "descrizione is mandatory")
  private String descrizione;

  private List<AttributoValoreDTO> attributi;

  private String flgAttivo;

  private String nodoId;

  private String contextId;

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "FlgCancellato not valid")
  private String flgCancellato;

  public String getCodice() {
    return this.codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
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

  public List<AttributoValoreDTO> getAttributi() {
    return this.attributi;
  }

  public void setAttributi(List<AttributoValoreDTO> attributi) {
    this.attributi = attributi;
  }

  public String getFlgAttivo() {
    return this.flgAttivo;
  }

  public void setFlgAttivo(String flgAttivo) {
    this.flgAttivo = flgAttivo;
  }

  public String getNodoId() {
    return this.nodoId;
  }

  public void setNodoId(String padreId) {
    this.nodoId = padreId;
  }

  public String getContextId() {
    return contextId;
  }

  public void setContextId(String contextId) {
    this.contextId = contextId;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }
}
