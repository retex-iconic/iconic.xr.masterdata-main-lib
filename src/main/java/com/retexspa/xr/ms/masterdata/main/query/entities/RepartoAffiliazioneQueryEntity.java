package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.util.UUID;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import org.springframework.lang.NonNull;

@Entity
@Table(
    name = "reparto_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "reparto_affiliazioni_uk",
          columnNames = {"negozio_id", "codice"})
    },
    indexes = {
      @Index(name = "index_reparto_affiliazioni_reparto_id", columnList = "reparto_id"),
      @Index(name = "index_reparto_affiliazioni_codice", columnList = "codice"),
      @Index(name = "index_reparto_affiliazioni_negozio_id", columnList = "negozio_id")
    })
public class RepartoAffiliazioneQueryEntity {

  @Id @NonNull private String id;

  @PrePersist
  public void generateId() {
    if (id == null) {
      id = UUID.randomUUID().toString();
    }
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id")
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "negozio_id", referencedColumnName = "id")
  private NegozioQueryEntity negozio;

  // aggregato_id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "reparto_id", referencedColumnName = "id")
  private RepartoQueryEntity reparto;

  // UK
  @Column(name = "codice")
  private String codice;

  /*    @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "iva_id", referencedColumnName = "id")
  @JsonBackReference
  private IvaQueryEntity iva;*/

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  public RepartoAffiliazioneQueryEntity() {}

  public RepartoAffiliazioneQueryEntity(
      String id,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio,
      RepartoQueryEntity reparto,
      // IvaQueryEntity iva,
      String codice) {
    this.id = id;
    this.reparto = reparto;
    this.codice = codice;
    this.gerarchia = gerarchia;
    this.negozio = negozio;
    // this.iva = iva;
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

  public RepartoQueryEntity getReparto() {
    return reparto;
  }

  public void setReparto(RepartoQueryEntity reparto) {
    this.reparto = reparto;
  }

  /*    public IvaQueryEntity getIva() {
      return iva;
  }

  public void setIva(IvaQueryEntity iva) {
      this.iva = iva;
  }*/

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }
}
