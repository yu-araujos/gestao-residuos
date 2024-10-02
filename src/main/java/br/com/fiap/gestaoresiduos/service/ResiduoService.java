package br.com.fiap.gestaoresiduos.service;

import br.com.fiap.gestaoresiduos.model.Residuo;
import br.com.fiap.gestaoresiduos.repository.ResiduosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResiduoService {

    @Autowired
    private ResiduosRepository residuoRepository;

    public Residuo gravar(Residuo residuo) {
        return residuoRepository.save(residuo);
    }

    public Residuo buscarPorId(Long id) {
        Optional<Residuo> residuoOptional = residuoRepository.findById(id);
        if (residuoOptional.isPresent()) {
            return residuoOptional.get();
        } else {
            throw new RuntimeException("Resíduo não encontrado");
        }
    }

    public List<Residuo> listarTodosResiduos() {
        return residuoRepository.findAll();
    }

    public void remover(Long id) {
        Optional<Residuo> residuoOptional = residuoRepository.findById(id);
        if (residuoOptional.isPresent()) {
            residuoRepository.delete(residuoOptional.get());
        } else {
            throw new RuntimeException("Resíduo não encontrado");
        }
    }

    public Residuo atualizar(Residuo residuo) {
        Optional<Residuo> residuoOptional = residuoRepository.findById(residuo.getCdResiduo());
        if (residuoOptional.isPresent()) {
            return residuoRepository.save(residuo);
        } else {
            throw new RuntimeException("Resíduo não encontrado");
        }
    }
}
