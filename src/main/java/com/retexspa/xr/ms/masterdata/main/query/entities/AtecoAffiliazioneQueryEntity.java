package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import org.springframework.lang.NonNull;

@Entity
@Table(
    name = "ateco_affiliazioni",
    uniqueConstraints = {@UniqueConstraint(name = "ateco_affiliazione_uk", columnNames = {"negozio_id", "ateco_nr"})},
    indexes = {
      @Index(name = "index_ateco_affiliazioni_ateco_id", columnList = "ateco_id"),
      @Index(name = "index_ateco_affiliazioni_atecoNr", columnList = "ateco_nr"),
      @Index(name = "index_ateco_affiliazioni_negozio_id", columnList = "negozio_id")
    })
public class AtecoAffiliazioneQueryEntity {

  @Id @NonNull private String id;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  @PrePersist
  public void generateId() {
    if (id == null) {
      id = UUID.randomUUID().toString();
    }
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ateco_affiliazione_gerarchia"))
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "negozio_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ateco_affiliazione_negozio"))
  private NegozioQueryEntity negozio;

  // @Column(name = "ateco_id")
  // private String atecoId;
  // aggregato_id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ateco_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ateco_affiliazione_ateco"))
  private AtecoQueryEntity ateco;

  @Column(name = "ateco_nr")
  private Integer atecoNr;

  public AtecoAffiliazioneQueryEntity() {}

  public AtecoAffiliazioneQueryEntity(
      String id,
      AtecoQueryEntity ateco,
      Integer atecoNr,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio,
      String flgCancellato) {
    this.id = id;
    this.ateco = ateco;
    this.atecoNr = atecoNr;
    this.gerarchia = gerarchia;
    this.negozio = negozio;
    this.flgCancellato = flgCancellato;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AtecoQueryEntity getAteco() {
    return ateco;
  }

  public void setAteco(AtecoQueryEntity ateco) {
    this.ateco = ateco;
  }

  public Integer getAtecoNr() {
    return atecoNr;
  }

  public void setAtecoNr(Integer atecoNr) {
    this.atecoNr = atecoNr;
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

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }
}
