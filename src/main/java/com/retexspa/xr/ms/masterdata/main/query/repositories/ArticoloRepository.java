package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticoloRepository
    extends JpaRepository<ArticoloQueryEntity, String>,
        JpaSpecificationExecutor<ArticoloQueryEntity> {

  List<ArticoloQueryEntity> findAllByCodice(String codice);
}
