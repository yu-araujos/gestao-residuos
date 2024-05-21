package br.com.fiap.gestaoresiduos.service;

import br.com.fiap.gestaoresiduos.model.CalendarioColeta;
import br.com.fiap.gestaoresiduos.repository.CalendarioColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarioColetaService {
    @Autowired
    private CalendarioColetaRepository calendarioColetaRepository;

    public CalendarioColeta gravar(CalendarioColeta calendarioColeta) {
        return calendarioColetaRepository.save(calendarioColeta);
    }

    public CalendarioColeta buscarPorId(Long id) {
        Optional<CalendarioColeta> calendarioColetaOptional = calendarioColetaRepository.findById(id);
        if(calendarioColetaOptional.isPresent()){
            return calendarioColetaOptional.get();
        } else {
            throw new RuntimeException("Data não encontrada");
        }
    }

    public List<CalendarioColeta> listarTodosCalendarioColeta() {
        return calendarioColetaRepository.findAll();
    }

    public void remover(Long id) {
        Optional<CalendarioColeta> calendarioColetaOptional = calendarioColetaRepository.findById(id);
        if(calendarioColetaOptional.isPresent()){
            calendarioColetaRepository.delete(calendarioColetaOptional.get());
        } else {
            throw new RuntimeException("Data não encontrada");
        }
    }


    public CalendarioColeta atualizar (CalendarioColeta calendarioColeta) {
        Optional<CalendarioColeta> calendarioColetaOptional = calendarioColetaRepository.findById(calendarioColeta.getCdCalendarioColeta());
        if(calendarioColetaOptional.isPresent()){
            return calendarioColetaRepository.save(calendarioColeta);
        } else {
            throw new RuntimeException("Data não encontrada");
        }
    }

















}
