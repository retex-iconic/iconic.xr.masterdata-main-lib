package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.retexspa.xr.ms.masterdata.main.core.dto.casse.TipiCassaBaseDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipi_cassa", uniqueConstraints = {
        @UniqueConstraint(name = "tipiCassa_uk", columnNames = { "codice" })
})

@Getter
@Setter
public class TipiCassaQueryEntity {
    @Id
    @NonNull
    private String id;
    @Column(name = "codice")
    private String codice;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "cassa_fisica")
    private Boolean cassaFisica;
    @Column(name = "flg_cancellato")
    private String flgCancellato;
    @Column(name = "data_cancellazione")
    private LocalDateTime dataCancellazione;

    @Column(name = "version")
    private Long version;

    public TipiCassaQueryEntity() {
    }

    public TipiCassaQueryEntity(@NonNull String id, TipiCassaBaseDTO tipiCassaDTO, Long version) {
        this.id = id;
        this.codice = tipiCassaDTO.getCodice();
        this.nome = tipiCassaDTO.getNome();
        this.descrizione = tipiCassaDTO.getDescrizione();
        this.cassaFisica = tipiCassaDTO.getCassaFisica();
        this.flgCancellato = tipiCassaDTO.getFlgCancellato();
        this.version = version;
    }
}
