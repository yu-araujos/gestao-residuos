package br.com.fiap.gestaoresiduos.service;

import br.com.fiap.gestaoresiduos.model.Moradores;
import br.com.fiap.gestaoresiduos.repository.MoradoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoradoresService {

    @Autowired
    private MoradoresRepository moradoresRepository;

    public Moradores gravar(Moradores morador) {
        return moradoresRepository.save(morador);
    }

    public Moradores buscarPorId(Long id) {
        Optional<Moradores> moradorOptional = moradoresRepository.findById(id);
        if(moradorOptional.isPresent()) {
            return moradorOptional.get();
        } else {
            throw new RuntimeException("Morador não encontrado");
        }
    }

    public List<Moradores> listarTodosMoradores() {
        return moradoresRepository.findAll();
    }

    public void remover(Long id) {
        Optional<Moradores> moradorOptional = moradoresRepository.findById(id);
        if(moradorOptional.isPresent()) {
            moradoresRepository.delete(moradorOptional.get());
        } else {
            throw new RuntimeException("Morador não encontrado");
        }
    }

    public Moradores atualizar(Moradores morador) {
        Optional<Moradores> moradorOptional = moradoresRepository.findById(morador.getCdMoradores());
        if(moradorOptional.isPresent()) {
            return moradoresRepository.save(morador);
        } else {
            throw new RuntimeException("Morador não encontrado");
        }
    }
}

