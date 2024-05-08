package com.retexspa.xr.ms.masterdata.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
@Data
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class IvaRtQueryDTO {

  private String id;
  private String codice;
  private String nome;
  private String descrizione;
  private String rtTipoEsenzione;
  private String rtTaxCode;
  private String rtShortDesc;
  private String rtFullDesc;
  private String rtType;
  private String rtDescr;
  private String flgCancellato;
  private LocalDateTime dataCancellazione;
  private String gerarchiaId;
  private String padreId;
  private String ivaId;
  private Set<IvaRtQueryDTO> figli;
  private AtecoQueryDTO ateco;
  private Long version;
}
