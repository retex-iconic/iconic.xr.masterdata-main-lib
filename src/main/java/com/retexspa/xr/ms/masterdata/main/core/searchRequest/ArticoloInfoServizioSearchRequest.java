package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.BaseSortPagination;

import java.util.List;

public class ArticoloInfoServizioSearchRequest extends BaseSortPagination {

  private String id;
  private String gerarchiaId;
  private String articoloId;
  private String servizioId;
  private String flgCancellato;
  private Long version;

  public ArticoloInfoServizioSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String gerarchiaId,
      String articoloId,
      String servizioId,
      String flgCancellato,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.gerarchiaId = gerarchiaId;
    this.articoloId = articoloId;
    this.servizioId = servizioId;
    this.flgCancellato = flgCancellato;
    this.version = version;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getGerarchiaId() {
    return this.gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getArticoloId() {
    return this.articoloId;
  }

  public void setArticoloId(String articoloId) {
    this.articoloId = articoloId;
  }

  public String getServizioId() {
    return this.servizioId;
  }

  public void setServizioId(String servizioId) {
    this.servizioId = servizioId;
  }

  public String getFlgCancellato() {
    return this.flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }

  public Long getVersion() {
    return this.version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
