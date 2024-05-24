package com.retexspa.xr.ms.masterdata.main.core.dto.variazioniRegoleMonitoraggio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.dto.BaseDTO;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;
import java.util.UUID;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class VariazioniRegoleMonitoraggioBaseDTO extends BaseDTO {

  @NotNull(message = "schema is mandatory")
  private String schema;

  @NotNull(message = "nomeTabella is mandatory")
  private String nomeTabella;

  @NotNull(message = "nomeCampo is mandatory")
  private String nomeCampo;

  private String regolaConfronto;
  private String variazioniCausaliId;

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flag Salva not valid")
  private String flgSalva;

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flag Salva Cancellazione not valid")
  private String flgSalvaCancellazione;

  @EnumValidator(enumClazz = Enums.CheckSN.class, message = "Flag Attivo not valid")
  private String flgAttiva;

  public String getSchema() {
    return schema;
  }

  public void setSchema(String schema) {
    this.schema = schema;
  }

  public String getNomeTabella() {
    return nomeTabella;
  }

  public void setNomeTabella(String nomeTabella) {
    this.nomeTabella = nomeTabella;
  }

  public String getNomeCampo() {
    return nomeCampo;
  }

  public void setNomeCampo(String nomeCampo) {
    this.nomeCampo = nomeCampo;
  }

  public String getRegolaConfronto() {
    return regolaConfronto;
  }

  public void setRegolaConfronto(String regolaConfronto) {
    this.regolaConfronto = regolaConfronto;
  }

  public String getVariazioniCausaliId() {
    return variazioniCausaliId;
  }

  public void setVariazioniCausaliId(String variazioniCausaliId) {
    this.variazioniCausaliId = variazioniCausaliId;
  }

  public String getFlgSalva() {
    return flgSalva;
  }

  public void setFlgSalva(String flgSalva) {
    this.flgSalva = flgSalva;
  }

  public String getFlgSalvaCancellazione() {
    return flgSalvaCancellazione;
  }

  public void setFlgSalvaCancellazione(String flgSalvaCancellazione) {
    this.flgSalvaCancellazione = flgSalvaCancellazione;
  }

  public String getFlgAttiva() {
    return flgAttiva;
  }

  public void setFlgAttiva(String flgAttiva) {
    this.flgAttiva = (flgAttiva == null ? "S" : flgAttiva);
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }

  public static String getName() {
    return "VariazioniRegoleMonitoraggio";
  }

  public static String getAggregateName() {
    return "VariazioniRegoleMonitoraggioAggregate";
  }
}
