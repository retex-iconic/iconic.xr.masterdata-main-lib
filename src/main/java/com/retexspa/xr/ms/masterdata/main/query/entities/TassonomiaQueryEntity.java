package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.tassonomia.TassonomiaBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "tassonomie")
public class TassonomiaQueryEntity {

  @Id @NonNull private String id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "codice")
  private String codice;

  @Column(name = "descrizione")
  private String descrizione;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "nodo")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<TassonomiaQueryEntity> figli;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  private TassonomiaQueryEntity nodo;

  @ManyToOne(fetch = FetchType.LAZY)
  private TassonomiaQueryEntity padre;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tipo_tassonomia_id", referencedColumnName = "id")
  private TipoTassonomiaQueryEntity tipoTassonomia;

  @Column(name = "version")
  private Long version;

  // @OneToMany(fetch = FetchType.LAZY, mappedBy = "tassonomia")
  // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  // private Set<ArticoloTassonomiaQueryEntity> articoliTassonomia;

  public TassonomiaQueryEntity() {}

  public TassonomiaQueryEntity(
      String tassonomiaId,
      TassonomiaBaseDTO tassonomiaDTO,
      GerarchiaQueryEntity gerarchiaQueryEntity,
      Optional<TassonomiaQueryEntity> padreEntity,
      Optional<TassonomiaQueryEntity> nodoEntity,
      TipoTassonomiaQueryEntity tipoTassonomiaEntity,
      Long version)
      throws IOException {
    this.id = tassonomiaId;
    this.nome = tassonomiaDTO.getNome();
    this.descrizione = tassonomiaDTO.getDescrizione();

    if (tassonomiaDTO.getCodice() == null) {
      byte[] array = new byte[7]; // length is bounded by 7
      new Random().nextBytes(array);
      String codiceRandom = new String(array, Charset.forName("UTF-8"));
      this.codice = codiceRandom;
    } else {
      this.codice = tassonomiaDTO.getCodice();
    }
    if (padreEntity.isPresent()) {
      this.padre = padreEntity.get();
    }
    if (nodoEntity.isPresent()) {
      this.nodo = nodoEntity.get();
    }
    this.gerarchia = gerarchiaQueryEntity;
    this.tipoTassonomia = tipoTassonomiaEntity;
    this.version = version;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCodice() {
    return this.codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public TassonomiaQueryEntity getNodo() {
    return this.nodo;
  }

  public void setNodo(TassonomiaQueryEntity nodo) {
    this.nodo = nodo;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public Set<TassonomiaQueryEntity> getFigli() {
    return figli;
  }

  public void setFigli(Set<TassonomiaQueryEntity> figli) {
    this.figli = figli;
  }

  public TipoTassonomiaQueryEntity getTipoTassonomia() {
    return tipoTassonomia;
  }

  public void setTipoTassonomia(TipoTassonomiaQueryEntity tipoTassonomia) {
    this.tipoTassonomia = tipoTassonomia;
  }

  public TassonomiaQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(TassonomiaQueryEntity padre) {
    this.padre = padre;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
