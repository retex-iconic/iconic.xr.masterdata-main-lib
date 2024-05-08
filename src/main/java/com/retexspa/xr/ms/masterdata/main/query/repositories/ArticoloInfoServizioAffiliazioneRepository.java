package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloInfoServizioAffiliazioneQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticoloInfoServizioAffiliazioneRepository
    extends JpaRepository<ArticoloInfoServizioAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<ArticoloInfoServizioAffiliazioneQueryEntity> {

  ArticoloInfoServizioAffiliazioneQueryEntity findByArticoloIdAndNegozioId(
      String articoloId, String negozioId);

  List<ArticoloInfoServizioAffiliazioneQueryEntity> deleteByArticoloIdAndAnagraficaServizioId(
      String articoloId, String anagraficaServizioId);
}
