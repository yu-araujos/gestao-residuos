package br.com.fiap.gestaoresiduos.repository;

import br.com.fiap.gestaoresiduos.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
}
