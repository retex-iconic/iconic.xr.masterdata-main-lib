package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloVenditaAffiliazioneQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticoloVenditaAffiliazioneRepository
    extends JpaRepository<ArticoloVenditaAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<ArticoloVenditaAffiliazioneQueryEntity> {

  ArticoloVenditaAffiliazioneQueryEntity findByArticoloIdAndNegozioId(
      String articoloId, String negozioId);

  List<ArticoloVenditaAffiliazioneQueryEntity> findAllByArticoloVenditaId(String articoloVenditaId);
  /*ArticoloVenditaAffiliazioneQueryEntity findByCodiceAndNegozioId(String codice, String negozioId);*/
  ArticoloVenditaAffiliazioneQueryEntity findByArticoloVenditaIdAndNegozioId(
      String articoloVenditaId, String negozioId);
}
