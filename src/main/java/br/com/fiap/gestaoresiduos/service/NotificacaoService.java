package br.com.fiap.gestaoresiduos.service;

import br.com.fiap.gestaoresiduos.exception.ResourceNotFoundException;
import br.com.fiap.gestaoresiduos.model.Notificacao;
import br.com.fiap.gestaoresiduos.model.Cadastro;
import br.com.fiap.gestaoresiduos.model.TipoNotificacao;
import br.com.fiap.gestaoresiduos.repository.NotificacaoRepository;
import br.com.fiap.gestaoresiduos.repository.CadastroRepository;
import br.com.fiap.gestaoresiduos.repository.TipoNotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private CadastroRepository cadastroRepository;

    @Autowired
    private TipoNotificacaoRepository tipoNotificacaoRepository;

    public List<Notificacao> listarTodos() {
        return notificacaoRepository.findAll();
    }

    public Notificacao buscarPorId(Long id) {
        return notificacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notificação não encontrada com id " + id));
    }

    public Notificacao salvar(Notificacao notificacao) {
        validarCadastroETipoNotificacao(notificacao);
        Cadastro cadastro = cadastroRepository.findById(notificacao.getCadastro().getCdCadastro())
                .orElseThrow(() -> new ResourceNotFoundException("Cadastro não encontrado com id " + notificacao.getCadastro().getCdCadastro()));
        TipoNotificacao tipoNotificacao = tipoNotificacaoRepository.findById(notificacao.getTipoNotificacao().getCdTipoNotificacao())
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de Notificação não encontrado com id " + notificacao.getTipoNotificacao().getCdTipoNotificacao()));
        notificacao.setCadastro(cadastro);
        notificacao.setTipoNotificacao(tipoNotificacao);
        return notificacaoRepository.save(notificacao);
    }

    public Notificacao atualizar(Long id, Notificacao notificacaoDetails) {
        Notificacao notificacao = buscarPorId(id);

        notificacao.setNrNotificacao(notificacaoDetails.getNrNotificacao());
        notificacao.setContNotificacao(notificacaoDetails.getContNotificacao());
        notificacao.setStNotificacao(notificacaoDetails.getStNotificacao());
        notificacao.setDtEnvio(notificacaoDetails.getDtEnvio());

        if (notificacaoDetails.getCadastro() != null) {
            Cadastro cadastro = cadastroRepository.findById(notificacaoDetails.getCadastro().getCdCadastro())
                    .orElseThrow(() -> new ResourceNotFoundException("Cadastro não encontrado com id " + notificacaoDetails.getCadastro().getCdCadastro()));
            notificacao.setCadastro(cadastro);
        }

        if (notificacaoDetails.getTipoNotificacao() != null) {
            TipoNotificacao tipoNotificacao = tipoNotificacaoRepository.findById(notificacaoDetails.getTipoNotificacao().getCdTipoNotificacao())
                    .orElseThrow(() -> new ResourceNotFoundException("Tipo de Notificação não encontrado com id " + notificacaoDetails.getTipoNotificacao().getCdTipoNotificacao()));
            notificacao.setTipoNotificacao(tipoNotificacao);
        }

        return notificacaoRepository.save(notificacao);
    }

    public void deletar(Long id) {
        Notificacao notificacao = buscarPorId(id);
        notificacaoRepository.delete(notificacao);
    }

    private void validarCadastroETipoNotificacao(Notificacao notificacao) {
        Long cadastroId = notificacao.getCadastro().getCdCadastro();
        Long tipoNotificacaoId = notificacao.getTipoNotificacao().getCdTipoNotificacao();

        if (!cadastroRepository.existsById(cadastroId)) {
            throw new ResourceNotFoundException("Cadastro não encontrado com id " + cadastroId);
        }

        if (!tipoNotificacaoRepository.existsById(tipoNotificacaoId)) {
            throw new ResourceNotFoundException("Tipo de Notificação não encontrado com id " + tipoNotificacaoId);
        }
    }
}
