package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloAcquistoQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloAcquistoQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArticoloAcquistoQueryMapper {
  ArticoloAcquistoQueryMapper INSTANCE = Mappers.getMapper(ArticoloAcquistoQueryMapper.class);

  @Mapping(target = "gerarchia", source = "gerarchia")
  @Mapping(target = "padre", source = "padre")
  @Mapping(target = "fornitore", source = "fornitore")
  @Mapping(target = "articolo", source = "articolo")
  @Mapping(target = "costoCartone", source = "costoCartone")
  @Mapping(target = "pezziPerCartone", source = "pezziPerCartone")
  @Mapping(target = "lottoRiordino", source = "lottoRiordino")
  @Mapping(target = "codice3", source = "codice3")
  @Mapping(target = "note", source = "note")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "pezziCartone", source = "pezziCartone")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "tipo", source = "tipo")
  @Mapping(target = "unitaDiMisura", source = "unitaDiMisura")
  @Mapping(target = "quantita", source = "quantita")
  @Mapping(target = "codiceExt", source = "codiceExt")
  ArticoloAcquistoQueryDTO toDTO(ArticoloAcquistoQueryEntity entity);
}
