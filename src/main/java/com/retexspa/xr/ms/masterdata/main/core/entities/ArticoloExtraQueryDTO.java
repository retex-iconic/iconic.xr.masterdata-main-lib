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
public class ArticoloExtraQueryDTO {
  private String id;
  private String codice;
  private ArticoloExtraQueryDTO padre;
  private GerarchiaQueryDTO gerarchia;
  private ArticoloQueryDTO articolo;
  private String layoutESL;
  private String gruppo;
  private String descrizioneBreve;
  private String unitaDiMisura;
  private Integer quantita;
  private Integer scortaMinima;
  private Integer deposito;
  private String scaffale;
  private Double superficieEspositiva;
  private Integer quantitaImpegnata;
  private Integer scortaMassima;
  private Integer layoutEtichetta;
  private String tipoProdotto;
  private Integer numeroEtichette;
  private String tipoScaricoVenduto;
  private String fornitorePrimario;
  private String fornitoreEtichetta;
  private Integer posizionamento;
  private Integer stagionalita;
  private Integer tipoProdotto2;
  private String svalorizzazione;
  private String cluster;
  private String assortimentoPuntoVendita;
  private Long version;
}
