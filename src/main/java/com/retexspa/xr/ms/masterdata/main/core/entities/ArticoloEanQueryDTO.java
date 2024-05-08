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
public class ArticoloEanQueryDTO {
  private String id;
  private String codice;
  private String descrizione;
  private Integer moltiplicatore;
  private String codiceVenditaLocale;
  private String descrizioneCodiceVendita;
  private Double quantitaCodiceVendita;
  private Double scontoCodiceVendita;
  private Double prezzoCodiceVendita;
  private String anagBil;
  private String flgCancellato;
  private LocalDateTime dataCancellazione;

  private ArticoloEanQueryDTO padre;
  private GerarchiaQueryDTO gerarchia;
  private ArticoloQueryDTO articolo;
  private String codiceMoltiplicatoreId;
  private String statoId;
  private String tipoEanId;

  private Long version;
}
