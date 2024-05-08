package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.iva.IvaBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "iva")
public class IvaQueryEntity {

  @Id @NonNull private String id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "codice")
  private String codice;

  @Column(name = "descrizione")
  private String descrizione;

  @Column(name = "tipoIva")
  private String tipoIva;

  @Column(name = "codiceIvaAcquisto")
  private String codIvaAcquisto;

  @Column(name = "percentuale")
  private Double percentuale;

  @Column(name = "naturaEsenzione")
  private String naturaEsenzione;

  @Column(name = "normaEsenzione")
  private String normaEsenzione;

  @Column(name = "codiceEsterno")
  private String codiceEsterno;

  @Column(name = "codiceE_commerce")
  private String codiceECommerce;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id")
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  private IvaQueryEntity padre;

  @OneToMany(mappedBy = "iva")
  @JsonManagedReference
  private Set<RepartoQueryEntity> reparto;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  @Column(name = "data_cancellazione")
  private LocalDateTime dataCancellazione;

  @Column(name = "version")
  private Long version;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "iva")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<IvaRtQueryEntity> ivaRt;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "padre")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<IvaQueryEntity> figli;

  public IvaQueryEntity() {}

  public IvaQueryEntity(@NotNull String ivaId, IvaBaseDTO ivaDTO, Long version) {
    this.id = ivaId;

    this.codice = ivaDTO.getCodice();
    this.descrizione = ivaDTO.getDescrizione();
    this.nome = ivaDTO.getNome();
    this.tipoIva = ivaDTO.getTipoIva();
    this.codIvaAcquisto = ivaDTO.getCodIvaAcquisto();
    this.percentuale = ivaDTO.getPercentuale();
    this.naturaEsenzione = ivaDTO.getNaturaEsenzione();
    this.normaEsenzione = ivaDTO.getNormaEsenzione();
    this.codiceEsterno = ivaDTO.getCodiceEsterno();
    this.codiceECommerce = ivaDTO.getCodiceECommerce();
    this.version = version;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTipoIva() {
    return tipoIva;
  }

  public void setTipoIva(String tipoIva) {
    this.tipoIva = tipoIva;
  }

  public String getCodIvaAcquisto() {
    return this.codIvaAcquisto;
  }

  public void setCodIvaAcquisto(String codIvaTl) {
    this.codIvaAcquisto = codIvaTl;
  }

  public Double getPercentuale() {
    return this.percentuale;
  }

  public void setPercentuale(Double percentuale) {
    this.percentuale = percentuale;
  }

  public String getNaturaEsenzione() {
    return this.naturaEsenzione;
  }

  public void setNaturaEsenzione(String naturaEsenzione) {
    this.naturaEsenzione = naturaEsenzione;
  }

  public String getNormaEsenzione() {
    return this.normaEsenzione;
  }

  public void setNormaEsenzione(String normaEsenzione) {
    this.normaEsenzione = normaEsenzione;
  }

  public String getCodiceEsterno() {
    return this.codiceEsterno;
  }

  public void setCodiceEsterno(String codiceEsterno) {
    this.codiceEsterno = codiceEsterno;
  }

  public String getCodiceECommerce() {
    return this.codiceECommerce;
  }

  public void setCodiceECommerce(String codiceECommerce) {
    this.codiceECommerce = codiceECommerce;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return this.gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public IvaQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(IvaQueryEntity padre) {
    this.padre = padre;
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

  public String getDescrizione() {
    return this.descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public Set<RepartoQueryEntity> getReparto() {
    return reparto;
  }

  public void setReparto(Set<RepartoQueryEntity> reparto) {
    this.reparto = reparto;
  }

  public Set<IvaQueryEntity> getFigli() {
    return figli;
  }

  public void setFigli(Set<IvaQueryEntity> figli) {
    this.figli = figli;
  }

  public Set<IvaRtQueryEntity> getIvaRt() {
    return ivaRt;
  }

  public void setIvaRt(Set<IvaRtQueryEntity> ivaRt) {
    this.ivaRt = ivaRt;
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
