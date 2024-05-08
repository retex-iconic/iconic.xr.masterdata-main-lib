package com.retexspa.xr.ms.masterdata.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDateTime;

import com.retexspa.xr.ms.main.core.entities.GerarchiaQueryDTO;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
@Data
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public class ArticoloVenditaQueryDTO {
  private String id;
  private String codice;
  private String nome;
  private String descrizione;

  private ArticoloVenditaQueryDTO padre;
  private GerarchiaQueryDTO gerarchia;
  private ArticoloQueryDTO articolo;
  private RepartoQueryDTO reparto;
  private IvaQueryDTO iva;

  private String statoId;
  private String tipoArticoloVenditaId;
  private String sottotipoArticoloVenditaId;

  private Double costo;
  private Integer tara;
  private Integer maxArt;
  private LocalDateTime dataOraInizio;
  private LocalDateTime dataOraFine;
  private String oraInizio;
  private String oraFine;
  private Integer aa3;
  private Integer aa4;
  private String flgCancellato;
  private LocalDateTime dataCancellazione;

  private Long version;
}
