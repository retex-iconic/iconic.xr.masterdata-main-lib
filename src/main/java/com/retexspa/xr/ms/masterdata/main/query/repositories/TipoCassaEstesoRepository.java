package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.TipoCassaEstesoQueryEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TipoCassaEstesoRepository extends JpaRepository<TipoCassaEstesoQueryEntity, String>, JpaSpecificationExecutor<TipoCassaEstesoQueryEntity> {
    List<TipoCassaEstesoQueryEntity> findAllByTipiCassa(String id);

}
