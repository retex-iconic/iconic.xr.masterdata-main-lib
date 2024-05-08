package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloEanQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticoloEanRepository
    extends JpaRepository<ArticoloEanQueryEntity, String>,
        JpaSpecificationExecutor<ArticoloEanQueryEntity> {

  List<ArticoloEanQueryEntity> findAllByCodice(String codice);
}
