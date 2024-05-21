package br.com.fiap.gestaoresiduos.repository;

import br.com.fiap.gestaoresiduos.model.Notificacao;
import br.com.fiap.gestaoresiduos.model.NotificacaoPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface NotificacaoRepository extends JpaRepository<Notificacao, NotificacaoPK> {
    List<Notificacao> findByDtEnvioBetween(LocalDate dataInicial, LocalDate dataFinal);
}
