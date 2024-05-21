package br.com.fiap.gestaoresiduos.controller;

import br.com.fiap.gestaoresiduos.model.CalendarioColeta;
import br.com.fiap.gestaoresiduos.service.CalendarioColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coleta-de-lixo")
public class ColetaLixoController {
    @Autowired
    private CalendarioColetaService calendarioColetaService;

    @GetMapping
    public ResponseEntity<List<CalendarioColeta>> obterInformacoesColetaLixo() {
        List<CalendarioColeta> coletas = calendarioColetaService.listarTodosCalendarioColeta();
        return new ResponseEntity<>(coletas, HttpStatus.OK);
    }
}
