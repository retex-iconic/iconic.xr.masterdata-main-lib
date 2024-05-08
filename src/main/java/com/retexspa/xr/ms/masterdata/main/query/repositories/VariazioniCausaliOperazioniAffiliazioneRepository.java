package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniCausaliOperazioniAffiliazioneQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VariazioniCausaliOperazioniAffiliazioneRepository
    extends JpaRepository<VariazioniCausaliOperazioniAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<VariazioniCausaliOperazioniAffiliazioneQueryEntity> {

  VariazioniCausaliOperazioniAffiliazioneQueryEntity
      findByNegozioIdAndVariazioniCausaliIdAndOperazione(
          String negozioId, String variazioniCausaliId, String operazione);
}
