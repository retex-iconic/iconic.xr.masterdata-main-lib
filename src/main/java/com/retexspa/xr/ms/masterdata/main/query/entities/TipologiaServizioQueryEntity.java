package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.servizi.TipologiaServizioBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "tipologiaServizio")
public class TipologiaServizioQueryEntity {

  @Id @NonNull private String id;

  @Column(name = "codice")
  private String codice;

  @Column(name = "nome")
  private String nome;

  @Column(name = "descrizione")
  private String descrizione;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  private TipologiaServizioQueryEntity padre;

  @Column(name = "numMaxInScontrino")
  private Integer numMaxInScontrino;

  @Column(name = "valMaxInScontrino")
  private Double valMaxInScontrino;

  @Column(name = "version")
  private Long version;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "padre")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<TipologiaServizioQueryEntity> figli;

  public TipologiaServizioQueryEntity(
          @NotNull String id, TipologiaServizioBaseDTO tipologiaServizioDTO, Long version) {
    this.id = id;
    this.numMaxInScontrino = tipologiaServizioDTO.getNumMaxInScontrino();
    this.valMaxInScontrino = tipologiaServizioDTO.getValMaxInScontrino();
    this.version = version;
  }

  public TipologiaServizioQueryEntity() {}

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

  public Integer getNumMaxInScontrino() {
    return numMaxInScontrino;
  }

  public void setNumMaxInScontrino(Integer numMaxInScontrino) {
    this.numMaxInScontrino = numMaxInScontrino;
  }

  public Double getValMaxInScontrino() {
    return valMaxInScontrino;
  }

  public void setValMaxInScontrino(Double valMaxInScontrino) {
    this.valMaxInScontrino = valMaxInScontrino;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public TipologiaServizioQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(TipologiaServizioQueryEntity padre) {
    this.padre = padre;
  }

  public Set<TipologiaServizioQueryEntity> getFigli() {
    return figli;
  }

  public void setFigli(Set<TipologiaServizioQueryEntity> figli) {
    this.figli = figli;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
