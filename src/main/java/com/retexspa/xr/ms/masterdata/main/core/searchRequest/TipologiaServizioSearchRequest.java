package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;

import java.util.List;

public class TipologiaServizioSearchRequest extends BaseSortPagination {

  private String id;
  private String codice;
  private String nome;
  private String descrizione;
  private String gerarchiaId;
  private Integer numMaxInScontrino;
  private Double valMaxInScontrino;
  private Long version;

  public TipologiaServizioSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String codice,
      String nome,
      String descrizione,
      String gerarchiaId,
      Integer numMaxInScontrino,
      Double valMaxInScontrino,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.codice = codice;
    this.descrizione = descrizione;
    this.gerarchiaId = gerarchiaId;
    this.nome = nome;
    this.numMaxInScontrino = numMaxInScontrino;
    this.valMaxInScontrino = valMaxInScontrino;
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

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public void setGerarchiaId(String gerarchiaId) {
    this.gerarchiaId = gerarchiaId;
  }

  public Integer getNumMaxInScontrino() {
    return numMaxInScontrino;
  }

  public void setNumMaxInScontrino(Integer numMaxInScontrino) {
    this.numMaxInScontrino = numMaxInScontrino;
  }

  public Double getValMaxInScontrino() {
    return valMaxInScontrino;
  }

  public void setValMaxInScontrino(Double valMaxInScontrino) {
    this.valMaxInScontrino = valMaxInScontrino;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
