package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.AnagraficaServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.AnagraficaServizioQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AnagraficaServizioQueryMapper {
  AnagraficaServizioQueryMapper INSTANCE = Mappers.getMapper(AnagraficaServizioQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "providerId", source = "providerId")
  @Mapping(target = "fiduciaria", source = "fiduciaria")
  @Mapping(target = "desScontrino", source = "desScontrino")
  @Mapping(target = "serviceType", source = "serviceType")
  @Mapping(target = "config", source = "config")
  @Mapping(target = "gerarchiaId", source = "gerarchia.id")
  @Mapping(target = "tipologiaServizioId", source = "tipologiaServizio.id")
  @Mapping(target = "padreId", source = "padre.id")
  @Mapping(target = "figli", qualifiedByName = "padreMapper")
  @Mapping(target = "version", source = "version")
  AnagraficaServizioQueryDTO toDTO(AnagraficaServizioQueryEntity entity);

  @Mapping(target = "figli", source = "figli", ignore = true)
  @Named("padreMapper")
  AnagraficaServizioQueryDTO padreMapper(
      AnagraficaServizioQueryEntity anagraficaServizioQueryEntity);
}
