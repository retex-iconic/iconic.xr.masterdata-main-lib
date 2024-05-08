package com.retexspa.xr.ms.masterdata.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.Set;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public class VariazioniCausaliOperazioniQueryDTO {
  private String id;
  private String gerarchiaId;
  private String variazioniCausaliId;
  private String codice;
  private String nome;
  private String descrizione;
  private String operazione;
  private String priorita;
  private String flgEsecuzioneImmediata;
  private String flgAttivo;
  private Set<VariazioniCausaliOperazioniQueryDTO> figli;
  private String padreId;
  private Long version;
}
