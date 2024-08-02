package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.Enums;
import com.retexspa.xr.ms.masterdata.main.core.dto.variazioneLog.VariazioniCausaliBaseDTO;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "variazioni_causali", uniqueConstraints = {
  @UniqueConstraint(name = "variazioni_causali_uk", columnNames = { "codice", "tipologia_variazione", "gerarchia_id" }),
})
public class VariazioniCausaliQueryEntity {
  @Id private String id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "codice")
  private String codice;

  @Column(name = "descrizione")
  private String descrizione;

  @EnumValidator(enumClazz = Enums.TipologiaVariazione.class)
  private String tipologiaVariazione;

  private Integer priorita;

  @Column(name = "flgAttiva")
  @EnumValidator(enumClazz = Enums.CheckSN.class)
  private String flgAttiva;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "padre")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<VariazioniCausaliQueryEntity> figli;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_variazioniCausali_gerarchia"))
  private GerarchiaQueryEntity gerarchia;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "variazioniCausali")
  @JsonIgnore
  private Set<VariazioniCausaliOperazioniQueryEntity> variazioniCausaliOperazioniQueryEntities;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "variazioniCausali")
  @JsonIgnore
  private Set<VariazioniRegoleMonitoraggioQueryEntity> variazioniRegoleMonitoraggioQueryEntities;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "padre_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_variazioniCausali_padre"))
  private VariazioniCausaliQueryEntity padre;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  @Column(name = "data_cancellazione")
  private LocalDateTime dataCancellazione;

  @Column(name = "version")
  private Long version;


  public VariazioniCausaliQueryEntity() {}

  public VariazioniCausaliQueryEntity(
      @NotNull String variazioniCausaliId,
      VariazioniCausaliBaseDTO variazioniCausaliDTO,
      Long version) {
    this.id = variazioniCausaliId;
    this.nome = variazioniCausaliDTO.getNome();
    this.codice = variazioniCausaliDTO.getCodice();
    this.descrizione = variazioniCausaliDTO.getDescrizione();
    this.tipologiaVariazione = variazioniCausaliDTO.getTipologiaVariazione();
    this.priorita = variazioniCausaliDTO.getPriorita();
    this.flgAttiva = variazioniCausaliDTO.getFlgAttiva();
    this.flgCancellato = variazioniCausaliDTO.getFlgCancellato();
    this.version = version;
    this.dataCancellazione = variazioniCausaliDTO.getDataCancellazione();
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

  public Set<VariazioniCausaliQueryEntity> getFigli() {
    return figli;
  }

  public void setFigli(Set<VariazioniCausaliQueryEntity> figli) {
    this.figli = figli;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public VariazioniCausaliQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(VariazioniCausaliQueryEntity padre) {
    this.padre = padre;
  }

  public String getTipologiaVariazione() {
    return tipologiaVariazione;
  }

  public void setTipologiaVariazione(String tipologiaVariazione) {
    this.tipologiaVariazione = tipologiaVariazione;
  }

  public Integer getPriorita() {
    return priorita;
  }

  public void setPriorita(Integer priorita) {
    this.priorita = priorita;
  }

  public String getFlgAttiva() {
    return flgAttiva;
  }

  public void setFlgAttiva(String flgAttiva) {
    this.flgAttiva = flgAttiva;
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

  public Set<VariazioniCausaliOperazioniQueryEntity> getVariazioniCausaliOperazioniQueryEntities() {
    return variazioniCausaliOperazioniQueryEntities;
  }

  public void setVariazioniCausaliOperazioniQueryEntities(
      Set<VariazioniCausaliOperazioniQueryEntity> variazioniCausaliOperazioniQueryEntities) {
    this.variazioniCausaliOperazioniQueryEntities = variazioniCausaliOperazioniQueryEntities;
  }

  public Set<VariazioniRegoleMonitoraggioQueryEntity>
      getVariazioniRegoleMonitoraggioQueryEntities() {
    return variazioniRegoleMonitoraggioQueryEntities;
  }

  public void setVariazioniRegoleMonitoraggioQueryEntities(
      Set<VariazioniRegoleMonitoraggioQueryEntity> variazioniRegoleMonitoraggioQueryEntities) {
    this.variazioniRegoleMonitoraggioQueryEntities = variazioniRegoleMonitoraggioQueryEntities;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
