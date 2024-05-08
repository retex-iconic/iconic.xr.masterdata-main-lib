package com.retexspa.xr.ms.masterdata.main.core.searchRequest;


import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;

import java.util.List;

public class CommissioneServizioSearchRequest extends BaseSortPagination {

  private String id;

  private String codice;

  private String gerarchiaId;

  private String anagraficaServizioId;

  private String articoloId;

  private String flgDefault;

  private String profilo;
  private Long version;

  public CommissioneServizioSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String codice,
      String gerarchiaId,
      String anagraficaServizioId,
      String articoloId,
      String flgDefault,
      String profilo,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.codice = codice;
    this.gerarchiaId = gerarchiaId;
    this.anagraficaServizioId = anagraficaServizioId;
    this.articoloId = articoloId;
    this.flgDefault = flgDefault;
    this.profilo = profilo;
    this.version = version;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getAnagraficaServizioId() {
    return anagraficaServizioId;
  }

  public void setAnagraficaServizioId(String anagraficaServizioId) {
    this.anagraficaServizioId = anagraficaServizioId;
  }

  public String getArticoloId() {
    return articoloId;
  }

  public void setArticoloId(String articoloId) {
    this.articoloId = articoloId;
  }

  public String getFlgDefault() {
    return flgDefault;
  }

  public void setFlgDefault(String flgDefault) {
    this.flgDefault = flgDefault;
  }

  public String getProfilo() {
    return profilo;
  }

  public void setProfilo(String profilo) {
    this.profilo = profilo;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
