package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;

import java.util.List;

public class AttributoSearchRequest extends BaseSortPagination {

  private String id;
  private String chiave;
  private String descrizione;
  private String aggregato;
  private String checkValue;
  private Long version;

  public AttributoSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String chiave,
      String descrizione,
      String aggregato,
      String checkValue,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.chiave = chiave;
    this.descrizione = descrizione;
    this.aggregato = aggregato;
    this.checkValue = checkValue;
    this.version = version;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getChiave() {
    return this.chiave;
  }

  public void setChiave(String chiave) {
    this.chiave = chiave;
  }

  public String getDescrizione() {
    return this.descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getAggregato() {
    return this.aggregato;
  }

  public void setAggregato(String aggregato) {
    this.aggregato = aggregato;
  }

  public String getCheckValue() {
    return this.checkValue;
  }

  public void setCheckValue(String checkValue) {
    this.checkValue = checkValue;
  }

  public Long getVersion() {
    return this.version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
