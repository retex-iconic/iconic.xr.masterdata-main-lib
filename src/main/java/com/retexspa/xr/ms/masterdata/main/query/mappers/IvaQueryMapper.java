package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.IvaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.entities.IvaRtQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.IvaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.entities.IvaRtQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IvaQueryMapper {
  IvaQueryMapper INSTANCE = Mappers.getMapper(IvaQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "codIvaAcquisto", source = "codIvaAcquisto")
  @Mapping(target = "percentuale", source = "percentuale")
  @Mapping(target = "naturaEsenzione", source = "naturaEsenzione")
  @Mapping(target = "normaEsenzione", source = "normaEsenzione")
  @Mapping(target = "codiceEsterno", source = "codiceEsterno")
  @Mapping(target = "codiceECommerce", source = "codiceECommerce")
  @Mapping(target = "padreId", source = "padre.id")
  @Mapping(target = "gerarchiaId", source = "gerarchia.id")
  @Mapping(target = "figli", qualifiedByName = "padreMapper")
  @Mapping(target = "ivaRt", qualifiedByName = "ivaRtMapper")
  @Mapping(target = "version", source = "version")
  IvaQueryDTO toDTO(IvaQueryEntity entity);

  @Mapping(target = "figli", source = "figli", ignore = true)
  @Named("padreMapper")
  IvaQueryDTO padreMapper(IvaQueryEntity ivaQueryEntity);

  @Mapping(target = "id", source = "id")
  @Named("ivaRtMapper")
  IvaRtQueryDTO ivaRtMapper(IvaRtQueryEntity ivaRtQueryEntity);
}
