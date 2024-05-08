package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloTassonomiaAffiliazioneQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticoloTassonomiaAffiliazioneRepository
    extends JpaRepository<ArticoloTassonomiaAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<ArticoloTassonomiaAffiliazioneQueryEntity> {

  ArticoloTassonomiaAffiliazioneQueryEntity findByArticoloIdAndTassonomiaIdAndNegozioId(
      String articoloId, String tassonomiaId, String negozioId);

  List<ArticoloTassonomiaAffiliazioneQueryEntity> deleteByArticoloIdAndTassonomiaId(
      String articoloId, String tassonomiaId);
}
