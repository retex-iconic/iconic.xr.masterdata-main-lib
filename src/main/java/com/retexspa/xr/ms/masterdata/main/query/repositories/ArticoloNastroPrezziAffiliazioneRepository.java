package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloNastroPrezziAffiliazioneQueryEntity;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticoloNastroPrezziAffiliazioneRepository
    extends JpaRepository<ArticoloNastroPrezziAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<ArticoloNastroPrezziAffiliazioneQueryEntity> {

  ArticoloNastroPrezziAffiliazioneQueryEntity findByArticoloIdAndDataOraInizioAndNegozioId(
      String articoloId, LocalDateTime dataOraInzio, String negozioId);

  List<ArticoloNastroPrezziAffiliazioneQueryEntity> deleteByNastroPrezziId(String nastroPrezziId);
}
