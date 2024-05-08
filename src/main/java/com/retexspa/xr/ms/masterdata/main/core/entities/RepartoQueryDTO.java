package com.retexspa.xr.ms.masterdata.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
@Data
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public class RepartoQueryDTO {
  private String id;
  private String gerarchiaId;
  private String padreId;
  private String ivaId;

  // TLPosWIN
  private String nome;
  private String codice;
  private String descrizione;
  private BigDecimal scontoPercentuale;
  private BigDecimal margineFisso;
  private String accettaPagamentoTicketRestaurant;
  private String erogaPunti;
  private String erogaBuoni;
  private String erogaSconti;
  private String tracciabilitaOrtofrutta;
  private String tracciabilitaMacelleria;
  private String tracciabilitaPescheria;
  private String tracciabilitaGastronomia;

  // definizione campi aggiuntivi presenti in TL
  private Integer Sconto;
  private String RepEcr;
  private String RepLoc;
  private String RepCedi;
  private Double Margine;
  private String FlgTicket;
  private String FlgPunti;
  private String FlgBuoni;
  private String FlgSconti;
  private String DataType;
  private String DataFunc;
  private String BackClr;
  private String FlgOrto;
  private String FlgMacel;
  private String FlgPescheria;
  private String FlgGastro;
  private String RepEkom;
  private LocalDateTime DataCas;
  private String IdSendEcr;
  private String DataOraUpd;
  private String BloccoPre;
  private Long version;
}
