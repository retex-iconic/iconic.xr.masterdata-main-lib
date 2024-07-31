package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniRegoleMonitoraggioAffiliazioneQueryEntity;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VariazioniRegoleMonitoraggioAffiliazioneRepository
    extends JpaRepository<VariazioniRegoleMonitoraggioAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<VariazioniRegoleMonitoraggioAffiliazioneQueryEntity> {
  // find by unique keys
  VariazioniRegoleMonitoraggioAffiliazioneQueryEntity
      findBySchemaAndNomeTabellaAndNomeCampoAndRegolaConfrontoAndNegozioId(
          String schema,
          String nomeTabella,
          String nomeCampo,
          String regolaConfronto,
          String negozioId);
    
    // remove by Variazioni Causali
    @Transactional
    void deleteByVariazioniCausaliId(String variazioniCausaliId);
}
