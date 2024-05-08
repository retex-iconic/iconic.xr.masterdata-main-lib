package com.retexspa.xr.ms.masterdata.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.retexspa.xr.ms.main.core.entities.GerarchiaQueryDTO;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public class EsclusioniFpServizioQueryDTO {
  private String id;
  private String codice;
  private GerarchiaQueryDTO gerarchia;
  private AnagraficaServizioQueryDTO anagraficaServizio;
  private FormaPagamentoQueryDTO formaPagamento;

  private Double massimaleSingolo;
  private Double massimaleCumulativo;
  private String flgSegnalazione;
  private String descSegnalazione;
  private Long version;
}
