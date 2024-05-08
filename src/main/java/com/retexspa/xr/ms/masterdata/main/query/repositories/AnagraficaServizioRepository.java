package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.AnagraficaServizioQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AnagraficaServizioRepository
    extends JpaRepository<AnagraficaServizioQueryEntity, String>,
        JpaSpecificationExecutor<AnagraficaServizioQueryEntity> {
  List<AnagraficaServizioQueryEntity> findAllByCodice(String codice);
}
