package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.FormaPagamentoQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.FormaPagamentoQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FormaPagamentoQueryMapper {
  FormaPagamentoQueryMapper INSTANCE = Mappers.getMapper(FormaPagamentoQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "flgAttivo", source = "flgAttivo")
  @Mapping(target = "gerarchia", source = "gerarchia")
  @Mapping(target = "padre", source = "padre")
  @Mapping(target = "tipoPagamento", source = "tipoPagamento")
  @Mapping(target = "version", source = "version")
  FormaPagamentoQueryDTO toDTO(FormaPagamentoQueryEntity entity);
}
