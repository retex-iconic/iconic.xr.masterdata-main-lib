package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.util.UUID;
import javax.persistence.*;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import org.springframework.lang.NonNull;

@Entity
@Table(
    name = "variazioni_regole_monitoraggio_affiliazioni",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "variazioni_regole_monitoraggio_affiliazioni_uk",
          columnNames = {"negozio_id", "schema", "nome_tabella", "nome_campo", "regola_confronto"})
    },
    indexes = {
      @Index(
          name = "index_variazioni_regole_monitoraggio_affiliazioni_regole_id",
          columnList = "variazioni_regole_monitoraggio_id"),
      @Index(
          name = "index_variazioni_regole_monitoraggio_affiliazioni_negozio_id",
          columnList = "negozio_id"),
      @Index(
          name = "index_variazioni_regole_monitoraggio_affiliazioni_schema",
          columnList = "schema"),
      @Index(
          name = "index_variazioni_regole_monitoraggio_affiliazioni_nome_tabel",
          columnList = "nome_tabella"),
      @Index(
          name = "index_variazioni_regole_monitoraggio_affiliazioni_nome_campo",
          columnList = "nome_campo"),
      @Index(
          name = "index_variazioni_regole_monitoraggio_affiliazioni_regola_cnf",
          columnList = "regola_confronto")
    })
public class VariazioniRegoleMonitoraggioAffiliazioneQueryEntity {

  @Id @NonNull private String id;

  @PrePersist
  public void generateId() {
    if (id == null) {
      id = UUID.randomUUID().toString();
    }
  }

  @Column(name = "schema")
  private String schema;

  @Column(name = "nome_tabella")
  private String nomeTabella;

  @Column(name = "nome_campo")
  private String nomeCampo;

  @Column(name = "regola_confronto")
  private String regolaConfronto;

  /*    @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "variazioni_causali_id", referencedColumnName = "id")
  private VariazioniCausaliQueryEntity causale;*/

  // aggregato_id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "variazioni_regole_monitoraggio_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_variazioniRegoleMonitoraggio_affiliazione_variazioni_regole_monitoraggio"))
  private VariazioniRegoleMonitoraggioQueryEntity variazioniRegoleMonitoraggio;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_variazioniRegoleMonitoraggio_affiliazione_gerarchia"))
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "negozio_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_variazioniRegoleMonitoraggio_affiliazione_negozio"))
  private NegozioQueryEntity negozio;

  public VariazioniRegoleMonitoraggioAffiliazioneQueryEntity() {}

  public VariazioniRegoleMonitoraggioAffiliazioneQueryEntity(
      String id,
      String schema,
      String nomeTabella,
      String nomeCampo,
      String regolaConfronto,
      /*VariazioniCausaliQueryEntity causale,*/
      VariazioniRegoleMonitoraggioQueryEntity variazioniRegoleMonitoraggio,
      GerarchiaQueryEntity gerarchia,
      NegozioQueryEntity negozio) {
    this.id = id;
    this.schema = schema;
    this.nomeTabella = nomeTabella;
    this.nomeCampo = nomeCampo;
    this.regolaConfronto = regolaConfronto;
    // this.causale = causale;
    this.variazioniRegoleMonitoraggio = variazioniRegoleMonitoraggio;
    this.gerarchia = gerarchia;
    this.negozio = negozio;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSchema() {
    return schema;
  }

  public void setSchema(String schema) {
    this.schema = schema;
  }

  public String getNomeTabella() {
    return nomeTabella;
  }

  public void setNomeTabella(String nomeTabella) {
    this.nomeTabella = nomeTabella;
  }

  public String getNomeCampo() {
    return nomeCampo;
  }

  public void setNomeCampo(String nomeCampo) {
    this.nomeCampo = nomeCampo;
  }

  public String getRegolaConfronto() {
    return regolaConfronto;
  }

  public void setRegolaConfronto(String regolaConfronto) {
    this.regolaConfronto = regolaConfronto;
  }

  public VariazioniRegoleMonitoraggioQueryEntity getVariazioniRegoleMonitoraggio() {
    return variazioniRegoleMonitoraggio;
  }

  public void setVariazioniRegoleMonitoraggio(
      VariazioniRegoleMonitoraggioQueryEntity variazioniRegoleMonitoraggio) {
    this.variazioniRegoleMonitoraggio = variazioniRegoleMonitoraggio;
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

  /* public VariazioniCausaliQueryEntity getCausale() {
      return causale;
  }

  public void setCausale(VariazioniCausaliQueryEntity causale) {
      this.causale = causale;
  }*/
}
