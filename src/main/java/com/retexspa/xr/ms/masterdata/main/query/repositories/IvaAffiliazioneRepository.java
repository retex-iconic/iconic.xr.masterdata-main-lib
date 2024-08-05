package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.IvaAffiliazioneQueryEntity;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IvaAffiliazioneRepository
    extends JpaRepository<IvaAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<IvaAffiliazioneQueryEntity> {
  IvaAffiliazioneQueryEntity findByCodiceAndNegozioId(String codice, String negozioId);

  IvaAffiliazioneQueryEntity findByIvaIdAndNegozioId(String ivaId, String negozioId);

  @Transactional
  List<IvaAffiliazioneQueryEntity> deleteByIvaId(String ivaId);

  List<IvaAffiliazioneQueryEntity> findAllByIvaId(String ivaId);
}
