package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.util.UUID;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import lombok.NonNull;

@Entity
@Table(
    name = "commissione_servizio_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "commissione_servizio_affiliazioni_uk",
          columnNames = {"negozio_id", "anagrafica_servizio_id", "profilo"})
    },
    indexes = {
      @Index(
          name = "index_commissione_servizio_affiliazioni_commissione_servizio_id",
          columnList = "commissione_servizio_id"),
      @Index(
          name = "index_commissione_servizio_affiliazioni_anagrafica_servizio_id",
          columnList = "anagrafica_servizio_id"),
      @Index(
          name = "index_commissione_servizio_affiliazioni_negozio_id",
          columnList = "negozio_id"),
      @Index(name = "index_commissione_servizio_affiliazioni_profilo", columnList = "profilo")
    })
public class CommissioneServizioAffiliazioneQueryEntity {
  @Id @NonNull private String id;

  @PrePersist
  public void generateId() {
    if (id == null) {
      id = UUID.randomUUID().toString();
    }
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "commissione_servizio_id", referencedColumnName = "id")
  private CommissioneServizioQueryEntity commissioneServizio;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "anagrafica_servizio_id", referencedColumnName = "id")
  private AnagraficaServizioQueryEntity anagraficaServizio;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id")
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "negozio_id", referencedColumnName = "id")
  private NegozioQueryEntity negozio;

  @Column(name = "profilo")
  private String profilo;

  public CommissioneServizioAffiliazioneQueryEntity() {}

  public CommissioneServizioAffiliazioneQueryEntity(
      String id,
      CommissioneServizioQueryEntity commissioneServizio,
      String profilo,
      AnagraficaServizioQueryEntity anagraficaServizio,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio) {
    this.id = id;
    this.commissioneServizio = commissioneServizio;
    this.profilo = profilo;
    this.gerarchia = gerarchia;
    this.negozio = negozio;
    this.anagraficaServizio = anagraficaServizio;
  }

  public String getId() {
    return id;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public NegozioQueryEntity getNegozio() {
    return negozio;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public void setNegozio(NegozioQueryEntity negozio) {
    this.negozio = negozio;
  }

  public CommissioneServizioQueryEntity getCommissioneServizio() {
    return commissioneServizio;
  }

  public void setCommissioneServizio(CommissioneServizioQueryEntity commissioneServizio) {
    this.commissioneServizio = commissioneServizio;
  }

  public AnagraficaServizioQueryEntity getAnagraficaServizio() {
    return anagraficaServizio;
  }

  public void setAnagraficaServizio(AnagraficaServizioQueryEntity anagraficaServizio) {
    this.anagraficaServizio = anagraficaServizio;
  }

  public String getProfilo() {
    return profilo;
  }

  public void setProfilo(String profilo) {
    this.profilo = profilo;
  }
}
