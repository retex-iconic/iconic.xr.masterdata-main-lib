package com.retexspa.xr.ms.masterdata.main.query.mappers;


import com.retexspa.xr.ms.masterdata.main.core.entities.ArticoloExtraQueryDTO;
import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloExtraQueryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArticoloExtraQueryMapper {
  ArticoloExtraQueryMapper INSTANCE = Mappers.getMapper(ArticoloExtraQueryMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "codice", source = "codice")
  @Mapping(target = "padre", qualifiedByName = "padreMapper")
  @Mapping(target = "gerarchia", source = "gerarchia")
  @Mapping(target = "articolo", source = "articolo")
  @Mapping(target = "layoutESL", source = "layoutESL")
  @Mapping(target = "gruppo", source = "gruppo")
  @Mapping(target = "descrizioneBreve", source = "descrizioneBreve")
  @Mapping(target = "unitaDiMisura", source = "unitaDiMisura")
  @Mapping(target = "quantita", source = "quantita")
  @Mapping(target = "scortaMinima", source = "scortaMinima")
  @Mapping(target = "deposito", source = "deposito")
  @Mapping(target = "scaffale", source = "scaffale")
  @Mapping(target = "superficieEspositiva", source = "superficieEspositiva")
  @Mapping(target = "quantitaImpegnata", source = "quantitaImpegnata")
  @Mapping(target = "scortaMassima", source = "scortaMassima")
  @Mapping(target = "layoutEtichetta", source = "layoutEtichetta")
  @Mapping(target = "tipoProdotto", source = "tipoProdotto")
  @Mapping(target = "numeroEtichette", source = "numeroEtichette")
  @Mapping(target = "tipoScaricoVenduto", source = "tipoScaricoVenduto")
  @Mapping(target = "fornitorePrimario", source = "fornitorePrimario")
  @Mapping(target = "fornitoreEtichetta", source = "fornitoreEtichetta")
  @Mapping(target = "posizionamento", source = "posizionamento")
  @Mapping(target = "stagionalita", source = "stagionalita")
  @Mapping(target = "tipoProdotto2", source = "tipoProdotto2")
  @Mapping(target = "svalorizzazione", source = "svalorizzazione")
  @Mapping(target = "cluster", source = "cluster")
  @Mapping(target = "assortimentoPuntoVendita", source = "assortimentoPuntoVendita")
  @Mapping(target = "version", source = "version")
  ArticoloExtraQueryDTO toDTO(ArticoloExtraQueryEntity entity);

  @Mapping(target = "padre", source = "padre", ignore = true)
  @Named("padreMapper")
  ArticoloExtraQueryDTO padreMapper(ArticoloExtraQueryDTO articoloExtraQueryDTO);
}
