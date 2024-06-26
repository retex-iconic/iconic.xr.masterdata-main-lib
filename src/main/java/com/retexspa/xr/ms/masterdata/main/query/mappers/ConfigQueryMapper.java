package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.ConfigQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.ConfigQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ConfigQueryMapper {
  ConfigQueryMapper INSTANCE = Mappers.getMapper(ConfigQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "flgAttivo", source = "flgAttivo")
  @Mapping(target = "flgCancellato", source = "flgCancellato")
  @Mapping(target = "context", source = "context.id")
  @Mapping(target = "nodo", source = "nodo.id")
  @Mapping(target = "version", source = "version")
  ConfigQueryDTO toDTO(ConfigQueryEntity entity);
}
