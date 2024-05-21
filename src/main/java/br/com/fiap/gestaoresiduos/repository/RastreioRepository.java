package br.com.fiap.gestaoresiduos.repository;

import br.com.fiap.gestaoresiduos.model.Rastreio;
import br.com.fiap.gestaoresiduos.model.RastreioPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RastreioRepository extends JpaRepository<Rastreio, RastreioPK> {
}
