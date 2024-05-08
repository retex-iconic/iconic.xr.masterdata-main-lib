package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.AtecoQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AtecoRepository
    extends JpaRepository<AtecoQueryEntity, String>, JpaSpecificationExecutor<AtecoQueryEntity> {
  List<AtecoQueryEntity> findAllByCodice(String codice);

  List<AtecoQueryEntity> findAllByAtecoNr(Integer atecoNr);
}
