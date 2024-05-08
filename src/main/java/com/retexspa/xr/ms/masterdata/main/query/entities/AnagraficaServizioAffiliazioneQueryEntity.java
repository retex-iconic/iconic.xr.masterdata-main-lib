package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.util.UUID;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import lombok.NonNull;

@Entity
@Table(
    name = "anagrafica_servizio_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "anagrafica_servizio_affiliazioni_uk",
          columnNames = {"negozio_id", "codice"})
    },
    indexes = {
      @Index(
          name = "index_anagrafica_servizio_affiliazioni_anagrafica_servizio_id",
          columnList = "anagrafica_servizio_id"),
      @Index(name = "index_anagrafica_servizio_affiliazioni_codice", columnList = "codice"),
      @Index(name = "index_anagrafica_servizio_affiliazioni_negozio_id", columnList = "negozio_id")
    })
public class AnagraficaServizioAffiliazioneQueryEntity {

  @Id @NonNull private String id;

  @PrePersist
  public void generateId() {
    if (id == null) {
      id = UUID.randomUUID().toString();
    }
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "anagrafica_servizio_id", referencedColumnName = "id")
  private AnagraficaServizioQueryEntity anagraficaServizio;

  @Column(name = "codice")
  private String codice;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id")
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "negozio_id", referencedColumnName = "id")
  private NegozioQueryEntity negozio;

  public AnagraficaServizioAffiliazioneQueryEntity() {}

  public AnagraficaServizioAffiliazioneQueryEntity(
      String id,
      AnagraficaServizioQueryEntity anagraficaServizio,
      String codice,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio) {
    this.id = id;
    this.anagraficaServizio = anagraficaServizio;
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

  public AnagraficaServizioQueryEntity getAnagraficaServizio() {
    return anagraficaServizio;
  }

  public void setAnagraficaServizio(AnagraficaServizioQueryEntity anagraficaServizio) {
    this.anagraficaServizio = anagraficaServizio;
  }
}
