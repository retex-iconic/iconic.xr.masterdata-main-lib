package com.retexspa.xr.ms.masterdata.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;

import com.retexspa.xr.ms.main.core.entities.GerarchiaQueryDTO;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
@Data
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public class ArticoloAcquistoQueryDTO {
  private FornitoreQueryDTO fornitore;
  private ArticoloQueryDTO articolo;
  private String costoCartone;
  private BigDecimal pezziPerCartone;
  private Integer lottoRiordino;
  private String codice3;
  private String note;
  private String codice;
  private String nome;
  private String pezziCartone;
  private String descrizione;
  private String tipo;
  private Integer unitaDiMisura;
  private String quantita;
  private String codiceExt;
  private ArticoloQueryDTO padre;
  private GerarchiaQueryDTO gerarchia;
}
