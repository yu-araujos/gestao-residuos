package br.com.fiap.gestaoresiduos.repository;

import br.com.fiap.gestaoresiduos.model.VolumeRealResiduo;
import br.com.fiap.gestaoresiduos.model.VolumeRealResiduoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolumeRealResiduoRepository extends JpaRepository<VolumeRealResiduo, VolumeRealResiduoPK> {
}
