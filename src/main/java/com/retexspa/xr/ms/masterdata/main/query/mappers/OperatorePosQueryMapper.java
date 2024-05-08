package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.OperatorePosQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.OperatorePOSQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OperatorePosQueryMapper {
  OperatorePosQueryMapper INSTANCE = Mappers.getMapper(OperatorePosQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "cognome", source = "cognome")
  @Mapping(target = "codice", source = "codice")
  // @Mapping(target = "descrizione", source = "descrizione")
  // @Mapping(target = "codOperatore", source = "codOperatore")
  @Mapping(target = "mnemonic", source = "mnemonic")
  @Mapping(target = "password", source = "password")
  // @Mapping(target = "codiceNegozio", source = "codiceNegozio")
  @Mapping(target = "padre", source = "padre")
  @Mapping(target = "gerarchia", source = "gerarchia")
  @Mapping(target = "version", source = "version")
  // @Mapping(target = "operatoriPos", source = "operatoriPos")
  OperatorePosQueryDTO toDTO(OperatorePOSQueryEntity entity);
}
