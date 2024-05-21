package br.com.fiap.gestaoresiduos.controller;

import br.com.fiap.gestaoresiduos.exception.ResourceNotFoundException;
import br.com.fiap.gestaoresiduos.model.Cadastro;
import br.com.fiap.gestaoresiduos.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {

    @Autowired
    private CadastroRepository cadastroRepository;

    @GetMapping
    public List<Cadastro> getAllCadastros() {
        return cadastroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cadastro> getCadastroById(@PathVariable Long id) {
        Cadastro cadastro = cadastroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cadastro não encontrado com id " + id));
        return ResponseEntity.ok(cadastro);
    }

    @PostMapping
    public Cadastro createCadastro(@Valid @RequestBody Cadastro cadastro) {
        return cadastroRepository.save(cadastro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cadastro> updateCadastro(@PathVariable Long id, @Valid @RequestBody Cadastro cadastroDetails) {
        Cadastro cadastro = cadastroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cadastro não encontrado com id " + id));

        cadastro.setDsNome(cadastroDetails.getDsNome());
        cadastro.setDsEmail(cadastroDetails.getDsEmail());
        cadastro.setDsEndereco(cadastroDetails.getDsEndereco());

        Cadastro updatedCadastro = cadastroRepository.save(cadastro);
        return ResponseEntity.ok(updatedCadastro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCadastro(@PathVariable Long id) {
        Cadastro cadastro = cadastroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cadastro não encontrado com id " + id));

        cadastroRepository.delete(cadastro);
        return ResponseEntity.noContent().build();
    }
}
