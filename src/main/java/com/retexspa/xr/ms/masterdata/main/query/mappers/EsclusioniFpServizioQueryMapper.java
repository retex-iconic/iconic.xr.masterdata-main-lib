package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.EsclusioniFpServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.EsclusioniFpServizioQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EsclusioniFpServizioQueryMapper {
  EsclusioniFpServizioQueryMapper INSTANCE =
      Mappers.getMapper(EsclusioniFpServizioQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "gerarchia", source = "gerarchia")
  @Mapping(target = "anagraficaServizio", source = "servizio")
  @Mapping(target = "formaPagamento", source = "formaPagamento")
  @Mapping(target = "massimaleSingolo", source = "massimaleSingolo")
  @Mapping(target = "massimaleCumulativo", source = "massimaleCumulativo")
  @Mapping(target = "flgSegnalazione", source = "flgSegnalazione")
  @Mapping(target = "descSegnalazione", source = "descSegnalazione")
  @Mapping(target = "version", source = "version")
  EsclusioniFpServizioQueryDTO toDTO(EsclusioniFpServizioQueryEntity entity);
}
