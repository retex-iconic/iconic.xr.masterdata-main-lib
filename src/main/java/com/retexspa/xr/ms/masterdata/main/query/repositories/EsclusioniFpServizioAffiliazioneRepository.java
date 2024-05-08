package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.EsclusioniFpServizioAffiliazioneQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EsclusioniFpServizioAffiliazioneRepository
    extends JpaRepository<EsclusioniFpServizioAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<EsclusioniFpServizioAffiliazioneQueryEntity> {
  EsclusioniFpServizioAffiliazioneQueryEntity
      findByNegozioIdAndAnagraficaServizioIdAndFormaPagamentoId(
          String negozioId, String servizioId, String formaPagId);

  EsclusioniFpServizioAffiliazioneQueryEntity
      findByFormaPagamentoIdAndAnagraficaServizioIdAndNegozioId(
          String formaPagamentoId, String anagraficaServizioId, String negozioId);

  EsclusioniFpServizioAffiliazioneQueryEntity findByEsclusioniFpServizioIdAndNegozioId(
      String esclussioneFPServizioId, String negozioId);

  EsclusioniFpServizioAffiliazioneQueryEntity findByAnagraficaServizioCodiceAndNegozioId(
      String codiceAnagraficaServizio, String negozioId);
}
