package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.ForeignKey;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import org.springframework.lang.NonNull;

@Entity
@Table(
    name = "tipo_tassonomie_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "tipo_tassonomie_affiliazioni_uk",
          columnNames = {"negozio_id", "codice"})
    },
    indexes = {
      @Index(name = "tipo_tassonomie_affiliazioni_codice", columnList = "codice"),
      @Index(name = "tipo_tassonomie_affiliazioni_index_negozio_id", columnList = "negozio_id")
    })
public class TipoTassonomiaAffiliazioneQueryEntity {

  @Id @NonNull private String id;

  @PrePersist
  public void generateId() {
    if (id == null) {
      id = UUID.randomUUID().toString();
    }
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tipo_tassonomia_id", referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_tipoTassonomia_affiliazione_tipoTassonomia"))
  private TipoTassonomiaQueryEntity tipoTassonomia;

  @Column(name = "codice")
  private String codice;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_tipoTassonomia_affiliazione_gerarchia"))
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "negozio_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_tipoTassonomia_affiliazione_negozio"))
  private NegozioQueryEntity negozio;

  public TipoTassonomiaAffiliazioneQueryEntity() {}

  public TipoTassonomiaAffiliazioneQueryEntity(
      String id,
      TipoTassonomiaQueryEntity tipoTassonomia,
      String codice,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio) {
    this.id = id;
    this.tipoTassonomia = tipoTassonomia;
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

  public TipoTassonomiaQueryEntity getTipoTassonomia() {
    return tipoTassonomia;
  }

  public void setTipoTassonomia(TipoTassonomiaQueryEntity tipoTassonomia) {
    this.tipoTassonomia = tipoTassonomia;
  }

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }
}
