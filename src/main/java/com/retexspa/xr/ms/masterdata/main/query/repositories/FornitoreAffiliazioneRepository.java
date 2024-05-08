package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.FornitoreAffiliazioneQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FornitoreAffiliazioneRepository
    extends JpaRepository<FornitoreAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<FornitoreAffiliazioneQueryEntity> {

  FornitoreAffiliazioneQueryEntity findByFornitoreIdAndNegozioId(
      String fornitoreId, String negozioId);

  FornitoreAffiliazioneQueryEntity findByCodiceAndNegozioId(String codice, String negozioId);
}
