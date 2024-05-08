package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.OperatorePOSQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OperatorePosRepository
    extends JpaRepository<OperatorePOSQueryEntity, String>,
        JpaSpecificationExecutor<OperatorePOSQueryEntity> {
  List<OperatorePOSQueryEntity> findAllByCodice(String codice);
}
