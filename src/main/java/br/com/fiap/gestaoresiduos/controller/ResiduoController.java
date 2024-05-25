package br.com.fiap.gestaoresiduos.controller;

import br.com.fiap.gestaoresiduos.model.Cadastro;
import br.com.fiap.gestaoresiduos.model.Rastreio;
import br.com.fiap.gestaoresiduos.model.Residuo;
import br.com.fiap.gestaoresiduos.repository.CadastroRepository;
import br.com.fiap.gestaoresiduos.repository.RastreioRepository;
import br.com.fiap.gestaoresiduos.repository.ResiduosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/residuos")
public class ResiduoController {

    @Autowired
    private ResiduosRepository residuoRepository;

    @Autowired
    private CadastroRepository cadastroRepository;

    @Autowired
    private RastreioRepository rastreioRepository;

    @GetMapping
    public List<Residuo> getAllResiduos() {
        return residuoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Residuo> getResiduoById(@PathVariable Long id) {
        return residuoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Residuo createResiduo(@RequestBody Residuo residuo) {
        return residuoRepository.save(residuo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Residuo> updateResiduo(@PathVariable Long id, @RequestBody Residuo residuoDetails) {
        return residuoRepository.findById(id)
                .map(residuo -> {
                    residuo.setDsResiduo(residuoDetails.getDsResiduo());
                    residuo.setVlMaximo(residuoDetails.getVlMaximo());
                    if (residuoDetails.getCadastro() != null && residuoDetails.getCadastro().getCdCadastro() != null) {
                        Cadastro cadastro = cadastroRepository.findById(residuoDetails.getCadastro().getCdCadastro())
                                .orElseThrow(() -> new RuntimeException("Cadastro not found"));
                        residuo.setCadastro(cadastro);
                    }
                    if (residuoDetails.getRastreio() != null && residuoDetails.getRastreio().getCdRastreio() != null) {
                        Rastreio rastreio = rastreioRepository.findById(residuoDetails.getRastreio().getCdRastreio())
                                .orElseThrow(() -> new RuntimeException("Rastreio not found"));
                        residuo.setRastreio(rastreio);
                    }
                    Residuo updatedResiduo = residuoRepository.save(residuo);
                    return ResponseEntity.ok(updatedResiduo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResiduo(@PathVariable Long id) {
        return residuoRepository.findById(id)
                .map(residuo -> {
                    residuoRepository.delete(residuo);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
