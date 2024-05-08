package com.retexspa.xr.ms.masterdata.main.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.Set;

import com.retexspa.xr.ms.main.core.entities.GerarchiaQueryDTO;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
@Data
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public class FornitoreQueryDTO {
  private String id;
  private String codice;
  private String nome;
  private String descrizione;
  private String padreId;
  private GerarchiaQueryDTO gerarchia;
  private String numero;
  private String indirizzo;
  private String citta;
  private String cap;
  private String piva;
  private String magazzino;
  private String codiceEsterno;
  private String ragioneSociale;
  private String codiceFiscale;
  private String telefono;
  private String rank;
  private String tipoCod;
  private String email;
  private String codiceEsterno2;
  private String codiceContabilita;
  private String codicePrecedenteBackOffice;
  private Set<FornitoreQueryDTO> figli;
  private Long version;
}
