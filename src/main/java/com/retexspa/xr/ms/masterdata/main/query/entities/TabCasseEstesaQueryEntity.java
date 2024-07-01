package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.retexspa.xr.ms.masterdata.main.core.dto.tabCasseEstesa.TabCasseEstesaBaseDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tab_casse_estesa")
@Getter
@Setter
public class TabCasseEstesaQueryEntity {

    @Id
    @NonNull
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    private TabCasseQueryEntity tabCasse;

    @Column(name = "dataInizio")
    private LocalDate dataInizio;

    @ManyToOne(fetch = FetchType.LAZY)
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
