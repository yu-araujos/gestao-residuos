package br.com.fiap.gestaoresiduos.repository;

import br.com.fiap.gestaoresiduos.model.StatusRastreio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRastreioRepository extends JpaRepository<StatusRastreio, Long> {
    Optional<StatusRastreio> findById(Long cdStatusRastreio);
}
