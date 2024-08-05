package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniCausaliQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VariazioniCausaliRepository
    extends JpaRepository<VariazioniCausaliQueryEntity, String>,
        JpaSpecificationExecutor<VariazioniCausaliQueryEntity> {
  List<VariazioniCausaliQueryEntity> findAllByCodice(String codice);

  List<VariazioniCausaliQueryEntity> findAllByPadreId(String padreId);

  List<VariazioniCausaliQueryEntity> findAllByTipologiaVariazione(String codice);
  
  List<VariazioniCausaliQueryEntity> findAllByCodiceAndTipologiaVariazione(
      String codice, String tipologiaVariazioneId);
}
