package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.IvaRtAffiliazioneQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IvaRtAffiliazioneRepository
    extends JpaRepository<IvaRtAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<IvaRtAffiliazioneQueryEntity> {
  IvaRtAffiliazioneQueryEntity findByCodiceAndIvaIdAndNegozioId(
      String codice, String ivaId, String negozioId);

  IvaRtAffiliazioneQueryEntity findByIvaRtIdAndNegozioId(String ivaRtId, String negozioId);

  IvaRtAffiliazioneQueryEntity findByIvaCodiceAndNegozioId(String codiceIva, String negozioId);

  IvaRtAffiliazioneQueryEntity findByIvaCodiceAndIvaRtCodiceAndNegozioId(
      String codiceIva, String codiceIvaRt, String negozioId);

  List<IvaRtAffiliazioneQueryEntity> deleteByIvaRtId(String ivaRtId);

  List<IvaRtAffiliazioneQueryEntity> findAllByIvaRtId(String ivaRtId);
}
