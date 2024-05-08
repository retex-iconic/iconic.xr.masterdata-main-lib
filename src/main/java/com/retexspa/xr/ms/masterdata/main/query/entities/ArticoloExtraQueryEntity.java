package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.io.IOException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.articoloExtra.ArticoloExtraBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "articoli_extra")
public class ArticoloExtraQueryEntity {

  @Id @NonNull private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  private ArticoloQueryEntity articolo;

  // @OneToMany(fetch = FetchType.EAGER, targetEntity = NegozioQueryEntity.class)
  // private List<NegozioQueryEntity> negozioIds;

  // @OneToMany(
  //     fetch = FetchType.LAZY,
  //     targetEntity = ArticoloVenditaQueryEntity.class,
  //     cascade = {CascadeType.PERSIST})
  // @JsonIgnore
  // private Set<ArticoloVenditaQueryEntity> articoloVendita = new HashSet<>();

  @Column(name = "nome")
  private String nome;

  @Column(name = "descrizione")
  private String descrizione;

  @ManyToOne(fetch = FetchType.LAZY)
  private ArticoloExtraQueryEntity padre;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  // @OneToMany(fetch = FetchType.LAZY, mappedBy = "tassonomia")
  // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  // private Set<TassonomiaQueryEntity> tassonomie;

  // @ManyToMany(
  //     fetch = FetchType.LAZY,
  //     cascade = {CascadeType.PERSIST, CascadeType.MERGE},
  //     mappedBy = "articoli")
  // @JsonIgnore
  // private Set<NegozioQueryEntity> negozi = new HashSet<>();

  @Column(name = "codice")
  private String codice;

  @Column(name = "layoutesl")
  private String layoutesl;

  @Column(name = "gruppo")
  private String gruppo;

  @Column(name = "descrizione_breve")
  private String descrizioneBreve;

  @Column(name = "unita_di_misura")
  private String unitaDiMisura;

  @Column(name = "quantita")
  private Integer quantita;

  @Column(name = "scorta_minima")
  private Integer scortaMinima;

  @Column(name = "deposito")
  private Integer deposito;

  @Column(name = "scaffale")
  private String scaffale;

  @Column(name = "superficie_espositiva")
  private Double superficieEspositiva;

  @Column(name = "quantita_impegnata")
  private Integer quantitaImpegnata;

  @Column(name = "scorta_massima")
  private Integer scortaMassima;

  @Column(name = "layout_etichetta")
  private Integer layoutEtichetta;

  @Column(name = "tipo_prodotto")
  private String tipoProdotto;

  @Column(name = "numero_etichette")
  private Integer numeroEtichette;

  @Column(name = "tipo_scarico_venduto")
  private String tipoScaricoVenduto;

  @Column(name = "fornitore_primario")
  private String fornitorePrimario;

  @Column(name = "fornitore_etichetta")
  private String fornitoreEtichetta;

  @Column(name = "posizionamento")
  private Integer posizionamento;

  @Column(name = "stagionalita")
  private Integer stagionalita;

  @Column(name = "tipo_prodotto2")
  private Integer tipoProdotto2;

  @Column(name = "svalorizzazione")
  private String svalorizzazione;

  @Column(name = "cluster")
  private String cluster;

  @Column(name = "assortimento_punto_vendita")
  private String assortimentoPuntoVendita;

  @Column(name = "version")
  private Long version;

  // constructors
  public ArticoloExtraQueryEntity() {}

