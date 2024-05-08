package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import java.util.List;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TassonomiaSearchRequest extends BaseSortPagination {
  private String id;
  private String nome;
  private String codice;
  private String descrizione;
  private String tipoTassonomiaId;
  private String gerarchiaId;
  private String nodoId;
  private String padreId;
  private Long version;

  public TassonomiaSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String nome,
      String codice,
      String descrizione,
      String tipoTassonomiaId,
      String gerarchiaId,
      String nodoId,
      String padreId,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.nome = nome;
    this.codice = codice;
    this.descrizione = descrizione;
    this.tipoTassonomiaId = tipoTassonomiaId;
    this.nodoId = nodoId;
    this.gerarchiaId = gerarchiaId;
    this.padreId = padreId;
    this.version = version;
  }
}
