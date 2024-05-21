package br.com.fiap.gestaoresiduos.repository;

import br.com.fiap.gestaoresiduos.model.StatusRastreio;
import br.com.fiap.gestaoresiduos.model.StatusRastreioPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRastreioRepository extends JpaRepository<StatusRastreio, StatusRastreioPK> {
}
