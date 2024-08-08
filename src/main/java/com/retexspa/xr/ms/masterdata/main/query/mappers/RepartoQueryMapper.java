package com.retexspa.xr.ms.masterdata.main.query.mappers;


import com.retexspa.xr.ms.masterdata.main.core.entities.RepartoQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.RepartoQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RepartoQueryMapper {
  RepartoQueryMapper INSTANCE = Mappers.getMapper(RepartoQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "scontoPercentuale", source = "scontoPercentuale")
  @Mapping(target = "margineFisso", source = "margineFisso")
  @Mapping(target = "accettaPagamentoTicketRestaurant", source = "accettaPagamentoTicketRestaurant")
  @Mapping(target = "erogaPunti", source = "erogaPunti")
  @Mapping(target = "erogaBuoni", source = "erogaBuoni")
  @Mapping(target = "erogaSconti", source = "erogaSconti")
  @Mapping(target = "sconto", source = "sconto")
  @Mapping(target = "repEcr", source = "repEcr")
  @Mapping(target = "repLoc", source = "repLoc")
  @Mapping(target = "repCedi", source = "repCedi")
  @Mapping(target = "margine", source = "margine")
  @Mapping(target = "flgTicket", source = "flgTicket")
  @Mapping(target = "flgPunti", source = "flgPunti")
  @Mapping(target = "flgBuoni", source = "flgBuoni")
  @Mapping(target = "flgSconti", source = "flgSconti")
  @Mapping(target = "dataType", source = "dataType")
  @Mapping(target = "dataFunc", source = "dataFunc")
  @Mapping(target = "backClr", source = "backClr")
  @Mapping(target = "flgOrto", source = "flgOrto")
  @Mapping(target = "flgMacel", source = "flgMacel")
  @Mapping(target = "flgPescheria", source = "flgPescheria")
  @Mapping(target = "flgGastro", source = "flgGastro")
  @Mapping(target = "repEkom", source = "repEkom")
  @Mapping(target = "dataCas", source = "dataCas")
  @Mapping(target = "idSendEcr", source = "idSendEcr")
  @Mapping(target = "dataOraUpd", source = "dataOraUpd")
  @Mapping(target = "bloccoPre", source = "bloccoPre")
  @Mapping(target = "padreId", source = "padre.id")
  @Mapping(target = "ivaId", source = "iva.id")
  @Mapping(target = "gerarchiaId", source = "gerarchia.id")
  @Mapping(target = "flgCancellato", source = "flgCancellato")
  @Mapping(target = "version", source = "version")
  RepartoQueryDTO toDTO(RepartoQueryEntity entity);
}
