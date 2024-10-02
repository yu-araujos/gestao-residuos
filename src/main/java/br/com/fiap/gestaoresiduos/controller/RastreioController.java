package br.com.fiap.gestaoresiduos.controller;

import br.com.fiap.gestaoresiduos.model.Cadastro;
import br.com.fiap.gestaoresiduos.model.Rastreio;
import br.com.fiap.gestaoresiduos.model.Residuo;
import br.com.fiap.gestaoresiduos.repository.RastreioRepository;
import br.com.fiap.gestaoresiduos.repository.CadastroRepository;
import br.com.fiap.gestaoresiduos.repository.ResiduosRepository;
import br.com.fiap.gestaoresiduos.service.RastreioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rastreio")
public class RastreioController {

    @Autowired
    private RastreioRepository rastreioRepository;

    @Autowired
    private CadastroRepository cadastroRepository;

    @Autowired
    private ResiduosRepository residuoRepository;
    @Autowired
    private RastreioService rastreioService;

    @GetMapping
    public List<Rastreio> getAllRastreios() {
        return rastreioRepository.findAll();
    }

    @GetMapping("/{cdRastreio}")
    public ResponseEntity<Rastreio> getRastreioById(@PathVariable Long cdRastreio) {
        return rastreioRepository.findById(cdRastreio)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Rastreio> createRastreio(@RequestBody Rastreio rastreio) {
        Rastreio createdRastreio = rastreioService.createRastreio(rastreio);
        return ResponseEntity.ok(createdRastreio);
    }


    @PutMapping("/{cdRastreio}")
    public ResponseEntity<Rastreio> updateRastreio(@PathVariable Long cdRastreio, @RequestBody Rastreio rastreioDetails) {
        return rastreioRepository.findById(cdRastreio)
                .map(rastreio -> {
                    rastreio.setNrRastreio(rastreioDetails.getNrRastreio());
                    rastreio.setStCaminhao(rastreioDetails.getStCaminhao());
                    if (rastreioDetails.getCadastro() != null && rastreioDetails.getCadastro().getCdCadastro() != null) {
                        rastreio.setCadastro(cadastroRepository.findById(rastreioDetails.getCadastro().getCdCadastro()).orElse(null));
                    }
                    if (rastreioDetails.getResiduo() != null && rastreioDetails.getResiduo().getCdResiduo() != null) {
                        rastreio.setResiduo(residuoRepository.findById(rastreioDetails.getResiduo().getCdResiduo()).orElse(null));
                    }
                    Rastreio updatedRastreio = rastreioRepository.save(rastreio);
                    return ResponseEntity.ok(updatedRastreio);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{cdRastreio}")
    public ResponseEntity<Void> deleteRastreio(@PathVariable Long cdRastreio) {
        return rastreioRepository.findById(cdRastreio)
                .map(rastreio -> {
                    rastreioRepository.delete(rastreio);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
