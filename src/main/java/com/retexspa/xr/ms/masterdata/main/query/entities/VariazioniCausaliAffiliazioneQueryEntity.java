package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.util.List;
import java.util.UUID;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import org.springframework.lang.NonNull;

@Entity
@Table(
    name = "variazioni_causali_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "variazioni_causali_affiliazioni_uk",
          columnNames = {"negozio_id", "codice", "tipologia_variazione"})
    },
    indexes = {
      @Index(
          name = "index_variazioni_causali_affiliazioni_variazioni_causali_id",
          columnList = "variazioni_causali_id"),
      @Index(name = "index_variazioni_causali_affiliazioni_codice", columnList = "codice"),
      @Index(name = "index_variazioni_causali_affiliazioni_negozio_id", columnList = "negozio_id"),
      @Index(
          name = "index_variazioni_causali_affiliazioni_tipologia_variazione",
          columnList = "tipologia_variazione")
    })
public class VariazioniCausaliAffiliazioneQueryEntity {
  @Id @NonNull private String id;

  @PrePersist
  public void generateId() {
    if (id == null) {
      id = UUID.randomUUID().toString();
    }
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_variazioniCausali_affiliazione_gerarchia"))
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "negozio_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_variazioniCausali_affiliazione_negozio"))
  private NegozioQueryEntity negozio;

  // aggregato_id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "variazioni_causali_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_variazioniCausali_affiliazione_variazioniCausali"))
  private VariazioniCausaliQueryEntity variazioniCausali;

  // UK
  @Column(name = "codice")
  @JoinColumn(name = "codice", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_variazioniCausali_affiliazione_codice"))
  private String codice;

  @Column(name = "tipologia_variazione")
  private String tipologiaVariazione;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumns({
    @JoinColumn(name = "variazioni_causali_id", referencedColumnName = "variazioni_causali_id", foreignKey = @ForeignKey(name = "fk_variazioniCausali_affiliazione_variazioniCausali")),
    @JoinColumn(name = "negozio_id", referencedColumnName = "negozio_id", foreignKey = @ForeignKey(name = "fk_variazioniCausali_affiliazione_negozio"))
  })
  private List<VariazioniCausaliOperazioniAffiliazioneQueryEntity>
      variazioniCausaliOperazioniAffiliazioneQueryEntities;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumns({
    @JoinColumn(name = "variazioni_causali_id", referencedColumnName = "variazioni_causali_id", foreignKey = @ForeignKey(name = "fk_variazioniCausali_affiliazione_variazioniCausali")),
    @JoinColumn(name = "negozio_id", referencedColumnName = "negozio_id", foreignKey = @ForeignKey(name = "fk_variazioniCausali_affiliazione_negozio"))
  })
  private List<VariazioniRegoleMonitoraggioAffiliazioneQueryEntity>
      variazioniRegoleMonitoraggioAffiliazioneQueryEntities;

  public VariazioniCausaliAffiliazioneQueryEntity() {}

  public VariazioniCausaliAffiliazioneQueryEntity(
      String id,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio,
      VariazioniCausaliQueryEntity variazioniCausali,
      String codice,
      String tipologiaVariazione) {
    this.id = id;
    this.variazioniCausali = variazioniCausali;
    this.codice = codice;
    this.gerarchia = gerarchia;
    this.negozio = negozio;
    this.tipologiaVariazione = tipologiaVariazione;
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

  public VariazioniCausaliQueryEntity getVariazioniCausali() {
    return variazioniCausali;
  }

  public void setVariazioniCausali(VariazioniCausaliQueryEntity variazioniCausali) {
    this.variazioniCausali = variazioniCausali;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }

  public String getTipologiaVariazione() {
    return tipologiaVariazione;
  }

  public void setTipologiaVariazione(String tipologiaVariazione) {
    this.tipologiaVariazione = tipologiaVariazione;
  }

  public List<VariazioniCausaliOperazioniAffiliazioneQueryEntity>
      getVariazioniCausaliOperazioniAffiliazioneQueryEntities() {
    return variazioniCausaliOperazioniAffiliazioneQueryEntities;
  }

  public void setVariazioniCausaliOperazioniAffiliazioneQueryEntities(
      List<VariazioniCausaliOperazioniAffiliazioneQueryEntity>
          variazioniCausaliOperazioniAffiliazioneQueryEntities) {
    this.variazioniCausaliOperazioniAffiliazioneQueryEntities =
        variazioniCausaliOperazioniAffiliazioneQueryEntities;
  }

  public List<VariazioniRegoleMonitoraggioAffiliazioneQueryEntity>
      getVariazioniRegoleMonitoraggioAffiliazioneQueryEntities() {
    return variazioniRegoleMonitoraggioAffiliazioneQueryEntities;
  }

  public void setVariazioniRegoleMonitoraggioAffiliazioneQueryEntities(
      List<VariazioniRegoleMonitoraggioAffiliazioneQueryEntity>
          variazioniRegoleMonitoraggioAffiliazioneQueryEntities) {
    this.variazioniRegoleMonitoraggioAffiliazioneQueryEntities =
        variazioniRegoleMonitoraggioAffiliazioneQueryEntities;
  }
}
