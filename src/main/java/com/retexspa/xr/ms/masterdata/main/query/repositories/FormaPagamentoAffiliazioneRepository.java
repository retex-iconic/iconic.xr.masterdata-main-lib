package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.FormaPagamentoAffiliazioneQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoAffiliazioneRepository
    extends JpaRepository<FormaPagamentoAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<FormaPagamentoAffiliazioneQueryEntity> {
  FormaPagamentoAffiliazioneQueryEntity findByCodiceAndNegozioId(String codice, String negozioId);

  FormaPagamentoAffiliazioneQueryEntity findByFormaPagamentoIdAndNegozioId(
      String formaPagamentoId, String negozioId);

  List<FormaPagamentoAffiliazioneQueryEntity> deleteByFormaPagamentoId(String id);
}
