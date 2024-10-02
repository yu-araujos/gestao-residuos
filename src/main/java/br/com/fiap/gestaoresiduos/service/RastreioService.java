package br.com.fiap.gestaoresiduos.service;

import br.com.fiap.gestaoresiduos.model.Cadastro;
import br.com.fiap.gestaoresiduos.model.Rastreio;
import br.com.fiap.gestaoresiduos.model.Residuo;
import br.com.fiap.gestaoresiduos.repository.CadastroRepository;
import br.com.fiap.gestaoresiduos.repository.RastreioRepository;
import br.com.fiap.gestaoresiduos.repository.ResiduosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RastreioService {

    @Autowired
    private RastreioRepository rastreioRepository;
    @Autowired
    private CadastroRepository cadastroRepository;
    @Autowired
    private ResiduosRepository residuosRepository;

    public Rastreio createRastreio(Rastreio rastreio) {
        if (rastreio.getCadastro() != null && rastreio.getCadastro().getCdCadastro() != null) {
            Cadastro cadastro = cadastroRepository.findById(rastreio.getCadastro().getCdCadastro())
                    .orElseThrow(() -> new RuntimeException("Cadastro not found"));
            rastreio.setCadastro(cadastro);
        }
        if (rastreio.getResiduo() != null && rastreio.getResiduo().getCdResiduo() != null) {
            Residuo residuo = residuosRepository.findById(rastreio.getResiduo().getCdResiduo())
                    .orElseThrow(() -> new RuntimeException("Residuo not found"));
            rastreio.setResiduo(residuo);
        }
        return rastreioRepository.save(rastreio);
    }

    public Rastreio buscarPorId(Long id) {
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

    public void remover(Long id) {
        Optional<Rastreio> rastreioOptional = rastreioRepository.findById(id);
        if(rastreioOptional.isPresent()) {
            rastreioRepository.delete(rastreioOptional.get());
        } else {
            throw new RuntimeException("Rastreio não encontrado");
        }
    }

    public Rastreio atualizar(Rastreio rastreio) {
        Optional<Rastreio> rastreioOptional = rastreioRepository.findById(rastreio.getCdRastreio());
        if(rastreioOptional.isPresent()) {
            return rastreioRepository.save(rastreio);
        } else {
            throw new RuntimeException("Rastreio não encontrado");
        }
    }
}
