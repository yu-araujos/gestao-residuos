package br.com.fiap.gestaoresiduos.controller;

import br.com.fiap.gestaoresiduos.model.TipoNotificacao;
import br.com.fiap.gestaoresiduos.repository.TipoNotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos-notificacao")
public class TipoNotificacaoController {

    @Autowired
    private TipoNotificacaoRepository tipoNotificacaoRepository;

    @GetMapping
    public List<TipoNotificacao> getAllTiposNotificacao() {
        return tipoNotificacaoRepository.findAll();
    }

    @GetMapping("/{cdTipoNotificacao}")
    public ResponseEntity<TipoNotificacao> getTipoNotificacaoById(@PathVariable Long cdTipoNotificacao) {
        return tipoNotificacaoRepository.findById(cdTipoNotificacao)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipoNotificacao createTipoNotificacao(@RequestBody TipoNotificacao tipoNotificacao) {
        return tipoNotificacaoRepository.save(tipoNotificacao);
    }

    @PutMapping("/{cdTipoNotificacao}")
    public ResponseEntity<TipoNotificacao> updateTipoNotificacao(@PathVariable Long cdTipoNotificacao, @RequestBody TipoNotificacao tipoNotificacaoDetails) {
        return tipoNotificacaoRepository.findById(cdTipoNotificacao)
                .map(tipoNotificacao -> {
                    tipoNotificacao.setDsMensagem(tipoNotificacaoDetails.getDsMensagem());
                    TipoNotificacao updatedTipoNotificacao = tipoNotificacaoRepository.save(tipoNotificacao);
                    return ResponseEntity.ok(updatedTipoNotificacao);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{cdTipoNotificacao}")
    public ResponseEntity<Void> deleteTipoNotificacao(@PathVariable Long cdTipoNotificacao) {
        return tipoNotificacaoRepository.findById(cdTipoNotificacao)
                .map(tipoNotificacao -> {
                    tipoNotificacaoRepository.delete(tipoNotificacao);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
