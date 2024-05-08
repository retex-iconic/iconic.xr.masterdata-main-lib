package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloEanAffiliazioneQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticoloEanAffiliazioneRepository
    extends JpaRepository<ArticoloEanAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<ArticoloEanAffiliazioneQueryEntity> {
  ArticoloEanAffiliazioneQueryEntity findByCodiceAndNegozioId(String codice, String negozioId);

  List<ArticoloEanAffiliazioneQueryEntity> findAllByEanId(String eanId);

  ArticoloEanAffiliazioneQueryEntity findByEanIdAndNegozioId(
      String articoloEanId, String negozioId);
}
