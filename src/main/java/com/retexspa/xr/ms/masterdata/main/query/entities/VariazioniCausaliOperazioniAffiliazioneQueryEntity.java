package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.util.UUID;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import lombok.NonNull;

@Entity
@Table(
    name = "variazioni_causali_operazioni_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "variazioni_causali_operazioni_affiliazioni_uk",
          columnNames = {"negozio_id", "variazioni_causali_id", "operazione"})
    },
    indexes = {
      @Index(
          name = "index_variazioni_causali_operazioni_affiliazioni_id",
          columnList = "variazioni_causali_operazioni_id"),
      @Index(
          name = "index_variazioni_causali_operazioni_affiliazioni_causale",
          columnList = "variazioni_causali_id"),
      @Index(
          name = "index_variazioni_causali_operazioni_affiliazioni_negozio_id",
          columnList = "negozio_id"),
      @Index(
          name = "index_variazioni_causali_operazioni_affiliazioni_operazione",
          columnList = "operazione")
    })
public class VariazioniCausaliOperazioniAffiliazioneQueryEntity {
  @Id @NonNull private String id;

  @PrePersist
  public void generateId() {
    if (id == null) {
      id = UUID.randomUUID().toString();
    }
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "variazioni_causali_operazioni_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_variazioniCausaliOperazioni_affiliazione_variazioniCausaliOperazioni"))
  private VariazioniCausaliOperazioniQueryEntity variazioniCausaliOperazioni;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_variazioniCausaliOperazioni_affiliazione_gerarchia"))
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "negozio_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_variazioniCausaliOperazioni_affiliazione_negozio"))
  private NegozioQueryEntity negozio;

  @Column(name = "operazione")
  private String operazione;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "variazioni_causali_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_variazioniCausaliOperazioni_affiliazione_variazioniCausali"))
  private VariazioniCausaliQueryEntity variazioniCausali;

  public VariazioniCausaliOperazioniAffiliazioneQueryEntity() {}

  public VariazioniCausaliOperazioniAffiliazioneQueryEntity(
      String id,
      VariazioniCausaliOperazioniQueryEntity variazioniCausaliOperazioni,
      String operazione,
      VariazioniCausaliQueryEntity variazioniCausali,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio) {
    this.id = id;
    this.variazioniCausaliOperazioni = variazioniCausaliOperazioni;
    this.operazione = operazione;
    this.gerarchia = gerarchia;
    this.negozio = negozio;
    this.variazioniCausali = variazioniCausali;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public VariazioniCausaliOperazioniQueryEntity getVariazioniCausaliOperazioni() {
    return variazioniCausaliOperazioni;
  }

  public void setVariazioniCausaliOperazioni(
      VariazioniCausaliOperazioniQueryEntity variazioniCausaliOperazioni) {
    this.variazioniCausaliOperazioni = variazioniCausaliOperazioni;
  }

  public VariazioniCausaliQueryEntity getVariazioniCausali() {
    return variazioniCausali;
  }

  public void setVariazioniCausali(VariazioniCausaliQueryEntity variazioniCausali) {
    this.variazioniCausali = variazioniCausali;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public NegozioQueryEntity getNegozio() {
    return negozio;
  }

  public void setNegozio(NegozioQueryEntity negozio) {
    this.negozio = negozio;
  }

  public String getOperazione() {
    return operazione;
  }

  public void setOperazione(String operazione) {
    this.operazione = operazione;
  }
}
