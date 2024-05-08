package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.VariazioniCausaliOperazioniQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VariazioniCausaliOperazioniRepository
    extends JpaRepository<VariazioniCausaliOperazioniQueryEntity, String>,
        JpaSpecificationExecutor<VariazioniCausaliOperazioniQueryEntity> {

  List<VariazioniCausaliOperazioniQueryEntity> findAllByVariazioniCausaliIdAndOperazione(
      String variazioniCausaliId, String operazione);
}
