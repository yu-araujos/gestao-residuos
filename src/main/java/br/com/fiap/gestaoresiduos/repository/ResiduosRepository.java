package br.com.fiap.gestaoresiduos.repository;

import br.com.fiap.gestaoresiduos.model.Residuo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResiduosRepository extends JpaRepository<Residuo, Long> {
}
