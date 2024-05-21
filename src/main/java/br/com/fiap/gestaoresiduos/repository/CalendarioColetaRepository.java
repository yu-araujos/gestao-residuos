package br.com.fiap.gestaoresiduos.repository;

import br.com.fiap.gestaoresiduos.model.CalendarioColeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarioColetaRepository extends JpaRepository<CalendarioColeta, Long> {
}
