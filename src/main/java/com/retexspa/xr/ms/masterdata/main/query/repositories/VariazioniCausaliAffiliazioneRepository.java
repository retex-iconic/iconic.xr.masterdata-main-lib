package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniCausaliAffiliazioneQueryEntity;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VariazioniCausaliAffiliazioneRepository
    extends JpaRepository<VariazioniCausaliAffiliazioneQueryEntity, String>,
    JpaSpecificationExecutor<VariazioniCausaliAffiliazioneQueryEntity> {

    VariazioniCausaliAffiliazioneQueryEntity findByCodiceAndNegozioId(
        String codice, String negozioId)
    ;

    VariazioniCausaliAffiliazioneQueryEntity findByCodiceAndTipologiaVariazioneAndNegozioId(
        String codice, String variazioniCausaliId, String negozioId)
    ;
    
    @Transactional
    List<VariazioniCausaliAffiliazioneQueryEntity> deleteByVariazioniCausaliId(
        String variazioniCausaliId)
    ;
    
    @Transactional
    List<VariazioniCausaliAffiliazioneQueryEntity> findAllByVariazioniCausaliId(
        String variazioniCausaliId);
}
