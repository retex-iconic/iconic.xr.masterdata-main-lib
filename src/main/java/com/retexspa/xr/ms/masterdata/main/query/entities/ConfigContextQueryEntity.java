package com.retexspa.xr.ms.masterdata.main.query.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.retexspa.xr.ms.main.core.dto.config.ConfigContextBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "configContext")
public class ConfigContextQueryEntity {

  @Id @NonNull private String id;

  @Column(name = "codice")
  private String codice;

  @Column(name = "descrizione")
  private String descrizione;

  @Column(name = "nome")
  private String nome;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  @Column(name = "version")
  private Long version;

  public ConfigContextQueryEntity() {}

  public ConfigContextQueryEntity(
      @NotNull String configContextId,
      ConfigContextBaseDTO configContextDTO,
      Long version) {
    this.id = configContextId;

    this.codice = configContextDTO.getCodice();
    this.descrizione = configContextDTO.getDescrizione();
    this.nome = configContextDTO.getNome();
    this.flgCancellato = configContextDTO.getFlgCancellato();
    this.version = version;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCodice() {
    return this.codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public String getDescrizione() {
    return this.descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
