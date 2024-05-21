package br.com.fiap.gestaoresiduos.service;

import br.com.fiap.gestaoresiduos.model.Cadastro;
import br.com.fiap.gestaoresiduos.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository cadastroRepository;

    public Cadastro gravar(Cadastro cadastro) {
        return cadastroRepository.save(cadastro);
    }

    public Cadastro buscarPorId(Long id) {
        Optional<Cadastro> cadastroOptional = cadastroRepository.findById(id);
        if(cadastroOptional.isPresent()) {
            return cadastroOptional.get();
        } else {
            throw new RuntimeException("Cadastro não encontrado");
        }
    }

    public List<Cadastro> listarTodosCadastros() {
        return cadastroRepository.findAll();
    }

    public void remover(Long id) {
        Optional<Cadastro> cadastroOptional = cadastroRepository.findById(id);
        if(cadastroOptional.isPresent()) {
            cadastroRepository.delete(cadastroOptional.get());
        } else {
            throw new RuntimeException("Cadastro não encontrado");
        }
    }

    public Cadastro atualizar(Cadastro cadastro) {
        Optional<Cadastro> cadastroOptional = cadastroRepository.findById(cadastro.getCdCadastro());
        if(cadastroOptional.isPresent()) {
            return cadastroRepository.save(cadastro);
        } else {
            throw new RuntimeException("Cadastro não encontrado");
        }
    }
}
