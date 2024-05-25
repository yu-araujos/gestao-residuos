package br.com.fiap.gestaoresiduos.controller;

import br.com.fiap.gestaoresiduos.model.Notificacao;
import br.com.fiap.gestaoresiduos.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacao")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @GetMapping
    public List<Notificacao> getAllNotificacoes() {
        return notificacaoService.listarTodos();
    }

    @GetMapping("/{cdNotificacao}")
    public ResponseEntity<Notificacao> getNotificacaoById(@PathVariable Long cdNotificacao) {
        Notificacao notificacao = notificacaoService.buscarPorId(cdNotificacao);
        return ResponseEntity.ok(notificacao);
    }

    @PostMapping
    public Notificacao createNotificacao(@RequestBody Notificacao notificacao) {
        return notificacaoService.salvar(notificacao);
    }

    @PutMapping("/{cdNotificacao}")
    public ResponseEntity<Notificacao> updateNotificacao(@PathVariable Long cdNotificacao, @RequestBody Notificacao notificacaoDetails) {
        Notificacao updatedNotificacao = notificacaoService.atualizar(cdNotificacao, notificacaoDetails);
        return ResponseEntity.ok(updatedNotificacao);
    }

    @DeleteMapping("/{cdNotificacao}")
    public ResponseEntity<Void> deleteNotificacao(@PathVariable Long cdNotificacao) {
        notificacaoService.deletar(cdNotificacao);
        return ResponseEntity.noContent().build();
    }
}
