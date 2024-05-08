package com.retexspa.xr.ms.masterdata.main.query.repositories;

import com.retexspa.xr.ms.masterdata.main.query.entities.AtecoAffiliazioneQueryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AtecoAffiliazioneRepository
    extends JpaRepository<AtecoAffiliazioneQueryEntity, String>,
        JpaSpecificationExecutor<AtecoAffiliazioneQueryEntity> {

  AtecoAffiliazioneQueryEntity findByAtecoNrAndNegozioId(Integer atecoNr, String negozioId);

  AtecoAffiliazioneQueryEntity findByAtecoIdAndNegozioId(String atecoId, String negozioId);

  List<AtecoAffiliazioneQueryEntity> deleteByAtecoId(String atecoId);

  List<AtecoAffiliazioneQueryEntity> findAllByAtecoId(String atecoId);
}
