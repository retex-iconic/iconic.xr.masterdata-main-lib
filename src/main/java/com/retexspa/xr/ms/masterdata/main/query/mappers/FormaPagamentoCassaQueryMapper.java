package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.FormaPagamentoCassaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.FormaPagamentoCassaQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FormaPagamentoCassaQueryMapper {
  FormaPagamentoCassaQueryMapper INSTANCE = Mappers.getMapper(FormaPagamentoCassaQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "xx1mty", source = "xx1mty")
  @Mapping(target = "xx1mnr", source = "xx1mnr")
  @Mapping(target = "formaPagamento", source = "formaPagamento")
  @Mapping(target = "gerarchia", source = "gerarchia")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "version", source = "version")
  FormaPagamentoCassaQueryDTO toDTO(FormaPagamentoCassaQueryEntity entity);
}
