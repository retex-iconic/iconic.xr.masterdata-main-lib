package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.variazioniCausaliOperazioni.VariazioniCausaliOperazioniBaseDTO;
import lombok.NonNull;

@Entity
@Table(name = "variazioni_causali_operazioni")
public class VariazioniCausaliOperazioniQueryEntity {
  @Id @NonNull private String id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "descrizione")
  private String descrizione;

  @Column(name = "codice")
  private String codice;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  private VariazioniCausaliQueryEntity variazioniCausali;

  @Column(name = "operazione")
  private String operazione;

  @Column(name = "priorita")
  private Integer priorita;

  @Column(name = "flgEsecuzioneImmediata")
  private String flgEsecuzioneImmediata;

  @Column(name = "flgAttivo")
  private String flgAttivo;

  @Column(name = "version")
  private Long version;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "padre")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<VariazioniCausaliOperazioniQueryEntity> figli;

  @ManyToOne(fetch = FetchType.LAZY)
  private VariazioniCausaliOperazioniQueryEntity padre;

  public VariazioniCausaliOperazioniQueryEntity() {}

  public VariazioniCausaliOperazioniQueryEntity(
          String id, VariazioniCausaliOperazioniBaseDTO variazioniCausaliOperazioniDTO, Long version) {
    this.id = id;
    this.nome = variazioniCausaliOperazioniDTO.getNome();
    this.descrizione = variazioniCausaliOperazioniDTO.getDescrizione();
    this.codice = variazioniCausaliOperazioniDTO.getCodice();
    this.operazione = variazioniCausaliOperazioniDTO.getOperazione();
    this.priorita = variazioniCausaliOperazioniDTO.getPriorita();
    this.flgEsecuzioneImmediata = variazioniCausaliOperazioniDTO.getFlgEsecuzioneImmediata();
    this.flgAttivo = variazioniCausaliOperazioniDTO.getFlgAttivo();
    this.version = version;
  }

  @NonNull
  public String getId() {
    return id;
  }

  public void setId(@NonNull String id) {
    this.id = id;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public String getOperazione() {
    return operazione;
  }

  public void setOperazione(String operazione) {
    this.operazione = operazione;
  }

  public Integer getPriorita() {
    return priorita;
  }

  public void setPriorita(Integer priorita) {
    this.priorita = priorita;
  }

  public String getFlgEsecuzioneImmediata() {
    return flgEsecuzioneImmediata;
  }

  public void setFlgEsecuzioneImmediata(String flgEsecuzioneImmediata) {
    this.flgEsecuzioneImmediata = flgEsecuzioneImmediata;
  }

  public String getFlgAttivo() {
    return flgAttivo;
  }

  public void setFlgAttivo(String flgAttivo) {
    this.flgAttivo = flgAttivo;
  }

  public VariazioniCausaliOperazioniQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(VariazioniCausaliOperazioniQueryEntity padre) {
    this.padre = padre;
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

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public Set<VariazioniCausaliOperazioniQueryEntity> getFigli() {
    return figli;
  }

  public void setFigli(Set<VariazioniCausaliOperazioniQueryEntity> figli) {
    this.figli = figli;
  }

  public VariazioniCausaliQueryEntity getVariazioniCausali() {
    return variazioniCausali;
  }

  public void setVariazioniCausali(VariazioniCausaliQueryEntity variazioniCausali) {
    this.variazioniCausali = variazioniCausali;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
