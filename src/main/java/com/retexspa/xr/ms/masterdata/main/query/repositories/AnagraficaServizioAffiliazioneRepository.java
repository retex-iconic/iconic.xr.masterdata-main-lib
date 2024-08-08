package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.AnagraficaServizioAffiliazioneQueryEntity;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AnagraficaServizioAffiliazioneRepository
        extends JpaRepository<AnagraficaServizioAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<AnagraficaServizioAffiliazioneQueryEntity> {
    AnagraficaServizioAffiliazioneQueryEntity findByCodiceAndNegozioId(
            String codice, String negozioId);

    AnagraficaServizioAffiliazioneQueryEntity findByAnagraficaServizioIdAndNegozioId(
            String id, String negozioId);

    @Transactional
    List<AnagraficaServizioAffiliazioneQueryEntity> deleteByAnagraficaServizioId(String id);
}
