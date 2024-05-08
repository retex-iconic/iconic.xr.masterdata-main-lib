package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import java.util.List;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VariazioniRegoleMonitoraggioSearchRequest extends BaseSortPagination {
  private String id;
  private String gerarchiaId;
  private String padreId;

  private String codice;
  private String nome;
  private String descrizione;
  private String schema;
  private String nomeTabella;
  private String nomeCampo;
  private String regolaConfronto;
  private String variazioniCausaliId;
  private String flgSalva;
  private String flgSalvaCancellazione;
  private String flgAttiva;
  private Long version;

  public VariazioniRegoleMonitoraggioSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String gerarchiaId,
      String padreId,
      String codice,
      String nome,
      String descrizione,
      String schema,
      String nomeTabella,
      String nomeCampo,
      String regolaConfronto,
      String variazioniCausaliId,
      String flgSalva,
      String flgSalvaCancellazione,
      String flgAttiva,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.gerarchiaId = gerarchiaId;
    this.padreId = padreId;
    this.codice = codice;
    this.nome = nome;
    this.descrizione = descrizione;
    this.schema = schema;
    this.nomeTabella = nomeTabella;
    this.nomeCampo = nomeCampo;
    this.regolaConfronto = regolaConfronto;
    this.variazioniCausaliId = variazioniCausaliId;
    this.flgSalva = flgSalva;
    this.flgSalvaCancellazione = flgSalvaCancellazione;
    this.flgAttiva = flgAttiva;
    this.version = version;
  }
}
