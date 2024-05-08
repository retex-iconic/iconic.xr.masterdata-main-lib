package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;

import java.time.LocalDateTime;
import java.util.List;

public class IvaRtSearchRequest extends BaseSortPagination {

  private String id;

  private String codice;

  private String descrizione;

  private String nome;

  private String rtTipoEsenzione;

  private String rtTaxCode;

  private String rtShortDesc;

  private String rtFullDesc;

  private String rtType;

  private String rtDescr;
  private String flgCancellato;
  private LocalDateTime dataCancellazione;
  private String atecoId;

  private String ivaId;

  private String gerarchiaId;

  private String padreId;
  private Long version;

  public IvaRtSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String codice,
      String descrizione,
      String nome,
      String rtTipoEsenzione,
      String rtTaxCode,
      String rtShortDesc,
      String rtFullDesc,
      String rtType,
      String rtDescr,
      String flgCancellato,
      LocalDateTime dataCancellazione,
      String atecoId,
      String ivaId,
      String gerarchiaId,
      String padreId,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.codice = codice;
    this.descrizione = descrizione;
    this.nome = nome;
    this.rtTipoEsenzione = rtTipoEsenzione;
    this.rtTaxCode = rtTaxCode;
    this.rtShortDesc = rtShortDesc;
    this.rtFullDesc = rtFullDesc;
    this.rtType = rtType;
    this.rtDescr = rtDescr;
    this.flgCancellato = flgCancellato;
    this.dataCancellazione = dataCancellazione;
    this.atecoId = atecoId;
    this.ivaId = ivaId;
    this.gerarchiaId = gerarchiaId;
    this.padreId = padreId;
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

  public String getRtTipoEsenzione() {
    return rtTipoEsenzione;
  }

  public void setRtTipoEsenzione(String rtTipoEsenzione) {
    this.rtTipoEsenzione = rtTipoEsenzione;
  }

  public String getRtTaxCode() {
    return rtTaxCode;
  }

  public void setRtTaxCode(String rtTaxCode) {
    this.rtTaxCode = rtTaxCode;
  }

  public String getRtShortDesc() {
    return rtShortDesc;
  }

  public void setRtShortDesc(String rtShortDesc) {
    this.rtShortDesc = rtShortDesc;
  }

  public String getRtFullDesc() {
    return rtFullDesc;
  }

  public void setRtFullDesc(String rtFullDesc) {
    this.rtFullDesc = rtFullDesc;
  }

  public String getRtType() {
    return rtType;
  }

  public void setRtType(String rtType) {
    this.rtType = rtType;
  }

  public String getRtDescr() {
    return rtDescr;
  }

  public void setRtDescr(String rtDescr) {
    this.rtDescr = rtDescr;
  }

  public String getAtecoId() {
    return atecoId;
  }

  public void setAtecoId(String atecoId) {
    this.atecoId = atecoId;
  }

  public String getIvaId() {
    return ivaId;
  }

  public void setIvaId(String ivaId) {
    this.ivaId = ivaId;
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

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }

  public LocalDateTime getDataCancellazione() {
    return dataCancellazione;
  }

  public void setDataCancellazione(LocalDateTime dataCancellazione) {
    this.dataCancellazione = dataCancellazione;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
