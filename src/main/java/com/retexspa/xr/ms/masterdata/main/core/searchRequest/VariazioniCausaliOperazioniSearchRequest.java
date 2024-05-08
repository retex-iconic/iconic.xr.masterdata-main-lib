package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;

import java.util.List;

public class VariazioniCausaliOperazioniSearchRequest extends BaseSortPagination {

  private final String id;

  private final String codice;
  private final String nome;
  private final String descrizione;
  private final String gerarchiaId;
  private final String variazioniCausaliId;
  private final String operazione;
  private final Integer priorita;
  private final String flgEsecuzioneImmediata;
  private final String flgAttivo;
  private final Long version;

  public VariazioniCausaliOperazioniSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String codice,
      String nome,
      String descrizione,
      String gerarchiaId,
      String variazioniCausaliId,
      String operazione,
      Integer priorita,
      String flgEsecuzioneImmediata,
      String flgAttivo,
      Long version) {

    super(page, limit, sort);
    this.id = id;
    this.codice = codice;
    this.nome = nome;
    this.descrizione = descrizione;
    this.gerarchiaId = gerarchiaId;
    this.variazioniCausaliId = variazioniCausaliId;
    this.operazione = operazione;
    this.priorita = priorita;
    this.flgEsecuzioneImmediata = flgEsecuzioneImmediata;
    this.flgAttivo = flgAttivo;
    this.version = version;
  }

  public String getId() {
    return id;
  }

  public String getCodice() {
    return codice;
  }

  public String getNome() {
    return nome;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public String getFlgAttivo() {
    return flgAttivo;
  }

  public String getGerarchiaId() {
    return gerarchiaId;
  }

  public String getOperazione() {
    return operazione;
  }

  public Integer getPriorita() {
    return priorita;
  }

  public String getFlgEsecuzioneImmediata() {
    return flgEsecuzioneImmediata;
  }

  public String getVariazioniCausaliId() {
    return variazioniCausaliId;
  }

  public Long getVersion() {
    return version;
  }
}
