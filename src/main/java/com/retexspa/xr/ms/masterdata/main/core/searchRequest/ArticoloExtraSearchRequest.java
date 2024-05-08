package com.retexspa.xr.ms.masterdata.main.core.searchRequest;


import java.util.List;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticoloExtraSearchRequest extends BaseSortPagination {
  private String id;
  private String articoloId;
  private String nome;
  private String codice;
  private String descrizione;
  private String gerarchiaId;
  private String padreId;
  private String layoutesl;
  private String gruppo;
  private String descrizioneBreve;
  private String unitaDiMisura;
  private String quantita;
  private String scortaMinima;
  private String deposito;
  private String scaffale;
  private Double superficieEspositiva;
  private Integer quantitaImpegnata;
  private String scortaMassima;
  private Integer layoutEtichetta;
  private String tipoProdotto;
  private Integer numeroEtichette;
  private String tipoScaricoVenduto;
  private String fornitorePrimario;
  private String fornitoreEtichetta;
  private Integer posizionamento;
  private Integer stagionalita;
  private Integer tipoProdotto2;
  private String svalorizzazione;
  private String cluster;
  private String assortimentoPuntoVendita;
  private Long version;

  public ArticoloExtraSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String articoloId,
      String nome,
      String codice,
      String descrizione,
      String gerarchiaId,
      String padreId,
      String layoutesl,
      String gruppo,
      String descrizioneBreve,
      String unitaDiMisura,
      String quantita,
      String scortaMinima,
      String deposito,
      String scaffale,
      Double superficieEspositiva,
      Integer quantitaImpegnata,
      String scortaMassima,
      Integer layoutEtichetta,
      String tipoProdotto,
      Integer numeroEtichette,
      String tipoScaricoVenduto,
      String fornitorePrimario,
      String fornitoreEtichetta,
      Integer posizionamento,
      Integer stagionalita,
      Integer tipoProdotto2,
      String svalorizzazione,
      String cluster,
      String assortimentoPuntoVendita,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.articoloId = articoloId;
    this.nome = nome;
    this.codice = codice;
    this.descrizione = descrizione;
    this.gerarchiaId = gerarchiaId;
    this.padreId = padreId;
    this.layoutesl = layoutesl;
    this.gruppo = gruppo;
    this.descrizioneBreve = descrizioneBreve;
    this.unitaDiMisura = unitaDiMisura;
    this.quantita = quantita;
    this.scortaMinima = scortaMinima;
    this.deposito = deposito;
    this.scaffale = scaffale;
    this.superficieEspositiva = superficieEspositiva;
    this.quantitaImpegnata = quantitaImpegnata;
    this.scortaMassima = scortaMassima;
    this.layoutEtichetta = layoutEtichetta;
    this.tipoProdotto = tipoProdotto;
    this.numeroEtichette = numeroEtichette;
    this.tipoScaricoVenduto = tipoScaricoVenduto;
    this.fornitorePrimario = fornitorePrimario;
    this.fornitoreEtichetta = fornitoreEtichetta;
    this.posizionamento = posizionamento;
    this.stagionalita = stagionalita;
    this.tipoProdotto2 = tipoProdotto2;
    this.svalorizzazione = svalorizzazione;
    this.cluster = cluster;
    this.assortimentoPuntoVendita = assortimentoPuntoVendita;
    this.version = version;
  }
}
