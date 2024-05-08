package com.retexspa.xr.ms.masterdata.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import java.util.Set;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
@Data
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public class IvaQueryDTO {

  private String id;
  private String nome;
  private String codice;
  private String descrizione;
  private String tipoIva;
  // TLPoswin
  private String codIvaAcquisto;
  private Double percentuale;
  private String naturaEsenzione;
  private String normaEsenzione;
  private String codiceEsterno;
  private String codiceECommerce;

  private String gerarchiaId;
  private List<RepartoQueryDTO> reparti;

  private String padreId;
  private Set<IvaQueryDTO> figli;
  private Set<IvaRtQueryDTO> ivaRt;
  private Long version;
}
