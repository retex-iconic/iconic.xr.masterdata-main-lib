package com.retexspa.xr.ms.masterdata.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.entities.GerarchiaQueryDTO;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
@Data
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public class OperatorePosQueryDTO {
  private String id;
  private String nome;
  private String cognome;
  private String codice;
  // private String descrizione;
  // private String codOperatore;
  private String mnemonic;
  private String password;
  // private String codiceNegozio;
  private OperatorePosQueryDTO padre;
  private GerarchiaQueryDTO gerarchia;
  private Long version;
  // private Set<OperatorePosQueryDTO> operatoriPos;
}
