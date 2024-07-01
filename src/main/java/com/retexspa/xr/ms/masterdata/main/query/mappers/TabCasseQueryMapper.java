package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.TabCasseQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.TabCasseQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TabCasseQueryMapper {
    TabCasseQueryMapper INSTANCE = Mappers.getMapper(TabCasseQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "codice", source = "codice")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "descrizione", source = "descrizione")
    @Mapping(target = "gerarchiaId", source = "gerarchia.id")
    @Mapping(target = "tipoCassaId", source = "tipoCassa.id")
    @Mapping(target = "attiva", source = "attiva")
    @Mapping(target = "flgCancellato", source = "flgCancellato")
    @Mapping(target = "dataCancellazione", source = "dataCancellazione")
    @Mapping(target = "version", source = "version")
    TabCasseQueryDTO toDTO(TabCasseQueryEntity entity);
}

