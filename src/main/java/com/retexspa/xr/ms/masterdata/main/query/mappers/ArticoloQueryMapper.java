package com.retexspa.xr.ms.masterdata.main.query.mappers;


import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArticoloQueryMapper {
  ArticoloQueryMapper INSTANCE = Mappers.getMapper(ArticoloQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "flgCancellato", source = "flgCancellato")
  @Mapping(target = "dataCancellazione", source = "dataCancellazione")
  @Mapping(target = "padreId", source = "padre.id")
  @Mapping(target = "gerarchiaId", source = "gerarchia.id")
  @Mapping(target = "version", source = "version")
  ArticoloQueryDTO toDTO(ArticoloQueryEntity articoloQueryEntity);
}
