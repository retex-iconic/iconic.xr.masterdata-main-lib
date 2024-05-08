package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.TipologiaServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.TipologiaServizioQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TipologiaServizioQueryMapper {
  TipologiaServizioQueryMapper INSTANCE = Mappers.getMapper(TipologiaServizioQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "gerarchiaId", source = "gerarchia.id")
  @Mapping(target = "padreId", source = "padre.id")
  @Mapping(target = "figli", qualifiedByName = "padreMapper")
  @Mapping(target = "version", source = "version")
  TipologiaServizioQueryDTO toDTO(TipologiaServizioQueryEntity entity);

  @Mapping(target = "figli", source = "figli", ignore = true)
  @Named("padreMapper")
  TipologiaServizioQueryDTO padreMapper(TipologiaServizioQueryEntity tipologiaServizioQueryEntity);
}
