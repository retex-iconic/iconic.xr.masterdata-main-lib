package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.util.UUID;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import org.springframework.lang.NonNull;

@Entity
@Table(
    name = "operatorepos_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "operatorepos_affiliazioni_uk",
          columnNames = {"negozio_id", "codice"})
    },
    indexes = {
      @Index(
          name = "index_operatorepos_affiliazioni_operatorepos_id",
          columnList = "operatorepos_id"),
      @Index(name = "index_operatorepos_affiliazioni_codice", columnList = "codice"),
      @Index(name = "index_operatorepos_affiliazioni_negozio_id", columnList = "negozio_id")
    })
public class OperatorePOSAffiliazioneQueryEntity {
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
  @JoinColumn(name = "operatorepos_id", referencedColumnName = "id")
  private OperatorePOSQueryEntity operatorePos;

  // UK
  @Column(name = "codice")
  private String codice;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  public OperatorePOSAffiliazioneQueryEntity() {}

  public OperatorePOSAffiliazioneQueryEntity(
      String id,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio,
      OperatorePOSQueryEntity operatorePos,
      String codice,
      String flgCancellato) {
    this.id = id;
    this.operatorePos = operatorePos;
    this.codice = codice;
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

  public OperatorePOSQueryEntity getOperatorePos() {
    return operatorePos;
  }

  public void setOperatorePos(OperatorePOSQueryEntity operatorePos) {
    this.operatorePos = operatorePos;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }
}
