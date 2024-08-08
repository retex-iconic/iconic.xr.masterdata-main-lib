package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.CommissioneServizioQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommissioneServizioRepository
        extends JpaRepository<CommissioneServizioQueryEntity, String>,
        JpaSpecificationExecutor<CommissioneServizioQueryEntity> {
    List<CommissioneServizioQueryEntity> findAllByAnagraficaServizioIdAndProfilo(
            String anagraficaServizioId, String profilo);

    List<CommissioneServizioQueryEntity> findAllByAnagraficaServizioId(String Id);

}
