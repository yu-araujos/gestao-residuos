package br.com.fiap.gestaoresiduos.repository;

import br.com.fiap.gestaoresiduos.model.TipoNotificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoNotificacaoRepository extends JpaRepository<TipoNotificacao, Long> {
}
