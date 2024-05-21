package br.com.fiap.gestaoresiduos.repository;

import br.com.fiap.gestaoresiduos.model.Moradores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradoresRepository extends JpaRepository<Moradores, Long> {
}
