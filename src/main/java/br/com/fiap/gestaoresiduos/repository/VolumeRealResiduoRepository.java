package br.com.fiap.gestaoresiduos.repository;

import br.com.fiap.gestaoresiduos.model.VolumeRealResiduo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VolumeRealResiduoRepository extends JpaRepository<VolumeRealResiduo, Long> {
    Optional<VolumeRealResiduo> findById(Long cdVlRealResiduo);
}
