package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.operatore.OperatorePosBaseDTO;
import lombok.NonNull;

@Entity
@Table(name = "operatorePOS")
public class OperatorePOSQueryEntity {

  @Id @NonNull private String id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "cognome")
  private String cognome;

  @Column(name = "codice")
  private String codice;

  @Column(name = "mnemonic")
  private String mnemonic;

  @Column(name = "password")
  private String password;

  @ManyToOne(fetch = FetchType.LAZY)
  private OperatorePOSQueryEntity padre;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  @Column(name = "data_cancellazione")
  private LocalDateTime dataCancellazione;

  @Column(name = "version")
  private Long version;

  public OperatorePOSQueryEntity() {}

  public OperatorePOSQueryEntity(
          @NonNull String operatorePOSId, OperatorePosBaseDTO operatorePOSDTO, Long version)
      throws IOException {
    this.id = operatorePOSId;
    this.codice = operatorePOSDTO.getCodice();
    this.nome = operatorePOSDTO.getNome();
    this.cognome = operatorePOSDTO.getCognome();
    // this.codOperatore = operatorePOSDTO.getCodOperatore();
    this.mnemonic = operatorePOSDTO.getMnemonic();
    this.password = operatorePOSDTO.getPassword();
    // this.descrizione = operatorePOSDTO.getDescrizione();
    this.flgCancellato = operatorePOSDTO.getFlgCancellato();
    this.version = version;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMnemonic() {
    return this.mnemonic;
  }

  public void setMnemonic(String mnemonic) {
    this.mnemonic = mnemonic;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public OperatorePOSQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(OperatorePOSQueryEntity padre) {
    this.padre = padre;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCodice() {
    return this.codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
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
