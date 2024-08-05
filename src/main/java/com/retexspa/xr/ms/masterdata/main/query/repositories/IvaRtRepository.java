package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.IvaRtQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IvaRtRepository
    extends JpaRepository<IvaRtQueryEntity, String>, JpaSpecificationExecutor<IvaRtQueryEntity> {
  IvaRtQueryEntity findByCodice(String codice);

  List<IvaRtQueryEntity> findAllByCodiceAndIvaId(String codice, String ivaId);

  List<IvaRtQueryEntity> findAllByCodice(String codice);

  List<IvaRtQueryEntity> findAllByAtecoId(String id);

  List<IvaRtQueryEntity> findAllByIvaId(String id);

  List<IvaRtQueryEntity> findAllByPadreId(String id);
}
