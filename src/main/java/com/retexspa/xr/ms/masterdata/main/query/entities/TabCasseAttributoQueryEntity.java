package com.retexspa.xr.ms.masterdata.main.query.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.retexspa.xr.ms.main.query.entities.AttributoQueryEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(
        name = "tab_casse_attributi",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "tab_casse_attributi_uk",
                        columnNames = {"tab_casse_id", "attributo_id"})
        })
@Getter
@Setter
public class TabCasseAttributoQueryEntity {
    @Id
    @NonNull
    private String id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = TabCasseQueryEntity.class,
            cascade = {CascadeType.PERSIST})
    @JsonIgnore
    private TabCasseQueryEntity tabCasse;

    @ManyToOne(fetch = FetchType.LAZY)
    private AttributoQueryEntity attributo;

    @Column(name = "valore")
    private String valore;

    public TabCasseAttributoQueryEntity() {}

    public TabCasseAttributoQueryEntity(
            @NotNull String id,
             TabCasseQueryEntity tabCasse,
             AttributoQueryEntity attributo,
            String valore) {
        this.id = id;
        this.tabCasse = tabCasse;
        this.attributo = attributo;
        this.valore = valore;
    }

}
