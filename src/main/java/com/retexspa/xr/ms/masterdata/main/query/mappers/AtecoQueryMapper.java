package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.AtecoQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.AtecoQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AtecoQueryMapper {
  AtecoQueryMapper INSTANCE = Mappers.getMapper(AtecoQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "atecoNr", source = "atecoNr")
  @Mapping(target = "padre", source = "padre")
  @Mapping(target = "gerarchia", source = "gerarchia")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "version", source = "version")
  AtecoQueryDTO toDTO(AtecoQueryEntity entity);
}
