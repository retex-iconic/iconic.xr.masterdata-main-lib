package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.CommissioneServizioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.CommissioneServizioQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommissioneServizioQueryMapper {
  CommissioneServizioQueryMapper INSTANCE = Mappers.getMapper(CommissioneServizioQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "gerarchia", source = "gerarchia")
  @Mapping(target = "anagraficaServizio", source = "anagraficaServizio")
  @Mapping(target = "articolo", source = "articolo")
  @Mapping(target = "flgDefault", source = "flgDefault")
  @Mapping(target = "version", source = "version")
  CommissioneServizioQueryDTO toDTO(CommissioneServizioQueryEntity entity);
}
