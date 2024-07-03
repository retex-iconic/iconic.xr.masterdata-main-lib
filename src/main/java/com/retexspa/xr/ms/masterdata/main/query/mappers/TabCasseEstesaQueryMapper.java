package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.TabCasseEstesaQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.entities.TabCasseQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.TabCasseEstesaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.entities.TabCasseQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TabCasseEstesaQueryMapper {
    TabCasseEstesaQueryMapper INSTANCE = Mappers.getMapper(TabCasseEstesaQueryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "cassaId", source = "tabCasse.id")
    @Mapping(target = "dataInizio", source = "dataInizio")
    @Mapping(target = "tipoCassaEstesoId", source = "tipoCassaEsteso.id")
    @Mapping(target = "flgCancellato", source = "flgCancellato")
    @Mapping(target = "dataCancellazione", source = "dataCancellazione")
    @Mapping(target = "version", source = "version")
    TabCasseEstesaQueryDTO toDTO(TabCasseEstesaQueryEntity entity);
}
