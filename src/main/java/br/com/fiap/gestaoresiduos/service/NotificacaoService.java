package br.com.fiap.gestaoresiduos.service;

import br.com.fiap.gestaoresiduos.model.Notificacao;
import br.com.fiap.gestaoresiduos.model.NotificacaoPK;
import br.com.fiap.gestaoresiduos.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public Notificacao gravar(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public Notificacao buscarPorId(NotificacaoPK id) {
        Optional<Notificacao> notificacaoOptional = notificacaoRepository.findById(id);
        if (notificacaoOptional.isPresent()) {
            return notificacaoOptional.get();
        } else {
            throw new RuntimeException("Notificação não encontrada");
        }
    }

    public List<Notificacao> listarTodasNotificacoes() {
        return notificacaoRepository.findAll();
    }

    public List<Notificacao> listarNotificacoesPorIntervaloDeData(LocalDate dataInicial, LocalDate dataFinal) {
        return notificacaoRepository.findByDtEnvioBetween(dataInicial, dataFinal);
    }

    public void remover(NotificacaoPK id) {
        Optional<Notificacao> notificacaoOptional = notificacaoRepository.findById(id);
        if (notificacaoOptional.isPresent()) {
            notificacaoRepository.delete(notificacaoOptional.get());
        } else {
            throw new RuntimeException("Notificação não encontrada");
        }
    }

    public Notificacao atualizar(Notificacao notificacao) {
        Optional<Notificacao> notificacaoOptional = notificacaoRepository.findById(notificacao.getId());
        if (notificacaoOptional.isPresent()) {
            return notificacaoRepository.save(notificacao);
        } else {
            throw new RuntimeException("Notificação não encontrada");
        }
    }
}