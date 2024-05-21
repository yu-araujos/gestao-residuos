package br.com.fiap.gestaoresiduos.service;

import br.com.fiap.gestaoresiduos.model.TipoNotificacao;
import br.com.fiap.gestaoresiduos.repository.TipoNotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoNotificacaoService {

    @Autowired
    private TipoNotificacaoRepository tipoNotificacaoRepository;

    public TipoNotificacao gravar(TipoNotificacao tipoNotificacao) {
        return tipoNotificacaoRepository.save(tipoNotificacao);
    }

    public TipoNotificacao buscarPorId(Long id) {
        Optional<TipoNotificacao> tipoNotificacaoOptional = tipoNotificacaoRepository.findById(id);
        if(tipoNotificacaoOptional.isPresent()) {
            return tipoNotificacaoOptional.get();
        } else {
            throw new RuntimeException("Tipo de Notificação não encontrado");
        }
    }

    public List<TipoNotificacao> listarTodosTiposNotificacao() {
        return tipoNotificacaoRepository.findAll();
    }

    public void remover(Long id) {
        Optional<TipoNotificacao> tipoNotificacaoOptional = tipoNotificacaoRepository.findById(id);
        if(tipoNotificacaoOptional.isPresent()) {
            tipoNotificacaoRepository.delete(tipoNotificacaoOptional.get());
        } else {
            throw new RuntimeException("Tipo de Notificação não encontrado");
        }
    }

    public TipoNotificacao atualizar(TipoNotificacao tipoNotificacao) {
        Optional<TipoNotificacao> tipoNotificacaoOptional = tipoNotificacaoRepository.findById(tipoNotificacao.getCdTipoNotificacao());
        if(tipoNotificacaoOptional.isPresent()) {
            return tipoNotificacaoRepository.save(tipoNotificacao);
        } else {
            throw new RuntimeException("Tipo de Notificação não encontrado");
        }
    }
}
