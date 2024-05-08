package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.VariazioniCausaliQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniCausaliQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VariazioniCausaliQueryMapper {
  RepartoQueryMapper INSTANCE = Mappers.getMapper(RepartoQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "tipologiaVariazione", source = "tipologiaVariazione")
  @Mapping(target = "priorita", source = "priorita")
  @Mapping(target = "flgAttiva", source = "flgAttiva")
  @Mapping(target = "padreId", source = "padre.id")
  @Mapping(target = "gerarchiaId", source = "gerarchia.id")
  @Mapping(target = "version", source = "version")
  VariazioniCausaliQueryDTO toDTO(VariazioniCausaliQueryEntity entity);
}
