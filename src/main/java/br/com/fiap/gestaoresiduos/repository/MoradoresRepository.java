package br.com.fiap.gestaoresiduos.repository;

import br.com.fiap.gestaoresiduos.model.Moradores;
import br.com.fiap.gestaoresiduos.model.Rastreio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoradoresRepository extends JpaRepository<Moradores, Long> {

}
