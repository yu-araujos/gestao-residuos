package br.com.fiap.gestaoresiduos.repository;

import br.com.fiap.gestaoresiduos.model.RastreamentoCaminhao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RastreamentoCaminhaoRepository extends JpaRepository<RastreamentoCaminhao, Long> {
    List<RastreamentoCaminhao> findByDtAtualizacao(LocalDate data);
}
