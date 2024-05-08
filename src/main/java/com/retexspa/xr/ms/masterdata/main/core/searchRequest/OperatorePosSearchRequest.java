package com.retexspa.xr.ms.masterdata.main.core.searchRequest;

import com.retexspa.xr.ms.main.core.queries.BaseSort;
import com.retexspa.xr.ms.masterdata.main.core.queries.BaseSortPagination;

import java.util.List;

public class OperatorePosSearchRequest extends BaseSortPagination {

  private String id;
  private String nome;
  private String cognome;
  private String codice;
  private String mnemonic;
  private String password;
  private String gerarchiaId;
  private String padreId;
  private Long version;

  public OperatorePosSearchRequest(
      Integer page,
      Integer limit,
      List<BaseSort> sort,
      String id,
      String nome,
      String cognome,
      String codice,
      String mnemonic,
      String password,
      String gerarchiaId,
      String padreId,
      Long version) {
    super(page, limit, sort);
    this.id = id;
    this.nome = nome;
    this.cognome = cognome;
    this.codice = codice;
    this.mnemonic = mnemonic;
    this.password = password;
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

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public String getMnemonic() {
    return mnemonic;
  }

  public void setMnemonic(String mnemonic) {
    this.mnemonic = mnemonic;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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
