package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.TassonomiaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.entities.TipoTassonomiaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.TassonomiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.entities.TipoTassonomiaQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TipoTassonomiaQueryMapper {

  TipoTassonomiaQueryMapper INSTANCE = Mappers.getMapper(TipoTassonomiaQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "codice", source = "codice")
  // @Mapping(target = "livello", source = "livello")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "gruppoTassonomia", source = "gruppoTassonomia")
  @Mapping(target = "flgNonCancellabile", source = "flgNonCancellabile")
  @Mapping(target = "nodoId", source = "nodo.id")
  @Mapping(target = "gerarchiaId", source = "gerarchia.id")
  @Mapping(target = "padreId", source = "padre.id")
  @Mapping(target = "figli", qualifiedByName = "nodoMapper")
  @Mapping(target = "tassonomie", qualifiedByName = "tassonomiaMapper")
  @Mapping(target = "version", source = "version")
  TipoTassonomiaQueryDTO toDTO(TipoTassonomiaQueryEntity tipotassonomiaQueryEntity);

  @Mapping(target = "figli", source = "figli")
  @Named("nodoMapper")
  TipoTassonomiaQueryDTO nodoMapper(TipoTassonomiaQueryEntity tipoTassonomiaQueryEntity);

  @Mapping(target = "id", source = "id")
  @Named("tassonomiaMapper")
  TassonomiaQueryDTO tassonomiaMapper(TassonomiaQueryEntity tassonomiaQueryEntity);
}
