package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;


import java.time.LocalDateTime;
import java.util.List;

public class VariazioniCausaliSearchRequest extends BaseSortPagination {

  private final String id;
  private final String codice;
  private final String nome;
  private final String description;
  private final String gerarchiaId;
  private final String tipologiaVariazione;
  private final Integer priorita;
  private final String flgAttiva;
  private final Long version;
  private final String padreId;
  private final String flgCancellato;
  private final LocalDateTime dataCancellazione;


  public VariazioniCausaliSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String nome,
      String codice,
      String description,
      String tipologiaVariazione,
      Integer priorita,
      String flgAttiva,
      String gerarchiaId,
      Long version,
      String padreId,
      String flgCancellato,
      LocalDateTime dataCancellazione) {
      String flgCancellato
      ) {

    super(page, limit, sort);
    this.id = id;
    this.nome = nome;
    this.codice = codice;
    this.description = description;
    this.gerarchiaId = gerarchiaId;
    this.tipologiaVariazione = tipologiaVariazione;
    this.priorita = priorita;
    this.flgAttiva = flgAttiva;
    this.version = version;
    this.padreId = padreId;
    this.flgCancellato = flgCancellato;
    this.dataCancellazione = dataCancellazione;
  }

  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public String getNome() {
    return nome;
  }

  public String getTipologiaVariazione() {
    return tipologiaVariazione;
  }

  public Integer getPriorita() {
    return priorita;
  }

  public String getFlgAttiva() {
    return flgAttiva;
  }

  public String getCodice() {
    return codice;
  }

  public Long getVersion() {
    return version;
  }


  public String getPadreId() {
    return this.padreId;
  }


  public String getFlgCancellato() {
    return this.flgCancellato;
  }


  public LocalDateTime getDataCancellazione() {

    return this.dataCancellazione;
  }


}
