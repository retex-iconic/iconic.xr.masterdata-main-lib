package com.retexspa.xr.ms.masterdata.main.query.mappers;


import com.retexspa.xr.ms.main.core.entities.GerarchiaQueryDTO;
import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.entities.TassonomiaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.TassonomiaQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/*

Create all the target properties in ArticoloDTO and ArticoloQueryEntity

 only fields with block comment as prefix  are required

 */

@Mapper(componentModel = "spring")
public interface TassonomiaQueryMapper {

  TassonomiaQueryMapper INSTANCE = Mappers.getMapper(TassonomiaQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "nodoId", source = "nodo.id")
  @Mapping(target = "gerarchiaId", source = "gerarchia.id")
  @Mapping(target = "tipoTassonomiaId", source = "tipoTassonomia.id")
  @Mapping(target = "padreId", source = "padre.id")
  @Mapping(target = "figli", qualifiedByName = "nodoMapper")
  @Mapping(target = "version", source = "version")
  TassonomiaQueryDTO toDTO(TassonomiaQueryEntity tassonomiaQueryEntity);

  @Mapping(target = "figli", source = "figli")
  @Named("nodoMapper")
  TassonomiaQueryDTO nodoMapper(TassonomiaQueryEntity tassonomiaQueryEntity);

  @Mapping(target = "id", source = "id", ignore = true)
  @Named("gerarchiaMapper")
  GerarchiaQueryDTO gerarchiaMapper(GerarchiaQueryEntity gerarchiaQueryEntity);
}
