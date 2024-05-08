package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.AtecoQueryDTO;
import com.retexspa.xr.ms.masterdata.main.core.entities.IvaRtQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.AtecoQueryEntity;
import com.retexspa.xr.ms.masterdata.main.query.entities.IvaRtQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IvaRtQueryMapper {
  IvaRtQueryMapper INSTANCE = Mappers.getMapper(IvaRtQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "rtTipoEsenzione", source = "rtTipoEsenzione")
  @Mapping(target = "rtDescr", source = "rtDescr")
  @Mapping(target = "flgCancellato", source = "flgCancellato")
  @Mapping(target = "dataCancellazione", source = "dataCancellazione")
  // @Mapping(target = "rtAtecoNr", source = "rtAtecoNr")
  @Mapping(target = "rtTaxCode", source = "rtTaxCode")
  @Mapping(target = "rtShortDesc", source = "rtShortDesc")
  @Mapping(target = "rtFullDesc", source = "rtFullDesc")
  @Mapping(target = "rtType", source = "rtType")
  @Mapping(target = "padreId", source = "padre.id")
  @Mapping(target = "ivaId", source = "iva.id")
  @Mapping(target = "gerarchiaId", source = "gerarchia.id")
  @Mapping(target = "figli", qualifiedByName = "padreMapper")
  @Mapping(target = "ateco", qualifiedByName = "atecoMapper")
  @Mapping(target = "version", source = "version")
  IvaRtQueryDTO toDTO(IvaRtQueryEntity entity);

  @Mapping(target = "figli", source = "figli")
  @Named("padreMapper")
  IvaRtQueryDTO padreMapper(IvaRtQueryEntity ivaRtQueryEntity);

  @Mapping(target = "id", source = "id", ignore = true)
  @Mapping(target = "codice", source = "codice", ignore = true)
  @Mapping(target = "descrizione", source = "descrizione", ignore = true)
  @Mapping(target = "nome", source = "nome", ignore = true)
  @Named("atecoMapper")
  AtecoQueryDTO atecoMapper(AtecoQueryEntity atecoQueryEntity);
}
