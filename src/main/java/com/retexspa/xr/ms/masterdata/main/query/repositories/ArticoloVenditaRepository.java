package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.ArticoloVenditaQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticoloVenditaRepository
    extends JpaRepository<ArticoloVenditaQueryEntity, String>,
        JpaSpecificationExecutor<ArticoloVenditaQueryEntity> {

  List<ArticoloVenditaQueryEntity> findAllByArticoloId(String articoloId);
}
