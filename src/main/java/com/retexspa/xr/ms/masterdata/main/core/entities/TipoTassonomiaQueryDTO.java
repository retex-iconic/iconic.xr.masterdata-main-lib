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
public class TipoTassonomiaQueryDTO {
  private String id;
  private String nome;
  private String codice;
  private String descrizione;
  // private Integer livello;
  private String gruppoTassonomia;
  private String flgNonCancellabile;
  private String gerarchiaId;
  private String nodoId;
  private String padreId;
  private Set<TipoTassonomiaQueryDTO> figli;
  private Set<TassonomiaQueryDTO> tassonomie;
  private Long version;
}
