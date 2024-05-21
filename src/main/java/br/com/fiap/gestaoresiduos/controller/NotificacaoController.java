package br.com.fiap.gestaoresiduos.controller;

import br.com.fiap.gestaoresiduos.model.Cadastro;
import br.com.fiap.gestaoresiduos.model.Notificacao;
import br.com.fiap.gestaoresiduos.model.NotificacaoPK;
import br.com.fiap.gestaoresiduos.model.TipoNotificacao;
import br.com.fiap.gestaoresiduos.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacao")
public class NotificacaoController {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @GetMapping
    public List<Notificacao> getAllNotificacoes() {
        return notificacaoRepository.findAll();
    }

    @GetMapping("/{cdCadastro}/{cdTipoNotificacao}")
    public ResponseEntity<Notificacao> getNotificacaoById(@PathVariable Long cdCadastro, @PathVariable Long cdTipoNotificacao) {
        Cadastro cadastro = new Cadastro();
        cadastro.setCdCadastro(cdCadastro);
        TipoNotificacao tipoNotificacao = new TipoNotificacao();
        tipoNotificacao.setCdTipoNotificacao(cdTipoNotificacao);
        NotificacaoPK id = new NotificacaoPK(cadastro, tipoNotificacao);
        return notificacaoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Notificacao createNotificacao(@RequestBody Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    @PutMapping("/{cdCadastro}/{cdTipoNotificacao}")
    public ResponseEntity<Notificacao> updateNotificacao(@PathVariable Long cdCadastro, @PathVariable Long cdTipoNotificacao, @RequestBody Notificacao notificacaoDetails) {
        Cadastro cadastro = new Cadastro();
        cadastro.setCdCadastro(cdCadastro);
        TipoNotificacao tipoNotificacao = new TipoNotificacao();
        tipoNotificacao.setCdTipoNotificacao(cdTipoNotificacao);
        NotificacaoPK id = new NotificacaoPK(cadastro, tipoNotificacao);
        return notificacaoRepository.findById(id)
                .map(notificacao -> {
                    // Atualizar outros campos conforme necessário
                    Notificacao updatedNotificacao = notificacaoRepository.save(notificacaoDetails);
                    return ResponseEntity.ok(updatedNotificacao);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{cdCadastro}/{cdTipoNotificacao}")
    public ResponseEntity<Void> deleteNotificacao(@PathVariable Long cdCadastro, @PathVariable Long cdTipoNotificacao) {
        Cadastro cadastro = new Cadastro();
        cadastro.setCdCadastro(cdCadastro);
        TipoNotificacao tipoNotificacao = new TipoNotificacao();
        tipoNotificacao.setCdTipoNotificacao(cdTipoNotificacao);
        NotificacaoPK id = new NotificacaoPK(cadastro, tipoNotificacao);
        return notificacaoRepository.findById(id)
                .map(notificacao -> {
                    notificacaoRepository.delete(notificacao);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
