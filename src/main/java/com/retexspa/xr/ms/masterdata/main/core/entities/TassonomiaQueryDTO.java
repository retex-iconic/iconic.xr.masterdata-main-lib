package com.retexspa.xr.ms.masterdata.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.Set;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
@Data
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class TassonomiaQueryDTO {
  private String id;
  private String nome;
  private String codice;
  private String descrizione;
  private String tipoTassonomiaId;
  private String nodoId;
  private String gerarchiaId;
  private String padreId;
  private Set<TassonomiaQueryDTO> figli;
  private Long version;
}
