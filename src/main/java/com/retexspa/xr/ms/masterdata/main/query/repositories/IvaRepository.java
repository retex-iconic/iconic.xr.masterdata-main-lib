package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.IvaQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IvaRepository
    extends JpaRepository<IvaQueryEntity, String>, JpaSpecificationExecutor<IvaQueryEntity> {
  IvaQueryEntity findByCodice(String codice);

  List<IvaQueryEntity> findAllByCodice(String codice);
}
