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
public class VariazioniRegoleMonitoraggioQueryDTO {
  private String id;
  private String gerarchiaId;
  private String padreId;

  private String codice;
  private String nome;
  private String descrizione;
  private String schema;
  private String nomeTabella;
  private String nomeCampo;
  private String regolaConfronto;
  private String variazioniCausaliId;
  private String flgSalva;
  private String flgSalvaCancellazione;
  private String flgAttiva;
  private Set<VariazioniRegoleMonitoraggioQueryDTO> figli;
  private Long version;
}
