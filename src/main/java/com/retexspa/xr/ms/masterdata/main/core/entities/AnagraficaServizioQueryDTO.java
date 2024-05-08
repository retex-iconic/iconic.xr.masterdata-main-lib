package com.retexspa.xr.ms.masterdata.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public class AnagraficaServizioQueryDTO {
  private String id;
  private String codice;
  private String nome;
  private String descrizione;
  private String padreId;
  private String gerarchiaId;
  private String collocazione;
  private String providerId;
  private String tipologiaServizioId;
  private String fiduciaria;
  private String desScontrino;
  private String serviceType;
  private Object config;
  private Long version;
  private List<AnagraficaServizioQueryDTO> figli;
}
