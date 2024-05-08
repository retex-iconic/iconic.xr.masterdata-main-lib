package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.TipoTassonomiaQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TipoTassonomiaRepository
    extends JpaRepository<TipoTassonomiaQueryEntity, String>,
        JpaSpecificationExecutor<TipoTassonomiaQueryEntity> {

  List<TipoTassonomiaQueryEntity> findAllByCodice(String codice);
}
