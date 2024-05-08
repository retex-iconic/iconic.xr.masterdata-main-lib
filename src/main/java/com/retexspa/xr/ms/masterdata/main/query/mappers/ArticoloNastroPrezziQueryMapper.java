package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloNastroPrezziQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloNastroPrezziQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArticoloNastroPrezziQueryMapper {
  ArticoloNastroPrezziQueryMapper INSTANCE =
      Mappers.getMapper(ArticoloNastroPrezziQueryMapper.class);

  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "prezzoVendita", source = "prezzoVendita")
  @Mapping(target = "dataOraInizio", source = "dataOraInizio")
  @Mapping(target = "dataOraFine", source = "dataOraFine")
  @Mapping(target = "padre", qualifiedByName = "padreMapper")
  @Mapping(target = "gerarchia", source = "gerarchia")
  @Mapping(target = "articolo", source = "articolo", ignore = true)
  @Mapping(target = "version", source = "version")
  ArticoloNastroPrezziQueryDTO toDTO(ArticoloNastroPrezziQueryEntity entity);

  @Mapping(target = "padre", source = "padre", ignore = true)
  @Named("padreMapper")
  ArticoloNastroPrezziQueryDTO padreMapper(
      ArticoloNastroPrezziQueryDTO articoloNastroPrezziQueryDTO);
}
