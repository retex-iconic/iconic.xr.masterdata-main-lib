package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloEanQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloEanQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArticoloEanQueryMapper {
  ArticoloEanQueryMapper INSTANCE = Mappers.getMapper(ArticoloEanQueryMapper.class);
  @Mapping(target = "id", source = "id")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "moltiplicatore", source = "moltiplicatore")
  @Mapping(target = "codiceVenditaLocale", source = "codiceVenditaLocale")
  @Mapping(target = "descrizioneCodiceVendita", source = "descrizioneCodiceVendita")
  @Mapping(target = "quantitaCodiceVendita", source = "quantitaCodiceVendita")
  @Mapping(target = "scontoCodiceVendita", source = "scontoCodiceVendita")
  @Mapping(target = "prezzoCodiceVendita", source = "prezzoCodiceVendita")
  @Mapping(target = "anagBil", source = "anagBil")
  @Mapping(target = "flgCancellato", source = "flgCancellato")
  @Mapping(target = "dataCancellazione", source = "dataCancellazione")
  @Mapping(target = "padreId", source = "padre.id")
  @Mapping(target = "gerarchiaId", source = "gerarchia.id")
  @Mapping(target = "articoloId", source = "articolo.id")
  @Mapping(target = "codiceMoltiplicatoreId", source = "codiceMoltiplicatore.id")
  @Mapping(target = "statoId", source = "stato.id")
  @Mapping(target = "tipoEanId", source = "tipoEan.id")
  @Mapping(target = "version", source = "version")
  ArticoloEanQueryDTO toDTO(ArticoloEanQueryEntity entity);
}
