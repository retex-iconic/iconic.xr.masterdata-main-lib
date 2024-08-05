package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(
        name = "tab_casse_affiliazioni",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "tab_casse_affiliazioni_uk",
                        columnNames = {"negozio_id", "codice"})
        },
        indexes = {
                @Index(name = "index_tab_casse_affiliazioni_tab_casse_id", columnList = "tab_casse_id"),
                @Index(name = "index_tab_casse_affiliazioni_codice", columnList = "codice"),
                @Index(name = "index_tab_casse_affiliazioni_negozio_id", columnList = "negozio_id")
        })
@Getter
@Setter
public class TabCasseAffiliazioneQueryEntity  implements Serializable {
    @Id
    @NonNull
    private String id;

    @PrePersist
    public void generateId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tab_casse_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_tabcasse_affiliazione_tabcasse"))
    private TabCasseQueryEntity tabCasse;

    @Column(name = "codice")
    private String codice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gerarchia_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_tabcasse_affiliazione_gerarchia"))
    private GerarchiaQueryEntity gerarchia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "negozio_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_tabcasse_affiliazione_negozio"))
    private NegozioQueryEntity negozio;

    @Column(name = "flg_cancellato")
    private String flgCancellato;


    public TabCasseAffiliazioneQueryEntity() {}

    public TabCasseAffiliazioneQueryEntity(
            String id,
            TabCasseQueryEntity tabCasse,
            String codice,
            GerarchiaQueryEntity gerarchia,
            NegozioQueryEntity negozio) {
        this.id = id;
        this.tabCasse = tabCasse;
        this.codice = codice;
        this.gerarchia = gerarchia;
        this.negozio = negozio;
    }

}
