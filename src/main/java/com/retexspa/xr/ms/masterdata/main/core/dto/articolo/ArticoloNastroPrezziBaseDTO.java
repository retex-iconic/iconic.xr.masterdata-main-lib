package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ArticoloNastroPrezziBaseDTO {

  @NotNull(message = "articoloId is mandatory")
  @NotEmpty(message = "articoloId is mandatory")
  @NotBlank(message = "articoloId is mandatory")
  private String articoloId;

  @NotNull(message = "gerarchiaId is mandatory")
  @NotEmpty(message = "gerarchiaId is mandatory")
  @NotBlank(message = "gerarchiaId is mandatory")
  private String gerarchiaId;

  @NotNull(message = "prezzoVendita is mandatory")
  private Double prezzoVendita;

  @NotNull(message = "dataOraInizio is mandatory")
  private LocalDateTime dataOraInizio; // YYYYMMDDHH24MISS

  private LocalDateTime dataOraFine; // YYYYMMDDHH24MISS

  private String padreId;

  private String codice; // codice dell'articolo associato

  @JsonIgnore
  static final DateTimeFormatter CUSTOM_FORMATTER =
      DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

  public String getArticoloId() {
    return articoloId;
  }

  public void setArticoloId(String articoloVenditaId) {
    this.articoloId = articoloVenditaId;
  }

  public Double getPrezzoVendita() {
    return prezzoVendita;
  }

  public void setPrezzoVendita(Double prezzoVendita) {
    this.prezzoVendita = prezzoVendita;
  }

  public LocalDateTime getDataOraInizio() {
    return dataOraInizio;
  }

  public void setDataOraInizio(LocalDateTime dataOraInizio) {
    this.dataOraInizio = dataOraInizio;
  }

  public LocalDateTime getDataOraFine() {
    return dataOraFine;
  }

  public void setDataOraFine(LocalDateTime dataOraFine) {
    this.dataOraFine = dataOraFine;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public String getPadreId() {
    return padreId;
  }

  public void setPadreId(String padreId) {
    this.padreId = padreId;
  }

  @JsonIgnore
  public String getAggregateId() {
    return UUID.randomUUID().toString();
  }

  //

  @JsonIgnore
  public static String localDateTimeToString(LocalDateTime date) {
    String formattedString = date.format(CUSTOM_FORMATTER);
    return formattedString;
  }

  @JsonIgnore
  public static LocalDateTime stringToLocalDateTime(String date) {
    LocalDateTime dateTime = LocalDateTime.parse(date, CUSTOM_FORMATTER);
    return dateTime;
  }
}
