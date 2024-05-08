package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloAffiliazioneQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticoloAffiliazioneRepository
    extends JpaRepository<ArticoloAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<ArticoloAffiliazioneQueryEntity> {

  ArticoloAffiliazioneQueryEntity findByCodiceAndNegozioId(String codice, String negozioId);

  List<ArticoloAffiliazioneQueryEntity> deleteByArticoloId(String articoloId);

  List<ArticoloAffiliazioneQueryEntity> findAllByArticoloId(String articoloId);

  ArticoloAffiliazioneQueryEntity findByArticoloIdAndNegozioId(String articoloId, String negozioId);
}