  public ArticoloExtraQueryEntity(
          String articoloExtraId, ArticoloExtraBaseDTO articoloExtraDTO, Long version)
      throws IOException {
    this.id = articoloExtraId;
    this.nome = articoloExtraDTO.getNome();
    this.descrizione = articoloExtraDTO.getDescrizione();
    this.layoutesl = articoloExtraDTO.getLayoutESL();
    this.gruppo = articoloExtraDTO.getGruppo();
    this.descrizioneBreve = articoloExtraDTO.getDescrizioneBreve();
    this.unitaDiMisura = articoloExtraDTO.getUnitaDiMisura();
    this.quantita = articoloExtraDTO.getQuantita();
    this.scortaMinima = articoloExtraDTO.getScortaMinima();
    this.deposito = articoloExtraDTO.getDeposito();
    this.scaffale = articoloExtraDTO.getScaffale();
    this.superficieEspositiva = articoloExtraDTO.getSuperficieEspositiva();
    this.quantitaImpegnata = articoloExtraDTO.getQuantitaImpegnata();
    this.scortaMassima = articoloExtraDTO.getScortaMassima();
    this.layoutEtichetta = articoloExtraDTO.getLayoutEtichetta();
    this.tipoProdotto = articoloExtraDTO.getTipoProdotto();
    this.numeroEtichette = articoloExtraDTO.getNumeroEtichette();
    this.tipoScaricoVenduto = articoloExtraDTO.getTipoScaricoVenduto();
    this.fornitorePrimario = articoloExtraDTO.getFornitorePrimario();
    this.fornitoreEtichetta = articoloExtraDTO.getFornitoreEtichetta();
    this.posizionamento = articoloExtraDTO.getPosizionamento();
    this.stagionalita = articoloExtraDTO.getStagionalita();
    this.tipoProdotto2 = articoloExtraDTO.getTipoProdotto2();
    this.svalorizzazione = articoloExtraDTO.getSvalorizzazione();
    this.cluster = articoloExtraDTO.getCluster();
    this.assortimentoPuntoVendita = articoloExtraDTO.getAssortimentoPuntoVendita();
    this.version = version;
  }

  // public ArticoloExtraQueryEntity(String articoloId, ArticoloIndexDTO articoloIndexDTO)
  //     throws IOException {
  //   // ArticoloAcquistoIndexDTO articoloFornitoreDTO = new
  //   // ArticoloAcquistoIndexDTO(articoloId);

  //   // this.negozioIds = articoloIndexDTO.getNegozioIds();
  //   // this.articoloFornitoreIds = articoloFornitoreDTO.getArticoloAcquistoIds();
  // }

  // public void addArticoloVendita(ArticoloVenditaQueryEntity codiceVenditaQueryEntity) {
  //   this.articoloVendita.add(codiceVenditaQueryEntity);
  // }

  // public void delArticoloVendita(String codiceVenditaId) {
  //   ArticoloVenditaQueryEntity articoloVenditaQueryEntity =
  //       this.articoloVendita.stream()
  //           .filter(a -> a.getId() == codiceVenditaId)
  //           .findFirst()
  //           .orElse(null);
  //   if (articoloVenditaQueryEntity != null) {
  //     this.articoloVendita.remove(articoloVenditaQueryEntity);
  //   }
  // }

  // getters and setters
  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  // public void setArticoloVendita(Set<ArticoloVenditaQueryEntity> articoloVendita) {
  //   this.articoloVendita = articoloVendita;
  // }

  // public Set<ArticoloAcquistoQueryEntity> getArticoloAcquistoIds() {
  //   return this.articoloFornitoreIds;
  // }

  // public void setArticoloAcquistoIds(Set<ArticoloAcquistoQueryEntity> articoloFornitoreIds) {
  //   this.articoloFornitoreIds = articoloFornitoreIds;
  // }

  // public Set<ArticoloVenditaQueryEntity> getArticolo() {
  //   return this.articoloVendita;
  // }

  // public void setarticoloVendita(Set<ArticoloVenditaQueryEntity> articolo) {
  //   this.articoloVendita = articolo;
  // }

  // public Set<NegozioQueryEntity> getNegozi() {
  //   return this.negozi;
  // }

  // public void setNegozi(Set<NegozioQueryEntity> negozi) {
  //   this.negozi = negozi;
  // }

