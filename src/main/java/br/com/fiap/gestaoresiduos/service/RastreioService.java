package br.com.fiap.gestaoresiduos.service;

import br.com.fiap.gestaoresiduos.model.Rastreio;
import br.com.fiap.gestaoresiduos.model.RastreioPK;
import br.com.fiap.gestaoresiduos.repository.RastreioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RastreioService {

    @Autowired
    private RastreioRepository rastreioRepository;

    public Rastreio gravar(Rastreio rastreio) {
        return rastreioRepository.save(rastreio);
    }

    public Rastreio buscarPorId(RastreioPK id) {
        Optional<Rastreio> rastreioOptional = rastreioRepository.findById(id);
        if(rastreioOptional.isPresent()) {
            return rastreioOptional.get();
        } else {
            throw new RuntimeException("Rastreio não encontrado");
        }
    }

    public List<Rastreio> listarTodosRastreios() {
        return rastreioRepository.findAll();
    }

    public void remover(RastreioPK id) {
        Optional<Rastreio> rastreioOptional = rastreioRepository.findById(id);
        if(rastreioOptional.isPresent()) {
            rastreioRepository.delete(rastreioOptional.get());
        } else {
            throw new RuntimeException("Rastreio não encontrado");
        }
    }

    public Rastreio atualizar(Rastreio rastreio) {
        Optional<Rastreio> rastreioOptional = rastreioRepository.findById(rastreio.getId());
        if(rastreioOptional.isPresent()) {
            return rastreioRepository.save(rastreio);
        } else {
            throw new RuntimeException("Rastreio não encontrado");
        }
    }
}
