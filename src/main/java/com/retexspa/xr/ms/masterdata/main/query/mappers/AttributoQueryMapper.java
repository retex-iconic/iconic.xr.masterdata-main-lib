package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.AttributoQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.AttributoQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AttributoQueryMapper {
  AttributoQueryMapper INSTANCE = Mappers.getMapper(AttributoQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "chiave", source = "chiave")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "aggregato", source = "aggregato")
  @Mapping(target = "checkValue", source = "checkValue")
  @Mapping(target = "version", source = "version")
  AttributoQueryDTO toDTO(AttributoQueryEntity entity);
}
