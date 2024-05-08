package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.main.core.queries.BaseSortPagination;

import java.util.List;

public class EsclusioniFpServizioSearchRequest extends BaseSortPagination {
  private String id;
  private String codice;
  private String descSegnalazione;
  private String flgSegnalazione;
  private Double massimaleCumulativo;
  private Double massimaleSingolo;
  private String formaPagamentoId;
  private String servizioId;
  private String gerarchiaId;
  private Long version;

  public EsclusioniFpServizioSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String codice,
      String descSegnalazione,
      String flgSegnalazione,
      Double massimaleCumulativo,
      Double massimaleSingolo,
      String formaPagamentoId,
      String servizioId,
      String gerarchiaId,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.codice = codice;
    this.descSegnalazione = descSegnalazione;
    this.flgSegnalazione = flgSegnalazione;
    this.massimaleCumulativo = massimaleCumulativo;
    this.massimaleSingolo = massimaleSingolo;
    this.formaPagamentoId = formaPagamentoId;
    this.servizioId = servizioId;
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

  public String getDescSegnalazione() {
    return descSegnalazione;
  }

  public void setDescSegnalazione(String descSegnalazione) {
    this.descSegnalazione = descSegnalazione;
  }

  public String getFlgSegnalazione() {
    return flgSegnalazione;
  }

  public void setFlgSegnalazione(String flgSegnalazione) {
    this.flgSegnalazione = flgSegnalazione;
  }

  public Double getMassimaleCumulativo() {
    return massimaleCumulativo;
  }

  public void setMassimaleCumulativo(Double massimaleCumulativo) {
    this.massimaleCumulativo = massimaleCumulativo;
  }

  public Double getMassimaleSingolo() {
    return massimaleSingolo;
  }

  public void setMassimaleSingolo(Double massimaleSingolo) {
    this.massimaleSingolo = massimaleSingolo;
  }

  public String getFormaPagamentoId() {
    return formaPagamentoId;
  }

  public void setFormaPagamentoId(String formaPagamentoId) {
    this.formaPagamentoId = formaPagamentoId;
  }

  public String getServizioId() {
    return servizioId;
  }

  public void setServizioId(String servizioId) {
    this.servizioId = servizioId;
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
