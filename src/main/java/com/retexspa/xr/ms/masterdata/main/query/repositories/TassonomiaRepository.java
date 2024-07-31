package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.TassonomiaQueryEntity;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TassonomiaRepository
                extends JpaRepository<TassonomiaQueryEntity, String>,
                JpaSpecificationExecutor<TassonomiaQueryEntity> {

        List<TassonomiaQueryEntity> findAllByCodice(String codice);

        List<TassonomiaQueryEntity> findAllByTipoTassonomiaId(String tipoTassonomiaId);

        List<TassonomiaQueryEntity> findAllByCodiceAndTipoTassonomiaId( String codice, String tipoTassonomiaId);

        List<TassonomiaQueryEntity> findAllByCodiceAndTipoTassonomiaIdAndNodoId( String codice, String tipoTassonomiaId, String nodoId);

        List<TassonomiaQueryEntity> findAllById(  String tassonomiaId);

        Optional<TassonomiaQueryEntity> findById(String id);

        List<TassonomiaQueryEntity> findAllByPadreId(String id);

        List<TassonomiaQueryEntity> findAllByNodoId(String id);
}
