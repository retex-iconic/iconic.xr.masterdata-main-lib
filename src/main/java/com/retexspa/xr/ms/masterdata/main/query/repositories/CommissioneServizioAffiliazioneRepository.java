package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.CommissioneServizioAffiliazioneQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissioneServizioAffiliazioneRepository
    extends JpaRepository<CommissioneServizioAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<CommissioneServizioAffiliazioneQueryEntity> {
  CommissioneServizioAffiliazioneQueryEntity findByNegozioIdAndAnagraficaServizioIdAndProfilo(
      String negozioId, String servizioId, String profilo);

  CommissioneServizioAffiliazioneQueryEntity findByAnagraficaServizioIdAndProfiloAndNegozioId(
      String anagraficaServizioId, String profilo, String negozioId);

  CommissioneServizioAffiliazioneQueryEntity findByCommissioneServizioIdAndNegozioId(
      String id, String negozioId);

  List<CommissioneServizioAffiliazioneQueryEntity> findByAnagraficaServizioCodiceAndNegozioId(
      @Param("codiceAnagraficaServizio") String codiceAnagraficaServizio,
      @Param("negozioId") String negozioId);
}
