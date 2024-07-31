package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.TipoTassonomiaAffiliazioneQueryEntity;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTassonomiaAffiliazioneRepository
        extends JpaRepository<TipoTassonomiaAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<TipoTassonomiaAffiliazioneQueryEntity> {

    // List<TipoTassonomiaAffiliazioneQueryEntity> deleteByTipoTassonomiaId(String
    // id);
    @Transactional
    void deleteByTipoTassonomiaId(String tipoTassonomiaId);

    TipoTassonomiaAffiliazioneQueryEntity findByCodiceAndNegozioId(String codice, String negozioId);

    TipoTassonomiaAffiliazioneQueryEntity findByTipoTassonomiaIdAndNegozioId(
            String tipoTassonomiaId, String negozioId);

}
