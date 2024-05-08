package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.TipoPagamentoAffiliazioneQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPagamentoAffiliazioneRepository
    extends JpaRepository<TipoPagamentoAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<TipoPagamentoAffiliazioneQueryEntity> {

  TipoPagamentoAffiliazioneQueryEntity findByCodiceAndNegozioId(String codice, String negozioId);

  TipoPagamentoAffiliazioneQueryEntity findByTipoPagamentoIdAndNegozioId(
      String tipoPagamentoId, String negozioId);

  List<TipoPagamentoAffiliazioneQueryEntity> deleteByTipoPagamentoId(String id);
}
