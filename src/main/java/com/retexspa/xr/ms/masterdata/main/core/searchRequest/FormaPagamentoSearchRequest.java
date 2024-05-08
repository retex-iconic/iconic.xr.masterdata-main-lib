package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;

import java.util.List;

public class FormaPagamentoSearchRequest extends BaseSortPagination {
  private String id;
  private String codice;
  private String nome;
  private String descrizione;
  private String flgAttivo;
  private String tipoPagamentoId;
  private String gerarchiaId;
  private String padreId;
  private Long version;

  public FormaPagamentoSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String nome,
      String codice,
      String descrizione,
      String flgAttivo,
      String tipoPagamentoId,
      String gerarchiaId,
      String padreId,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.nome = nome;
    this.codice = codice;
    this.descrizione = descrizione;
    this.flgAttivo = flgAttivo;
    this.gerarchiaId = gerarchiaId;
    this.padreId = padreId;
    this.tipoPagamentoId = tipoPagamentoId;
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

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getFlgAttivo() {
    return flgAttivo;
  }

  public void setFlgAttivo(String flgAttivo) {
    this.flgAttivo = flgAttivo;
  }

  public String getTipoPagamentoId() {
    return tipoPagamentoId;
  }

  public void setTipoPagamentoId(String tipoPagamentoId) {
    this.tipoPagamentoId = tipoPagamentoId;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public String getPadreId() {
    return padreId;
  }

  public void setPadreId(String padreId) {
    this.padreId = padreId;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
