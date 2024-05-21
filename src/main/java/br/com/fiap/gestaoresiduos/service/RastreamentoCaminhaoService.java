package br.com.fiap.gestaoresiduos.service;

import br.com.fiap.gestaoresiduos.model.RastreamentoCaminhao;
import br.com.fiap.gestaoresiduos.repository.RastreamentoCaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RastreamentoCaminhaoService {

    @Autowired
    private RastreamentoCaminhaoRepository rastreamentoCaminhaoRepository;

    public RastreamentoCaminhao gravar(RastreamentoCaminhao rastreamentoCaminhao) {
        return rastreamentoCaminhaoRepository.save(rastreamentoCaminhao);
    }

    public RastreamentoCaminhao buscarPorId(Long id) {
        Optional<RastreamentoCaminhao> rastreamentoOptional = rastreamentoCaminhaoRepository.findById(id);
        if(rastreamentoOptional.isPresent()) {
            return rastreamentoOptional.get();
        } else {
            throw new RuntimeException("Rastreamento de caminhão não encontrado");
        }
    }

    public List<RastreamentoCaminhao> listarTodosRastreamentos() {
        return rastreamentoCaminhaoRepository.findAll();
    }

    public void remover(Long id) {
        Optional<RastreamentoCaminhao> rastreamentoOptional = rastreamentoCaminhaoRepository.findById(id);
        if(rastreamentoOptional.isPresent()) {
            rastreamentoCaminhaoRepository.delete(rastreamentoOptional.get());
        } else {
            throw new RuntimeException("Rastreamento de caminhão não encontrado");
        }
    }

    public RastreamentoCaminhao atualizar(RastreamentoCaminhao rastreamentoCaminhao) {
        Optional<RastreamentoCaminhao> rastreamentoOptional = rastreamentoCaminhaoRepository.findById(rastreamentoCaminhao.getCdCaminhao());
        if(rastreamentoOptional.isPresent()) {
            return rastreamentoCaminhaoRepository.save(rastreamentoCaminhao);
        } else {
            throw new RuntimeException("Rastreamento de caminhão não encontrado");
        }
    }

    public List<RastreamentoCaminhao> listarPorDataAtualizacao(LocalDate data) {
        return rastreamentoCaminhaoRepository.findByDtAtualizacao(data);
    }
}
