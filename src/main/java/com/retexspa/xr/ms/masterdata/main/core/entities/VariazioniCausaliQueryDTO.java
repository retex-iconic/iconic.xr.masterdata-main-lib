package com.retexspa.xr.ms.masterdata.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public class VariazioniCausaliQueryDTO {
  private String id;
  private String gerarchiaId;
  private String padreId;

  private String codice;
  private String nome;
  private String descrizione;

  private String flgCancellato;
  private LocalDateTime dataCancellazione;

  private String tipologiaVariazione;
  private Integer priorita;
  private String flgAttiva;
  private Long version;
}
