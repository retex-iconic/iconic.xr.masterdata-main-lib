package com.retexspa.xr.ms.masterdata.main.query.mappers;

import com.retexspa.xr.ms.masterdata.main.core.entities.FornitoreQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.FornitoreQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FornitoreQueryMapper {
  FornitoreQueryMapper INSTANCE = Mappers.getMapper(FornitoreQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "nome", source = "nome")
  @Mapping(target = "descrizione", source = "descrizione")
  @Mapping(target = "padreId", source = "padre.id")
  @Mapping(target = "gerarchia", source = "gerarchia")
  // @Mapping(target = "negozi", source = "negozi")
  @Mapping(target = "numero", source = "numero")
  @Mapping(target = "indirizzo", source = "indirizzo")
  @Mapping(target = "citta", source = "citta")
  @Mapping(target = "cap", source = "cap")
  @Mapping(target = "piva", source = "piva")
  @Mapping(target = "magazzino", source = "magazzino")
  @Mapping(target = "codiceEsterno", source = "codiceEsterno")
  @Mapping(target = "ragioneSociale", source = "ragioneSociale")
  @Mapping(target = "codiceFiscale", source = "codiceFiscale")
  @Mapping(target = "telefono", source = "telefono")
  @Mapping(target = "rank", source = "rank")
  @Mapping(target = "tipoCod", source = "tipoCod")
  @Mapping(target = "email", source = "email")
  @Mapping(target = "codiceEsterno2", source = "codiceEsterno2")
  @Mapping(target = "codiceContabilita", source = "codiceContabilita")
  @Mapping(target = "codicePrecedenteBackOffice", source = "codicePrecedenteBackOffice")
  @Mapping(target = "figli", qualifiedByName = "padreMapper")
  @Mapping(target = "version", source = "version")
  FornitoreQueryDTO toDTO(FornitoreQueryEntity entity);

  @Mapping(target = "figli", source = "figli", ignore = true)
  @Named("padreMapper")
  FornitoreQueryDTO padreMapper(FornitoreQueryEntity fornitoreQueryEntity);
}
