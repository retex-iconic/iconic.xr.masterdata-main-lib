package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.MasterDataConfigContextQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.MasterDataConfigContextQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MasterDataConfigContextQueryMapper {
  MasterDataConfigContextQueryMapper INSTANCE =
      Mappers.getMapper(MasterDataConfigContextQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "flgCancellato", source = "flgCancellato")
  @Mapping(target = "version", source = "version")
  MasterDataConfigContextQueryDTO toDTO(MasterDataConfigContextQueryEntity entity);
}
