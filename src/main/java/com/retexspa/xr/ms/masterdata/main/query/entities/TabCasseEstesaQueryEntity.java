package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.retexspa.xr.ms.masterdata.main.core.dto.tabCasseEstesa.TabCasseEstesaBaseDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tab_casse_estesa", uniqueConstraints = {
        @UniqueConstraint(name = "tab_casse_estesa_uk", columnNames = { "tipo_cassa_esteso_id", "data_inizio" })
})

@Getter
@Setter
public class TabCasseEstesaQueryEntity {

    @Id
    @NonNull
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tab_casse_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_tabcassaestesa_tabcassa"))
    private TabCasseQueryEntity tabCasse;

    @Column(name = "data_inizio")
    private LocalDate dataInizio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_cassa_esteso_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_tabcassaestesa_tipocassaesteso"))
    private TipoCassaEstesoQueryEntity tipoCassaEsteso;

    @Column(name = "flg_cancellato")
    private String flgCancellato;

    @Column(name = "data_cancellazione")
    private LocalDateTime dataCancellazione;

    @Column(name = "version")
    private Long version;

    public TabCasseEstesaQueryEntity() {
    }

    public TabCasseEstesaQueryEntity(@NonNull String id, TabCasseEstesaBaseDTO tabCasseEstesaDTO, Long version) {
        this.id = id;
        this.dataInizio = tabCasseEstesaDTO.getDataInizio();
        this.flgCancellato = tabCasseEstesaDTO.getFlgCancellato();
        this.version = version;
    }

}
