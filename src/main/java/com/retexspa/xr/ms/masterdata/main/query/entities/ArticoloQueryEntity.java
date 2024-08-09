package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.articolo.ArticoloBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "articoli", uniqueConstraints = {
        @UniqueConstraint(name = "articoli_uk", columnNames = { "codice","gerarchia_id" })})
public class ArticoloQueryEntity {

  @Id @NonNull private String id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "codice")
  private String codice;

  @Column(name = "descrizione")
  private String descrizione;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "padre")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<ArticoloQueryEntity> figli;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_articoli_gerarchia"))
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "padre_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_articoli_padre"))
  private ArticoloQueryEntity padre;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "articolo")
  @JsonIgnore
  private Set<ArticoloEanQueryEntity> ean;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "articolo")
  @JsonIgnore
  private Set<ArticoloNastroPrezziQueryEntity> nastroPrezzi;

  //@OneToMany(fetch = FetchType.LAZY, mappedBy = "articolo")
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "articolo", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<ArticoloTassonomiaQueryEntity> articoloTassonomia;

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  @Column(name = "data_cancellazione")
  private LocalDateTime dataCancellazione;

  @Column(name = "version")
  private Long version;

  @OneToMany(
      fetch = FetchType.LAZY,
      targetEntity = ArticoloVenditaQueryEntity.class,
      cascade = {CascadeType.PERSIST},
      mappedBy = "articolo")
  @JsonIgnore
  private Set<ArticoloVenditaQueryEntity> articoloVendita = new HashSet<>();

  // constructors
  public ArticoloQueryEntity() {}

  public ArticoloQueryEntity(@NotNull String articoloId, ArticoloBaseDTO articoloDTO, Long version)
      throws IOException {
    this.id = articoloId;
    this.nome = articoloDTO.getNome();
    this.codice = articoloDTO.getCodice();
    this.descrizione = articoloDTO.getDescrizione();
    this.flgCancellato = articoloDTO.getFlgCancellato();
    this.version = version;
  }

  public void addArticoloVendita(ArticoloVenditaQueryEntity codiceVenditaQueryEntity) {
    this.articoloVendita.add(codiceVenditaQueryEntity);
  }

  public void delArticoloVendita(String codiceVenditaId) {
    ArticoloVenditaQueryEntity articoloVenditaQueryEntity =
        this.articoloVendita.stream()
            .filter(a -> a.getId() == codiceVenditaId)
            .findFirst()
            .orElse(null);
    if (articoloVenditaQueryEntity != null) {
      this.articoloVendita.remove(articoloVenditaQueryEntity);
    }
  }

  // getters and setters
  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public Set<ArticoloQueryEntity> getFigli() {
    return figli;
  }

  public void setFigli(Set<ArticoloQueryEntity> figli) {
    this.figli = figli;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public ArticoloQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(ArticoloQueryEntity padre) {
    this.padre = padre;
  }

  public Set<ArticoloVenditaQueryEntity> getArticoloVendita() {
    return articoloVendita;
  }

  public void setArticoloVendita(Set<ArticoloVenditaQueryEntity> articoloVendita) {
    this.articoloVendita = articoloVendita;
  }

  public Set<ArticoloEanQueryEntity> getEan() {
    return ean;
  }

  public void setEan(Set<ArticoloEanQueryEntity> ean) {
    this.ean = ean;
  }

  public Set<ArticoloNastroPrezziQueryEntity> getNastroPrezzi() {
    return nastroPrezzi;
  }

  public void setNastroPrezzi(Set<ArticoloNastroPrezziQueryEntity> nastroPrezzi) {
    this.nastroPrezzi = nastroPrezzi;
  }

  public List<ArticoloTassonomiaQueryEntity> getArticoloTassonomia() {
    return articoloTassonomia;
  }

  public void setArticoloTassonomia(List<ArticoloTassonomiaQueryEntity> articoloTassonomia) {
    this.articoloTassonomia = articoloTassonomia;
  }

  public String getFlgCancellato() {
    return flgCancellato;
  }

  public void setFlgCancellato(String flgCancellato) {
    this.flgCancellato = flgCancellato;
  }

  public LocalDateTime getDataCancellazione() {
    return dataCancellazione;
  }

  public void setDataCancellazione(LocalDateTime dataCancellazione) {
    this.dataCancellazione = dataCancellazione;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
