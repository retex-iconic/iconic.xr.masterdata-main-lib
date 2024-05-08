package com.retexspa.xr.ms.masterdata.main.core.searchRequest;


import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;

import java.util.List;

public class MasterDataConfigSearchRequest extends BaseSortPagination {
  private String id;
  private String codice;
  private String descrizione;
  private String nome;
  private String flgAttivo;
  private String flgCancellato;
  private String nodoId;
  private String contextId;
  private Long version;

  public MasterDataConfigSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String codice,
      String descrizione,
      String nome,
      String flgAttivo,
      String flgCancellato,
      String nodoId,
      String contextId,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.codice = codice;
    this.descrizione = descrizione;
    this.nome = nome;
    this.flgAttivo = flgAttivo;
    this.flgCancellato = flgCancellato;
    this.nodoId = nodoId;
    this.contextId = contextId;
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

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getFlgAttivo() {
    return flgAttivo;
  }

  public void setFlgAttivo(String flgAttivo) {
    this.flgAttivo = flgAttivo;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }

  public String getNodoId() {
    return nodoId;
  }

  public void setNodoId(String nodoId) {
    this.nodoId = nodoId;
  }

  public String getContextId() {
    return contextId;
  }

  public void setContextId(String contextId) {
    this.contextId = contextId;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
