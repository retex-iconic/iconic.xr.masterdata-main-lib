package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;

import java.util.List;

public class AtecoSearchRequest extends BaseSortPagination {

  private String id;
  private String codice;
  private String gerarchiaId;
  private Integer atecoNr;
  private String nome;
  private String descrizione;
  private Long version;

  public AtecoSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String codice,
      String nome,
      String descrizione,
      Integer atecoNr,
      String gerarchiaId,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.codice = codice;
    this.descrizione = descrizione;
    this.gerarchiaId = gerarchiaId;
    this.atecoNr = atecoNr;
    this.nome = nome;
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

  public Integer getAtecoNr() {
    return atecoNr;
  }

  public void setAtecoNr(Integer atecoNr) {
    this.atecoNr = atecoNr;
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

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
