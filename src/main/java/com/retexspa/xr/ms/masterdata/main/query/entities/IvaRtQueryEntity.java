package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.iva.IvaRtBaseDTO;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "ivaRt")
public class IvaRtQueryEntity {

  @Id @NonNull private String id;

  @Column(name = "codice")
  private String codice;

  @Column(name = "descrizione")
  private String descrizione;

  @Column(name = "nome")
  private String nome;

  @Column(name = "rtTipoEsenzione")
  private String rtTipoEsenzione;

  @Column(name = "rtCodiceTassa")
  private String rtTaxCode;

  @Column(name = "rtDescrizionCorta")
  private String rtShortDesc;

  @Column(name = "rtDescrizioneIntera")
  private String rtFullDesc;

  @Column(name = "tipoRt")
  private String rtType;

  @Column(name = "rtDescr")
  private String rtDescr;

  /*@Column(name = "rtAtecoNr")
  private Integer rtAtecoNr;*/

  @Column(name = "flg_cancellato")
  private String flgCancellato;

  @Column(name = "data_cancellazione")
  private LocalDateTime dataCancellazione;

  @Column(name = "version")
  private Long version;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ateco_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_iva_rt_ateco"))
  private AtecoQueryEntity ateco;

  @ManyToOne(fetch = FetchType.LAZY)
  private IvaQueryEntity iva;

  @ManyToOne(fetch = FetchType.LAZY)
  private GerarchiaQueryEntity gerarchia;

  @ManyToOne(fetch = FetchType.LAZY)
  private IvaRtQueryEntity padre;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "padre")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Set<IvaRtQueryEntity> figli;

  public IvaRtQueryEntity() {}

  public IvaRtQueryEntity(@NotNull String ivaId, IvaRtBaseDTO ivaDTO, Long version) {
    this.id = ivaId;

    this.codice = ivaDTO.getCodice();
    this.descrizione = ivaDTO.getDescrizione();

    this.rtTipoEsenzione = ivaDTO.getRtTipoEsenzione();
    this.rtTaxCode = ivaDTO.getRtTaxCode();
    this.rtShortDesc = ivaDTO.getRtShortDesc();
    this.rtFullDesc = ivaDTO.getRtFullDesc();
    this.rtType = ivaDTO.getRtType();
    this.rtDescr = ivaDTO.getRtDescr();
    this.version = version;
    // this.rtAtecoNr = ivaDTO.getRtAtecoNrId();
  }

  public String getId() {
    return this.id;
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

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getRtTipoEsenzione() {
    return rtTipoEsenzione;
  }

  public void setRtTipoEsenzione(String rtTipoEsenzione) {
    this.rtTipoEsenzione = rtTipoEsenzione;
  }

  public String getRtTaxCode() {
    return rtTaxCode;
  }

  public void setRtTaxCode(String rtTaxCode) {
    this.rtTaxCode = rtTaxCode;
  }

  public String getRtShortDesc() {
    return rtShortDesc;
  }

  public void setRtShortDesc(String rtShortDesc) {
    this.rtShortDesc = rtShortDesc;
  }

  public String getRtFullDesc() {
    return rtFullDesc;
  }

  public void setRtFullDesc(String rtFullDesc) {
    this.rtFullDesc = rtFullDesc;
  }

  public String getRtType() {
    return rtType;
  }

  public void setRtType(String rtType) {
    this.rtType = rtType;
  }

  public String getRtDescr() {
    return rtDescr;
  }

  public void setRtDescr(String rtDescr) {
    this.rtDescr = rtDescr;
  }

  public GerarchiaQueryEntity getGerarchia() {
    return gerarchia;
  }

  public void setGerarchia(GerarchiaQueryEntity gerarchia) {
    this.gerarchia = gerarchia;
  }

  public IvaRtQueryEntity getPadre() {
    return padre;
  }

  public void setPadre(IvaRtQueryEntity padre) {
    this.padre = padre;
  }

  /*public Integer getRtAtecoNr() {
      return rtAtecoNr;
    }

    public void setRtAtecoNr(Integer rtAtecoNr) {
      this.rtAtecoNr = rtAtecoNr;
    }
  */
  public IvaQueryEntity getIva() {
    return iva;
  }

  public void setIva(IvaQueryEntity iva) {
    this.iva = iva;
  }

  public Set<IvaRtQueryEntity> getFigli() {
    return figli;
  }

  public void setFigli(Set<IvaRtQueryEntity> figli) {
    this.figli = figli;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public AtecoQueryEntity getAteco() {
    return ateco;
  }

  public void setAteco(AtecoQueryEntity ateco) {
    this.ateco = ateco;
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
