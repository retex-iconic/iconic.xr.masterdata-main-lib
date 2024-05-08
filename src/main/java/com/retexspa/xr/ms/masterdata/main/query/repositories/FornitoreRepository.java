package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.FornitoreQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FornitoreRepository
    extends JpaRepository<FornitoreQueryEntity, String>,
        JpaSpecificationExecutor<FornitoreQueryEntity> {
  List<FornitoreQueryEntity> findAllByCodice(String codice);
}
