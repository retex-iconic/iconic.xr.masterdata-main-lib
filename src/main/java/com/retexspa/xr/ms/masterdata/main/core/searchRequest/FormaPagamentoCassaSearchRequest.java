package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.BaseSortPagination;

import java.util.List;

public class FormaPagamentoCassaSearchRequest extends BaseSortPagination {
  private String id;
  private String codice;
  private Integer xx1mty;
  private Integer xx1mnr;
  private String formaPagamentoId;
  private String gerarchiaId;
  private Long version;

  public FormaPagamentoCassaSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String codice,
      Integer xx1mty,
      Integer xx1mnr,
      String formaPagamentoId,
      String gerarchiaId,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.codice = codice;
    this.xx1mty = xx1mty;
    this.xx1mnr = xx1mnr;
    this.formaPagamentoId = formaPagamentoId;
    this.gerarchiaId = gerarchiaId;
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

  public Integer getXx1mty() {
    return xx1mty;
  }

  public void setXx1mty(Integer xx1mty) {
    this.xx1mty = xx1mty;
  }

  public Integer getXx1mnr() {
    return xx1mnr;
  }

  public void setXx1mnr(Integer xx1mnr) {
    this.xx1mnr = xx1mnr;
  }

  public String getFormaPagamentoId() {
    return formaPagamentoId;
  }

  public void setFormaPagamentoId(String formaPagamentoId) {
    this.formaPagamentoId = formaPagamentoId;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
