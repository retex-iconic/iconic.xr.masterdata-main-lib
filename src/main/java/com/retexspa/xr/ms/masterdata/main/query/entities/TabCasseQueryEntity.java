package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.masterdata.main.core.dto.casse.TabCasseBaseDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter

@Table(name = "tab_casse", uniqueConstraints = {
    @UniqueConstraint(name = "tab_casse_uk", columnNames = { "codice","gerarchia_id" })})


public class TabCasseQueryEntity {
    @Id @NonNull
    private String id;
    @Column(name = "codice")
    private String codice;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "attiva")
    private Boolean attiva;

    //Foreign key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gerarchia_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_tabcasse_gerarchia"))
    private GerarchiaQueryEntity gerarchia;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoCassa_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_tabcasse_tipocassa"))
    private TipiCassaQueryEntity tipoCassa;


    @Column(name = "flg_cancellato")
    private String flgCancellato;
    @Column(name = "data_cancellazione")
    private LocalDateTime dataCancellazione;
    @Column(name = "version")
    private Long version;

    public TabCasseQueryEntity() {
    }

    public TabCasseQueryEntity(@NonNull String id, TabCasseBaseDTO tabCasseDTO, Long version) {
        this.id = id;
        this.codice = tabCasseDTO.getCodice();
        this.nome = tabCasseDTO.getNome();
        this.descrizione = tabCasseDTO.getDescrizione();
        this.attiva = tabCasseDTO.getAttiva();
        this.flgCancellato = tabCasseDTO.getFlgCancellato();
        this.version = version;
    }
}
