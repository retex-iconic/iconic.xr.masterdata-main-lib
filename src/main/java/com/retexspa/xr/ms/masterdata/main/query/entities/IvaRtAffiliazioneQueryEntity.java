package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.util.UUID;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import lombok.NonNull;

@Entity
@Table(
    name = "ivaRt_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "ivaRt_affiliazioni_uk",
          columnNames = {"negozio_id", "iva_id", "codice"})
    },
    indexes = {
      @Index(name = "index_ivaRt_affiliazioni_ivaRt_id", columnList = "ivaRt_id"),
      @Index(name = "index_ivaRt_affiliazioni_iva_id", columnList = "iva_id"),
      @Index(name = "index_ivaRt_affiliazioni_codice", columnList = "codice"),
      @Index(name = "index_ivaRt_affiliazioni_negozio_id", columnList = "negozio_id")
    })
public class IvaRtAffiliazioneQueryEntity {
  @Id @NonNull private String id;

  @PrePersist
  public void generateId() {
    if (id == null) {
      id = UUID.randomUUID().toString();
    }
  }

  @Column(name = "codice")
  private String codice;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ivaRt_id", referencedColumnName = "id")
  private IvaRtQueryEntity ivaRt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id")
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "negozio_id", referencedColumnName = "id")
  private NegozioQueryEntity negozio;
  /*   @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ateco_id", referencedColumnName = "id")
  private AtecoQueryEntity ateco;*/
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "iva_id", referencedColumnName = "id")
  private IvaQueryEntity iva;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  public IvaRtAffiliazioneQueryEntity() {}

  public IvaRtAffiliazioneQueryEntity(
      @NonNull String id,
      String codice,
      // AtecoQueryEntity ateco,
      IvaQueryEntity iva,
      IvaRtQueryEntity ivaRt,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio) {
    this.id = id;
    this.codice = codice;
    // this.ateco = ateco;
    this.iva = iva;
    this.ivaRt = ivaRt;
    this.gerarchia = gerarchia;
    this.negozio = negozio;
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

  /*    public AtecoQueryEntity getAteco() {
      return ateco;
  }

  public void setAteco(AtecoQueryEntity ateco) {
      this.ateco = ateco;
  }*/

  public IvaQueryEntity getIva() {
    return iva;
  }

  public void setIva(IvaQueryEntity iva) {
    this.iva = iva;
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

  public IvaRtQueryEntity getIvaRt() {
    return ivaRt;
  }

  public void setIvaRt(IvaRtQueryEntity ivaRt) {
    this.ivaRt = ivaRt;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }
}
