package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.TipologiaServizioAffiliazioneQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TipologiaServizioAffiliazioneRepository
    extends JpaRepository<TipologiaServizioAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<TipologiaServizioAffiliazioneQueryEntity> {
  TipologiaServizioAffiliazioneQueryEntity findByCodiceAndNegozioId(
      String codice, String negozioId);

  TipologiaServizioAffiliazioneQueryEntity findByTipologiaServizioIdAndNegozioId(
      String id, String negozioId);

  List<TipologiaServizioAffiliazioneQueryEntity> deleteByTipologiaServizioId(String id);
}
