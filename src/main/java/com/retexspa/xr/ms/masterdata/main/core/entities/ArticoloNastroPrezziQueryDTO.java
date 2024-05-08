package com.retexspa.xr.ms.masterdata.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDateTime;

import com.retexspa.xr.ms.main.core.entities.GerarchiaQueryDTO;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public class ArticoloNastroPrezziQueryDTO {
  private String id;
  private String codice;
  private Double prezzoVendita;
  private LocalDateTime dataOraInizio;
  private LocalDateTime dataOraFine;
  private ArticoloNastroPrezziQueryDTO padre;
  private ArticoloQueryDTO articolo;
  private GerarchiaQueryDTO gerarchia;
  private Long version;
}
