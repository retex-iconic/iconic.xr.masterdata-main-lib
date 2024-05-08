package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.VariazioniCausaliOperazioniQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniCausaliOperazioniQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VariazioniCausaliOperazioniQueryMapper {
  VariazioniCausaliOperazioniQueryMapper INSTANCE =
      Mappers.getMapper(VariazioniCausaliOperazioniQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "gerarchiaId", source = "gerarchia.id")
  @Mapping(target = "variazioniCausaliId", source = "variazioniCausali.id")
  @Mapping(target = "operazione", source = "operazione")
  @Mapping(target = "priorita", source = "priorita")
  @Mapping(target = "flgEsecuzioneImmediata", source = "flgEsecuzioneImmediata")
  @Mapping(target = "flgAttivo", source = "flgAttivo")
  @Mapping(target = "padreId", source = "padre.id")
  @Mapping(target = "version", source = "version")
  VariazioniCausaliOperazioniQueryDTO toDTO(VariazioniCausaliOperazioniQueryEntity entity);
}
