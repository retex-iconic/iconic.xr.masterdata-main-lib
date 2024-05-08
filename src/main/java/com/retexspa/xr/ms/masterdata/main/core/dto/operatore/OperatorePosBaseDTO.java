package com.retexspa.xr.ms.masterdata.main.core.dto.operatore;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OperatorePosBaseDTO { // extends BaseDTO

  // private String codOperatore;

  @NotNull(message = "codice is mandatory")
  @NotEmpty(message = "codice is mandatory")
  @NotBlank(message = "codice is mandatory")
  private String codice;

  @NotNull(message = "nome is mandatory")
  private String nome;

  private String cognome;

  private String mnemonic;

  private String password;

  private String padreId;

  @NotNull(message = "gerarchiaId is mandatory")
  @NotEmpty(message = "gerarchiaId is mandatory")
  @NotBlank(message = "gerarchiaId is mandatory")
  private String gerarchiaId;

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "FlgCancellato not valid")
  private String flgCancellato;

  public String getMnemonic() {
    return this.mnemonic;
  }

  public void setMnemonic(String mnemonic) {
    this.mnemonic = mnemonic;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public String getPadreId() {
    return padreId;
  }

  public void setPadreId(String padreId) {
    this.padreId = padreId;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = (flgCancellato == null ? "N" : flgCancellato);
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }
}
