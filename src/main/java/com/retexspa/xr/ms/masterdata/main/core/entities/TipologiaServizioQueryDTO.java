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
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class TipologiaServizioQueryDTO {
  private String id;
  private String codice;
  private String descrizione;
  private String nome;
  private String padreId;
  private String gerarchiaId;
  private Integer numMaxInScontrino;
  private Double valMaxInScontrino;
  private Set<TipologiaServizioQueryDTO> figli;
  private Long version;
}
