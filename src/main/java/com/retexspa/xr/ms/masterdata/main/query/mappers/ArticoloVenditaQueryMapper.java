package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloVenditaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloVenditaQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArticoloVenditaQueryMapper {
  ArticoloVenditaQueryMapper INSTANCE = Mappers.getMapper(ArticoloVenditaQueryMapper.class);

  @Mapping(target = "gerarchia", source = "gerarchia")
  @Mapping(target = "padre", qualifiedByName = "padreMapper")
  @Mapping(target = "articolo", source = "articolo", ignore = true)
  @Mapping(target = "reparto", source = "reparto")
  @Mapping(target = "iva", source = "iva")
  @Mapping(target = "statoId", source = "stato.id")
  @Mapping(target = "tipoArticoloVenditaId", source = "tipoArticoloVendita.id")
  @Mapping(target = "sottotipoArticoloVenditaId", source = "sottotipoArticoloVendita.id")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "costo", source = "costo")
  @Mapping(target = "tara", source = "tara")
  @Mapping(target = "maxArt", source = "maxArt")
  @Mapping(target = "dataOraInizio", source = "dataOraInizio")
  @Mapping(target = "dataOraFine", source = "dataOraFine")
  @Mapping(target = "oraInizio", source = "oraInizio")
  @Mapping(target = "oraFine", source = "oraFine")
  @Mapping(target = "aa3", source = "aa3")
  @Mapping(target = "aa4", source = "aa4")
  @Mapping(target = "flgCancellato", source = "flgCancellato")
  @Mapping(target = "dataCancellazione", source = "dataCancellazione")
  @Mapping(target = "version", source = "version")
  ArticoloVenditaQueryDTO toDTO(ArticoloVenditaQueryEntity entity);

  @Mapping(target = "padre", source = "padre", ignore = true)
  @Named("padreMapper")
  ArticoloVenditaQueryDTO padreMapper(ArticoloVenditaQueryDTO articoloVenditaQueryDTO);
}
