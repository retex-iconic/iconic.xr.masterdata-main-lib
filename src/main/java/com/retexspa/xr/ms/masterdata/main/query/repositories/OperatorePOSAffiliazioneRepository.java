package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.OperatorePOSAffiliazioneQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorePOSAffiliazioneRepository
    extends JpaRepository<OperatorePOSAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<OperatorePOSAffiliazioneQueryEntity> {

  OperatorePOSAffiliazioneQueryEntity findByCodiceAndNegozioId(String codice, String negozioId);

  OperatorePOSAffiliazioneQueryEntity findByOperatorePosIdAndNegozioId(
      String operatorePosId, String negozioId);

  List<OperatorePOSAffiliazioneQueryEntity> findAllByOperatorePosId(String operatorePosId);
}
