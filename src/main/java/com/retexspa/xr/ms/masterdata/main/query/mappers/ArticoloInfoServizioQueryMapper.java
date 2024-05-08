package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloInfoServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloInfoServizioQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArticoloInfoServizioQueryMapper {
  ArticoloInfoServizioQueryMapper INSTANCE =
      Mappers.getMapper(ArticoloInfoServizioQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "flgCancellato", source = "flgCancellato")
  @Mapping(target = "articoloId", source = "articolo.id")
  @Mapping(target = "servizioId", source = "servizio.id")
  @Mapping(target = "gerarchiaId", source = "gerarchia.id")
  ArticoloInfoServizioQueryDTO toDTO(ArticoloInfoServizioQueryEntity entity);
}
