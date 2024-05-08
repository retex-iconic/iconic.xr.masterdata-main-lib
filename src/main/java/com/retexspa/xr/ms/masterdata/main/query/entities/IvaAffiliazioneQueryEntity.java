package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import lombok.NonNull;

@Entity
@Table(
    name = "iva_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "iva_affiliazioni_uk",
          columnNames = {"negozio_id", "codice"})
    },
    indexes = {
      @Index(name = "index_iva_affiliazioni_iva_id", columnList = "iva_id"),
      @Index(name = "index_iva_affiliazioni_codice", columnList = "codice"),
      @Index(name = "index_iva_affiliazioni_negozio_id", columnList = "negozio_id")
    })
public class IvaAffiliazioneQueryEntity implements Serializable {
  @Id @NonNull private String id;

  @PrePersist
  public void generateId() {
    if (id == null) {
      id = UUID.randomUUID().toString();
    }
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "iva_id", referencedColumnName = "id")
  private IvaQueryEntity iva;

  @Column(name = "codice")
  private String codice;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id")
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "negozio_id", referencedColumnName = "id")
  private NegozioQueryEntity negozio;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumns({
    @JoinColumn(name = "iva_id", referencedColumnName = "iva_id"),
    @JoinColumn(name = "negozio_id", referencedColumnName = "negozio_id")
  })
  private Set<RepartoAffiliazioneQueryEntity> repartoAffiliazione;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumns({
    @JoinColumn(name = "iva_id", referencedColumnName = "iva_id"),
    @JoinColumn(name = "negozio_id", referencedColumnName = "negozio_id")
  })
  private Set<IvaRtAffiliazioneQueryEntity> ivaRtAffiliazione;

  public IvaAffiliazioneQueryEntity() {}

  public IvaAffiliazioneQueryEntity(
      String id,
      IvaQueryEntity iva,
      String codice,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio) {
    this.id = id;
    this.iva = iva;
    this.codice = codice;
    this.gerarchia = gerarchia;
    this.negozio = negozio;
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

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public IvaQueryEntity getIva() {
    return iva;
  }

  public void setIva(IvaQueryEntity iva) {
    this.iva = iva;
  }

  public Set<RepartoAffiliazioneQueryEntity> getRepartoAffiliazione() {
    return repartoAffiliazione;
  }

  public void setRepartoAffiliazione(Set<RepartoAffiliazioneQueryEntity> repartoAffiliazione) {
    this.repartoAffiliazione = repartoAffiliazione;
  }

  public Set<IvaRtAffiliazioneQueryEntity> getIvaRtAffiliazione() {
    return ivaRtAffiliazione;
  }

  public void setIvaRtAffiliazione(Set<IvaRtAffiliazioneQueryEntity> ivaRtAffiliazione) {
    this.ivaRtAffiliazione = ivaRtAffiliazione;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }
}
