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
public class FormaPagamentoQueryDTO {
  private String id;
  private String codice;
  private String nome;
  private String descrizione;
  private GerarchiaQueryDTO gerarchia;
  private FormaPagamentoQueryDTO padre;
  private String flgAttivo;
  private TipoPagamentoQueryDTO tipoPagamento;
  private Long version;
}
