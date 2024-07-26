package com.retexspa.xr.ms.masterdata.main.query.entities;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.ateco.AtecoBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "ateco", uniqueConstraints = {
    @UniqueConstraint(name = "ateco_uk", columnNames = { "codice" }),
    @UniqueConstraint(name = "ateco_nr_uk", columnNames = { "ateco_nr" })
})
public class AtecoQueryEntity {

  @Id
  @NonNull
  private String id;

  @Column(name = "ateco_nr")
  private Integer atecoNr;

  @Column(name = "codice")
  private String codice;

  @Column(name = "nome")
  private String nome;

  @Column(name = "descrizione")
  private String descrizione;

  // foreing key
  @ManyToOne(optional = true, fetch = FetchType.EAGER)
  @JoinColumn(name = "padre_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ateco_padre"))
  private AtecoQueryEntity padre;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gerarchia_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ateco_gerarchia"))
  private GerarchiaQueryEntity gerarchia;
  //

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  @Column(name = "data_cancellazione")
  private LocalDateTime dataCancellazione;

  @Column(name = "version")
  private Long version;

  public AtecoQueryEntity() {
  }

  public AtecoQueryEntity(@NotNull String atecoId, AtecoBaseDTO atecoDTO, Long version) {
    this.id = atecoId;
    this.codice = atecoDTO.getCodice();
    this.atecoNr = atecoDTO.getAtecoNr();
    /*
     * this.nome = atecoDTO.getNome();
     * this.codice = atecoDTO.getCodice();
     */
    this.descrizione = atecoDTO.getDescrizione();
    this.flgCancellato = atecoDTO.getFlgCancellato();
    this.version = version;
  }

  @NonNull
  public String getId() {
    return id;
  }

  public void setId(@NonNull String id) {
    this.id = id;
  }

  public Integer getAtecoNr() {
    return atecoNr;
  }

  public void setAtecoNr(Integer atecoNr) {
    this.atecoNr = atecoNr;
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

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public AtecoQueryEntity getPadre() {
    return this.padre;
  }

  public void setPadre(AtecoQueryEntity padre) {
    this.padre = padre;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return this.gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
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
