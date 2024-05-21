package br.com.fiap.gestaoresiduos.controller;

import br.com.fiap.gestaoresiduos.model.CalendarioColeta;
import br.com.fiap.gestaoresiduos.service.CalendarioColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamento-de-coleta")
public class AgendamentoColetaController {
    @Autowired
    private CalendarioColetaService calendarioColetaService;

    @PostMapping
    public ResponseEntity<CalendarioColeta> agendarColeta(@RequestBody CalendarioColeta calendarioColeta) {
        CalendarioColeta novaColeta = calendarioColetaService.gravar(calendarioColeta);
        return new ResponseEntity<>(novaColeta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CalendarioColeta> atualizarAgendamento(@PathVariable Long id, @RequestBody CalendarioColeta calendarioColeta) {
        calendarioColeta.setCdCalendarioColeta(id); // Define o ID do objeto calendarioColeta com base no ID da URL
        CalendarioColeta agendamentoAtualizado = calendarioColetaService.atualizar(calendarioColeta);
        return new ResponseEntity<>(agendamentoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarAgendamento(@PathVariable Long id) {
        calendarioColetaService.remover(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}