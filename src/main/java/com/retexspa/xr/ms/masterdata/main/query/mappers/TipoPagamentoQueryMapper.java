package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.TipoPagamentoQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.TipoPagamentoQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface TipoPagamentoQueryMapper {
  TipoPagamentoQueryMapper INSTANCE = Mappers.getMapper(TipoPagamentoQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "gerarchia", source = "gerarchia")
  @Mapping(target = "padre", source = "padre")
  @Mapping(target = "indicatoreFts", source = "indicatoreFts")
  @Mapping(target = "version", source = "version")
  TipoPagamentoQueryDTO toDTO(TipoPagamentoQueryEntity entity);
}
