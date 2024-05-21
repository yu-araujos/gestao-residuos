package br.com.fiap.gestaoresiduos.controller;

import br.com.fiap.gestaoresiduos.model.Cadastro;
import br.com.fiap.gestaoresiduos.model.Rastreio;
import br.com.fiap.gestaoresiduos.model.RastreioPK;
import br.com.fiap.gestaoresiduos.model.Residuo;
import br.com.fiap.gestaoresiduos.repository.RastreioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rastreio")
public class RastreioController {

    @Autowired
    private RastreioRepository rastreioRepository;

    @GetMapping
    public List<Rastreio> getAllRastreios() {
        return rastreioRepository.findAll();
    }

    @GetMapping("/{cdCadastro}/{cdResiduo}")
    public ResponseEntity<Rastreio> getRastreioById(@PathVariable Long cdCadastro, @PathVariable Long cdResiduo) {
        Cadastro cadastro = new Cadastro();
        cadastro.setCdCadastro(cdCadastro);
        Residuo residuo = new Residuo();
        residuo.setCdResiduo(cdResiduo);
        RastreioPK id = new RastreioPK(cadastro, residuo);
        return rastreioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rastreio createRastreio(@RequestBody Rastreio rastreio) {
        return rastreioRepository.save(rastreio);
    }

    @PutMapping("/{cdCadastro}/{cdResiduo}")
    public ResponseEntity<Rastreio> updateRastreio(@PathVariable Long cdCadastro, @PathVariable Long cdResiduo, @RequestBody Rastreio rastreioDetails) {
        Cadastro cadastro = new Cadastro();
        cadastro.setCdCadastro(cdCadastro);
        Residuo residuo = new Residuo();
        residuo.setCdResiduo(cdResiduo);
        RastreioPK id = new RastreioPK(cadastro, residuo);
        return rastreioRepository.findById(id)
                .map(rastreio -> {
                    // Atualizar outros campos conforme necessário
                    Rastreio updatedRastreio = rastreioRepository.save(rastreioDetails);
                    return ResponseEntity.ok(updatedRastreio);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{cdCadastro}/{cdResiduo}")
    public ResponseEntity<Void> deleteRastreio(@PathVariable Long cdCadastro, @PathVariable Long cdResiduo) {
        Cadastro cadastro = new Cadastro();
        cadastro.setCdCadastro(cdCadastro);
        Residuo residuo = new Residuo();
        residuo.setCdResiduo(cdResiduo);
        RastreioPK id = new RastreioPK(cadastro, residuo);
        return rastreioRepository.findById(id)
                .map(rastreio -> {
                    rastreioRepository.delete(rastreio);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
