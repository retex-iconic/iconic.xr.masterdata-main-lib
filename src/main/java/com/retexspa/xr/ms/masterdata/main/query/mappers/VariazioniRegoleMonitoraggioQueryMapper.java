package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.VariazioniRegoleMonitoraggioQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniRegoleMonitoraggioQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VariazioniRegoleMonitoraggioQueryMapper {
  VariazioniRegoleMonitoraggioQueryMapper INSTANCE =
      Mappers.getMapper(VariazioniRegoleMonitoraggioQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "schema", source = "schema")
  @Mapping(target = "nomeTabella", source = "nomeTabella")
  @Mapping(target = "nomeCampo", source = "nomeCampo")
  @Mapping(target = "regolaConfronto", source = "regolaConfronto")
  @Mapping(target = "variazioniCausaliId", source = "variazioniCausali.id")
  @Mapping(target = "flgSalva", source = "flgSalva")
  @Mapping(target = "flgSalvaCancellazione", source = "flgSalvaCancellazione")
  @Mapping(target = "flgAttiva", source = "flgAttiva")
  @Mapping(target = "padreId", source = "padre.id")
  @Mapping(target = "gerarchiaId", source = "gerarchia.id")
  @Mapping(target = "version", source = "version")
  VariazioniRegoleMonitoraggioQueryDTO toDTO(VariazioniRegoleMonitoraggioQueryEntity entity);
}
