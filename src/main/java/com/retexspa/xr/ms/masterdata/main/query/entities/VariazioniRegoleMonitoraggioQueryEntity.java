package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.retexspa.xr.ms.main.core.dto.Enums;
import com.retexspa.xr.ms.main.core.helpers.EnumValidator;
import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.variazioniRegoleMonitoraggio.VariazioniRegoleMonitoraggioBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "",  uniqueConstraints = {
  @UniqueConstraint(name = "schema", columnNames = { "schema" }),
  @UniqueConstraint(name = "nome_tabella", columnNames = { "nomeTabella" }),
  @UniqueConstraint(name = "nome_campo", columnNames = { "nomeCampo" }),
  @UniqueConstraint(name = "regola_confronto", columnNames = { "regolaConfronto" })
})
public class VariazioniRegoleMonitoraggioQueryEntity {

  @Id @NonNull private String id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "codice")
  private String codice;

  @Column(name = "descrizione")
  private String descrizione;

  @Column(name = "schema")
  private String schema;

  @Column(name = "nomeTabella")
  private String nomeTabella;

  @Column(name = "nomeCampo")
  private String nomeCampo;

  @Column(name = "regolaConfronto")
  private String regolaConfronto;

  @ManyToOne(fetch = FetchType.LAZY)
  private VariazioniCausaliQueryEntity variazioniCausali;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  @EnumValidator(enumClazz = Enums.CheckSN.class)
  private String flgAttiva;

  @EnumValidator(enumClazz = Enums.CheckSN.class)
  private String flgSalva;

  @EnumValidator(enumClazz = Enums.CheckSN.class)
  private String flgSalvaCancellazione;

  @ManyToOne(fetch = FetchType.LAZY)
  private VariazioniRegoleMonitoraggioQueryEntity padre;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "padre")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<VariazioniRegoleMonitoraggioQueryEntity> figli;

  @Column(name = "version")
  private Long version;

  public VariazioniRegoleMonitoraggioQueryEntity() {}

  public VariazioniRegoleMonitoraggioQueryEntity(
          @NotNull String regoleId, VariazioniRegoleMonitoraggioBaseDTO regoleDTO, Long version) {
    this.id = regoleId;
    if (regoleDTO.getCodice() == null) {
      byte[] array = new byte[7]; // length is bounded by 7
      new Random().nextBytes(array);
      String codiceRandom = new String(array, Charset.forName("UTF-8"));
      this.codice = codiceRandom;
    } else {
      this.codice = regoleDTO.getCodice();
    }
    this.nome = regoleDTO.getNome();
    this.descrizione = regoleDTO.getDescrizione();
    this.schema = regoleDTO.getSchema();
    this.nomeTabella = regoleDTO.getNomeTabella();
    this.nomeCampo = regoleDTO.getNomeCampo();
    this.regolaConfronto = regoleDTO.getRegolaConfronto();
    this.flgAttiva = regoleDTO.getFlgAttiva();
    this.flgSalva = regoleDTO.getFlgSalva();
    this.flgSalvaCancellazione = regoleDTO.getFlgSalvaCancellazione();
    this.version = version;
  }

  @NonNull
  public String getId() {
    return id;
  }

  public void setId(@NonNull String id) {
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

  public VariazioniCausaliQueryEntity getVariazioniCausali() {
    return variazioniCausali;
  }

  public void setVariazioniCausali(VariazioniCausaliQueryEntity variazioniCausali) {
    this.variazioniCausali = variazioniCausali;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public String getFlgAttiva() {
    return flgAttiva;
  }

  public void setFlgAttiva(String flgAttiva) {
    this.flgAttiva = flgAttiva;
  }

  public String getFlgSalva() {
    return flgSalva;
  }

  public void setFlgSalva(String flgSalva) {
    this.flgSalva = flgSalva;
  }

  public String getFlgSalvaCancellazione() {
    return flgSalvaCancellazione;
  }

  public void setFlgSalvaCancellazione(String flgSalvaCancellazione) {
    this.flgSalvaCancellazione = flgSalvaCancellazione;
  }

  public VariazioniRegoleMonitoraggioQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(VariazioniRegoleMonitoraggioQueryEntity padre) {
    this.padre = padre;
  }

  public Set<VariazioniRegoleMonitoraggioQueryEntity> getFigli() {
    return figli;
  }

  public void setFigli(Set<VariazioniRegoleMonitoraggioQueryEntity> figli) {
    this.figli = figli;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
