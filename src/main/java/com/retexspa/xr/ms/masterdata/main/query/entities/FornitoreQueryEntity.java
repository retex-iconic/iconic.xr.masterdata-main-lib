package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.fornitore.FornitoreBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "fornitori",  uniqueConstraints = {
  @UniqueConstraint(name = "fornitore_uk", columnNames = { "gerarchia_id", "codice" }),
})
public class FornitoreQueryEntity {

  @Id @NonNull private String id;

  // @OneToMany(fetch = FetchType.EAGER, targetEntity = ArticoloAcquistoQueryEntity.class)
  // private List<ArticoloAcquistoQueryEntity> articoloFornitoreIds;

  // @ManyToOne(fetch = FetchType.EAGER, targetEntity = NegozioQueryEntity.class)
  // @JoinColumn
  // private String codice;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "padre_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_fornitore_padre"))
  private FornitoreQueryEntity padre;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_fornitore_gerarchia"))
  private GerarchiaQueryEntity gerarchia;

  @Column(name = "codice")
  private String codice;

  @Column(name = "descrizione")
  private String descrizione;

  @Column(name = "numero")
  private String numero;

  @Column(name = "nome")
  private String nome;

  @Column(name = "indirizzo")
  private String indirizzo;

  @Column(name = "citta")
  private String citta;

  @Column(name = "cap")
  private String cap;

  @Column(name = "piva")
  private String piva;

  @Column(name = "magazzino")
  private String magazzino;

  @Column(name = "codiceEsterno")
  private String codiceEsterno;

  @Column(name = "ragioneSociale")
  private String ragioneSociale;

  @Column(name = "codiceFiscale")
  private String codiceFiscale;

  @Column(name = "telefono")
  private String telefono;

  @Column(name = "rank")
  private String rank;

  @Column(name = "tipocod")
  private String tipoCod;

  @Column(name = "email")
  private String email;

  @Column(name = "codiceEsterno2")
  private String codiceEsterno2;

  @Column(name = "codiceContabilita")
  private String codiceContabilita;

  @Column(name = "codicePrecedenteBackOffice")
  private String codicePrecedenteBackOffice;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "padre")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<FornitoreQueryEntity> figli;

  @Column(name = "version")
  private Long version;

  public FornitoreQueryEntity() {}

  public FornitoreQueryEntity(String fornitoreId, FornitoreBaseDTO fornitoreDTO, Long version)
      throws IOException {

    this.id = fornitoreId;
    this.codice = fornitoreDTO.getCodice();
    this.descrizione = fornitoreDTO.getDescrizione();
    this.numero = fornitoreDTO.getNumero();
    this.nome = fornitoreDTO.getNome();
    this.indirizzo = fornitoreDTO.getIndirizzo();
    this.citta = fornitoreDTO.getCitta();
    this.cap = fornitoreDTO.getCap();
    this.piva = fornitoreDTO.getPiva();
    // this.padre = fornitoreDTO.getPadreId();
    this.codiceEsterno = fornitoreDTO.getCodiceEsterno();
    this.ragioneSociale = fornitoreDTO.getRagioneSociale();
    this.codiceFiscale = fornitoreDTO.getCodiceFiscale();
    this.telefono = fornitoreDTO.getTelefono();
    this.rank = fornitoreDTO.getRank();
    this.tipoCod = fornitoreDTO.getTipocod();
    this.email = fornitoreDTO.getEmail();
    this.codiceEsterno2 = fornitoreDTO.getCodiceEsterno2();
    this.codiceContabilita = fornitoreDTO.getCodiceContabilita();
    this.codicePrecedenteBackOffice = fornitoreDTO.getCodicePrecedenteBackOffice();
    this.magazzino = fornitoreDTO.getMagazzino();
    this.version = version;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public FornitoreQueryEntity getPadre() {
    return this.padre;
  }

  public void setPadre(FornitoreQueryEntity padre) {
    this.padre = padre;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return this.gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public String getCodice() {
    return this.codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public String getNumero() {
    return this.numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getIndirizzo() {
    return this.indirizzo;
  }

  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }

  public String getCitta() {
    return this.citta;
  }

  public void setCitta(String citta) {
    this.citta = citta;
  }

  public String getCap() {
    return this.cap;
  }

  public void setCap(String cap) {
    this.cap = cap;
  }

  public String getPiva() {
    return this.piva;
  }

  public void setPiva(String piva) {
    this.piva = piva;
  }

  public String getMagazzino() {
    return this.magazzino;
  }

  public void setMagazzino(String magazzino) {
    this.magazzino = magazzino;
  }

  public String getCodiceEsterno() {
    return this.codiceEsterno;
  }

  public void setCodiceEsterno(String codiceEsterno) {
    this.codiceEsterno = codiceEsterno;
  }

  public String getRagioneSociale() {
    return this.ragioneSociale;
  }

  public void setRagioneSociale(String ragioneSociale) {
    this.ragioneSociale = ragioneSociale;
  }

  public String getCodiceFiscale() {
    return this.codiceFiscale;
  }

  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }

  public String getTelefono() {
    return this.telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getRank() {
    return this.rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  public String getTipoCod() {
    return this.tipoCod;
  }

  public void setTipoCod(String tipoCod) {
    this.tipoCod = tipoCod;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCodiceEsterno2() {
    return this.codiceEsterno2;
  }

  public void setCodiceEsterno2(String codiceEsterno2) {
    this.codiceEsterno2 = codiceEsterno2;
  }

  public String getCodiceContabilita() {
    return this.codiceContabilita;
  }

  public void setCodiceContabilita(String codiceContabilita) {
    this.codiceContabilita = codiceContabilita;
  }

  public String getCodicePrecedenteBackOffice() {
    return this.codicePrecedenteBackOffice;
  }

  public void setCodicePrecedenteBackOffice(String codicePrecedenteBackOffice) {
    this.codicePrecedenteBackOffice = codicePrecedenteBackOffice;
  }

  public String getDescrizione() {
    return this.descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public Set<FornitoreQueryEntity> getFigli() {
    return figli;
  }

  public void setFigli(Set<FornitoreQueryEntity> figli) {
    this.figli = figli;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
