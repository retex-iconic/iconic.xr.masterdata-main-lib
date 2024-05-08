package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.servizi.AnagraficaServizioBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "anagraficaServizio")
public class AnagraficaServizioQueryEntity {
  @Id @NonNull private String id;

  @Column(name = "codice")
  private String codice;

  @Column(name = "descrizione")
  private String descrizione;

  @Column(name = "nome")
  private String nome;

  @ManyToOne(fetch = FetchType.LAZY)
  private AnagraficaServizioQueryEntity padre;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  @Column(name = "collocazione")
  private String collocazione;

  @Column(name = "providerId")
  private String providerId;

  @ManyToOne(fetch = FetchType.LAZY)
  private TipologiaServizioQueryEntity tipologiaServizio;

  @Column(name = "fiduciaria")
  private String fiduciaria;

  @Column(name = "desScontrino")
  private String desScontrino;

  @Column(name = "serviceType")
  private String serviceType;

  @Column(name = "config")
  private String config;

  @Column(name = "version")
  private Long version;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "padre")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<AnagraficaServizioQueryEntity> figli;

  public AnagraficaServizioQueryEntity() {}

  public AnagraficaServizioQueryEntity(
          String id, AnagraficaServizioBaseDTO anagraficaServizioDTO, Long version) {
    this.id = id;
    this.collocazione = anagraficaServizioDTO.getCollocazione();
    this.fiduciaria = anagraficaServizioDTO.getFiduciaria();
    this.desScontrino = anagraficaServizioDTO.getDesScontrino();
    this.serviceType = anagraficaServizioDTO.getServiceType();
    this.config = anagraficaServizioDTO.getConfig();
    this.version = version;
  }

  @NonNull
  public String getId() {
    return id;
  }

  public void setId(@NonNull String id) {
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

  public AnagraficaServizioQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(AnagraficaServizioQueryEntity padre) {
    this.padre = padre;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public String getCollocazione() {
    return collocazione;
  }

  public void setCollocazione(String collocazione) {
    this.collocazione = collocazione;
  }

  public String getProviderId() {
    return providerId;
  }

  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }

  public TipologiaServizioQueryEntity getTipologiaServizio() {
    return tipologiaServizio;
  }

  public void setTipologiaServizio(TipologiaServizioQueryEntity tipologiaServizio) {
    this.tipologiaServizio = tipologiaServizio;
  }

  public String getFiduciaria() {
    return fiduciaria;
  }

  public void setFiduciaria(String fiduciaria) {
    this.fiduciaria = fiduciaria;
  }

  public String getDesScontrino() {
    return desScontrino;
  }

  public void setDesScontrino(String desScontrino) {
    this.desScontrino = desScontrino;
  }

  public String getServiceType() {
    return serviceType;
  }

  public void setServiceType(String serviceType) {
    this.serviceType = serviceType;
  }

  public String getConfig() {
    return config;
  }

  public void setConfig(String config) {
    this.config = config;
  }

  public Set<AnagraficaServizioQueryEntity> getFigli() {
    return figli;
  }

  public void setFigli(Set<AnagraficaServizioQueryEntity> figli) {
    this.figli = figli;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
