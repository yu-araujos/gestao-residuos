package br.com.fiap.gestaoresiduos.controller;

import br.com.fiap.gestaoresiduos.model.CalendarioColeta;
import br.com.fiap.gestaoresiduos.service.CalendarioColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento-de-coleta")
public class AgendamentoColetaController {
    @Autowired
    private CalendarioColetaService calendarioColetaService;

    @GetMapping
    public ResponseEntity<List<CalendarioColeta>> listarTodos() {
        List<CalendarioColeta> coletas = calendarioColetaService.listarTodos();
        return ResponseEntity.ok(coletas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalendarioColeta> buscarPorId(@PathVariable Long id) {
        CalendarioColeta coleta = calendarioColetaService.buscarPorId(id);
        return ResponseEntity.ok(coleta);
    }

    @PostMapping
    public ResponseEntity<CalendarioColeta> criar(@RequestBody CalendarioColeta coleta) {
        CalendarioColeta novaColeta = calendarioColetaService.salvar(coleta);
        return ResponseEntity.status(201).body(novaColeta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CalendarioColeta> atualizar(@PathVariable Long id, @RequestBody CalendarioColeta coletaDetalhes) {
        CalendarioColeta coletaAtualizada = calendarioColetaService.atualizar(id, coletaDetalhes);
        return ResponseEntity.ok(coletaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        calendarioColetaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}