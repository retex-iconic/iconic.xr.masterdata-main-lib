package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.FormaPagamentoCassaAffiliazioneQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoCassaAffiliazioneRepository
    extends JpaRepository<FormaPagamentoCassaAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<FormaPagamentoCassaAffiliazioneQueryEntity> {

  FormaPagamentoCassaAffiliazioneQueryEntity findByXx1mtyAndXx1mnrAndNegozioId(
      Integer xx1mty, Integer xx1mnr, String negozioId);

  FormaPagamentoCassaAffiliazioneQueryEntity findByFormaPagamentoCassaIdAndNegozioId(
      String formaPagamentoCassaId, String negozioId);
}
