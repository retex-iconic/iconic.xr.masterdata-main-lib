package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.RepartoAffiliazioneQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RepartoAffiliazioneRepository
    extends JpaRepository<RepartoAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<RepartoAffiliazioneQueryEntity> {

  RepartoAffiliazioneQueryEntity findByCodiceAndNegozioId(String codice, String negozioId);

  RepartoAffiliazioneQueryEntity findByRepartoIdAndNegozioId(String repartoId, String negozioId);

  List<RepartoAffiliazioneQueryEntity> deleteByRepartoId(String repartoId);

  List<RepartoAffiliazioneQueryEntity> findAllByRepartoId(String repartoId);
}
