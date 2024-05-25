package br.com.fiap.gestaoresiduos.repository;

import br.com.fiap.gestaoresiduos.model.Rastreio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RastreioRepository extends JpaRepository<Rastreio, Long> {
}
