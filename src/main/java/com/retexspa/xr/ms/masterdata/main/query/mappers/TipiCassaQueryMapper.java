package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.TipiCassaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.TipiCassaQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TipiCassaQueryMapper {
    TipiCassaQueryMapper INSTANCE = Mappers.getMapper(TipiCassaQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "codice", source = "codice")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "descrizione", source = "descrizione")
    @Mapping(target = "cassaFisica", source = "cassaFisica")
    @Mapping(target = "flgCancellato", source = "flgCancellato")
    @Mapping(target = "dataCancellazione", source = "dataCancellazione")
    @Mapping(target = "version", source = "version")
    TipiCassaQueryDTO toDTO(TipiCassaQueryEntity entity);
}
