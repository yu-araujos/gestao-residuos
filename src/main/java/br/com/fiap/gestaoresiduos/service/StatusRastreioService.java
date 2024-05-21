package br.com.fiap.gestaoresiduos.service;

import br.com.fiap.gestaoresiduos.model.StatusRastreio;
import br.com.fiap.gestaoresiduos.model.StatusRastreioPK;
import br.com.fiap.gestaoresiduos.repository.StatusRastreioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusRastreioService {

    @Autowired
    private StatusRastreioRepository statusRastreioRepository;

    public StatusRastreio gravar(StatusRastreio statusRastreio) {
        return statusRastreioRepository.save(statusRastreio);
    }

    public StatusRastreio buscarPorId(StatusRastreioPK id) {
        Optional<StatusRastreio> statusRastreioOptional = statusRastreioRepository.findById(id);
        if (statusRastreioOptional.isPresent()) {
            return statusRastreioOptional.get();
        } else {
            throw new RuntimeException("Status de Rastreio não encontrado");
        }
    }

    public List<StatusRastreio> listarTodosStatusRastreio() {
        return statusRastreioRepository.findAll();
    }

    public void remover(StatusRastreioPK id) {
        Optional<StatusRastreio> statusRastreioOptional = statusRastreioRepository.findById(id);
        if (statusRastreioOptional.isPresent()) {
            statusRastreioRepository.delete(statusRastreioOptional.get());
        } else {
            throw new RuntimeException("Status de Rastreio não encontrado");
        }
    }

    public StatusRastreio atualizar(StatusRastreio statusRastreio) {
        Optional<StatusRastreio> statusRastreioOptional = statusRastreioRepository.findById(statusRastreio.getId());
        if (statusRastreioOptional.isPresent()) {
            return statusRastreioRepository.save(statusRastreio);
        } else {
            throw new RuntimeException("Status de Rastreio não encontrado");
        }
    }
}