  public String getCodice() {
    return this.codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  // public Set<ArticoloVenditaQueryEntity> getArticoloVendita() {
  //   return this.articoloVendita;
  // }

  // public void setArticoloVendita(Set<ArticoloVenditaQueryEntity>
  // articoloVendita) {
  // this.articoloVendita = articoloVendita;
  // }

  // public void setCodiceArticoloAcquisto(Set<ArticoloMagazzinoQueryEntity>
  // codiceArticoloAcquisto) {
  // this.codiceArticoloAcquisto = codiceArticoloAcquisto;
  // }

  public ArticoloQueryEntity getArticolo() {
    return this.articolo;
  }

  public void setArticolo(ArticoloQueryEntity articolo) {
    this.articolo = articolo;
  }

  public ArticoloExtraQueryEntity getPadre() {
    return this.padre;
  }

  public void setPadre(ArticoloExtraQueryEntity padre) {
    this.padre = padre;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return this.gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public String getLayoutESL() {
    return layoutesl;
  }

  public void setLayoutESL(String layoutesl) {
    this.layoutesl = layoutesl;
  }

  public String getGruppo() {
    return gruppo;
  }

  public void setGruppo(String gruppo) {
    this.gruppo = gruppo;
  }

  public String getUnitaDiMisura() {
    return unitaDiMisura;
  }

  public void setUnitaDiMisura(String unita_di_misura) {
    this.unitaDiMisura = unita_di_misura;
  }

  public Integer getQuantita() {
    return quantita;
  }

  public void setQuantita(Integer quantita) {
    this.quantita = quantita;
  }

  public Integer getScortaMinima() {
    return scortaMinima;
  }

  public void setScortaMinima(Integer scorta_minima) {
    this.scortaMinima = scorta_minima;
  }

  public Integer getDeposito() {
    return deposito;
  }

  public void setDeposito(Integer deposito) {
    this.deposito = deposito;
  }

  public String getScaffale() {
    return scaffale;
  }

  public void setScaffale(String scaffale) {
    this.scaffale = scaffale;
  }

  public Double getSuperficieEspositiva() {
    return superficieEspositiva;
  }

  public void setSuperficieEspositiva(Double superficie_espositiva) {
    this.superficieEspositiva = superficie_espositiva;
  }

  public Integer getQuantitaImpegnata() {
    return quantitaImpegnata;
  }

  public void setQuantitaImpegnata(Integer quantita_impegnata) {
    this.quantitaImpegnata = quantita_impegnata;
  }

  public Integer getScortaMassima() {
    return scortaMassima;
  }

  public void setScortaMassima(Integer scorta_massima) {
    this.scortaMassima = scorta_massima;
  }

  public Integer getLayoutEtichetta() {
    return layoutEtichetta;
  }

  public void setLayoutEtichetta(Integer layout_etichetta) {
    this.layoutEtichetta = layout_etichetta;
  }

  public String getTipoProdotto() {
    return tipoProdotto;
  }

  public void setTipoProdotto(String tipo_prodotto) {
    this.tipoProdotto = tipo_prodotto;
  }

  public Integer getNumeroEtichette() {
    return numeroEtichette;
  }

  public void setNumeroEtichette(Integer numero_etichette) {
    this.numeroEtichette = numero_etichette;
  }

  public String getTipoScaricoVenduto() {
    return tipoScaricoVenduto;
  }

  public void setTipoScaricoVenduto(String tipo_scarico_venduto) {
    this.tipoScaricoVenduto = tipo_scarico_venduto;
  }

  public String getFornitorePrimario() {
    return fornitorePrimario;
  }

  public void setFornitorePrimario(String fornitore_primario) {
    this.fornitorePrimario = fornitore_primario;
  }

  public String getFornitoreEtichetta() {
    return fornitoreEtichetta;
  }

  public void setFornitoreEtichetta(String fornitore_etichetta) {
    this.fornitoreEtichetta = fornitore_etichetta;
  }

  public Integer getPosizionamento() {
    return posizionamento;
  }

  public void setPosizionamento(Integer posizionamento) {
    this.posizionamento = posizionamento;
  }

  public Integer getStagionalita() {
    return stagionalita;
  }

  public void setStagionalita(Integer stagionalita) {
    this.stagionalita = stagionalita;
  }

  public String getSvalorizzazione() {
    return svalorizzazione;
  }

  public void setSvalorizzazione(String svalorizzazione) {
    this.svalorizzazione = svalorizzazione;
  }

  public String getCluster() {
    return cluster;
  }

  public void setCluster(String cluster) {
    this.cluster = cluster;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescrizione() {
    return this.descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getLayoutesl() {
    return this.layoutesl;
  }

  public void setLayoutesl(String layoutesl) {
    this.layoutesl = layoutesl;
  }

  public String getDescrizioneBreve() {
    return this.descrizioneBreve;
  }

  public void setDescrizioneBreve(String descrizione_breve) {
    this.descrizioneBreve = descrizione_breve;
  }

  public Integer getTipoProdotto2() {
    return this.tipoProdotto2;
  }

  public void setTipoProdotto2(Integer tipo_prodotto2) {
    this.tipoProdotto2 = tipo_prodotto2;
  }

  public String getAssortimentoPuntoVendita() {
    return this.assortimentoPuntoVendita;
  }

  public void setAssortimentoPuntoVendita(String assortimento_punto_vendita) {
    this.assortimentoPuntoVendita = assortimento_punto_vendita;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
