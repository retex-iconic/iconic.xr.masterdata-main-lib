package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.TabCasseAffiliazioneQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TabCasseAffiliazioneRepository extends JpaRepository<TabCasseAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<TabCasseAffiliazioneQueryEntity> {
    TabCasseAffiliazioneQueryEntity findByCodiceAndNegozioId(String codice, String negozioId);

    TabCasseAffiliazioneQueryEntity findByTabCasseIdAndNegozioId(String ivaId, String negozioId);

        List<TabCasseAffiliazioneQueryEntity> deleteByTabCasseId(String tabCasseId);

        List<TabCasseAffiliazioneQueryEntity> findAllByTabCasseId(String tabCasseId);
}
