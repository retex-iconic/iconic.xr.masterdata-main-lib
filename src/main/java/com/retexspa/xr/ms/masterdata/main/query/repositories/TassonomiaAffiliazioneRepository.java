package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.TassonomiaAffiliazioneQueryEntity;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TassonomiaAffiliazioneRepository
    extends JpaRepository<TassonomiaAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<TassonomiaAffiliazioneQueryEntity> {

  TassonomiaAffiliazioneQueryEntity findByCodiceAndTipoTassonomiaIdAndNegozioId(
      String codice, String tipoTassonomiaId, String negozioId);

  TassonomiaAffiliazioneQueryEntity findByCodiceAndTipoTassonomiaIdAndNodoIdAndNegozioId(
      String codice, String tipoTassonomiaId, String nodoId, String negozioId);

  TassonomiaAffiliazioneQueryEntity findByTassonomiaIdAndNegozioId(
      String tassonomiaId, String negozioId);

  List<TassonomiaAffiliazioneQueryEntity> findByTipoTassonomiaCodiceAndNegozioId(
      String codiceTipoTassonomia, String negozioId);

  //List<TassonomiaAffiliazioneQueryEntity> deleteByTassonomiaId(String id);
  @Transactional
  void deleteByTassonomiaId(String tassonomiaId);
}
