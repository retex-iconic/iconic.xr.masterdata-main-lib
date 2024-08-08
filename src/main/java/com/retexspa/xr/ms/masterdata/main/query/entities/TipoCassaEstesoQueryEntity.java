package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.retexspa.xr.ms.masterdata.main.core.dto.tipoCassaEsteso.TipoCassaEstesoBaseDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_cassa_esteso", uniqueConstraints = {
    @UniqueConstraint(name = "tipo_cassa_esteso_uk", columnNames = { "codice"})
})

@Getter
@Setter
public class TipoCassaEstesoQueryEntity {

    @Id
    @NonNull
    private String id;
    @Column(name = "codice")
    private String codice;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descrizione")
    private String descrizione;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipi_cassa_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_tipocassaesteso_tipocassa"))
    private TipiCassaQueryEntity tipiCassa;

    @Column(name = "data_cancellazione")
    private LocalDateTime dataCancellazione;
    @Column(name = "version")
    private Long version;
    @Column(name = "flgCancellato")
    private String flgCancellato;


    public TipoCassaEstesoQueryEntity() {
    }

    public TipoCassaEstesoQueryEntity(@NonNull String id, TipoCassaEstesoBaseDTO dto, Long version) {
        this.id = id;
        this.codice = dto.getCodice();
        this.nome = dto.getNome();
        this.descrizione = dto.getDescrizione();
        this.flgCancellato = dto.getFlgCancellato();
        this.version = version;
    }
}
