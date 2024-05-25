package br.com.fiap.gestaoresiduos.service;

import br.com.fiap.gestaoresiduos.exception.ResourceNotFoundException;
import br.com.fiap.gestaoresiduos.model.CalendarioColeta;
import br.com.fiap.gestaoresiduos.repository.CalendarioColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarioColetaService {

    @Autowired
    private CalendarioColetaRepository calendarioColetaRepository;

    public List<CalendarioColeta> listarTodos() {
        return calendarioColetaRepository.findAll();
    }

    public CalendarioColeta buscarPorId(Long id) {
        return calendarioColetaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Coleta de lixo não encontrada com id " + id));
    }

    public CalendarioColeta salvar(CalendarioColeta coleta) {
        return calendarioColetaRepository.save(coleta);
    }

    public CalendarioColeta atualizar(Long id, CalendarioColeta coletaDetalhes) {
        CalendarioColeta coleta = buscarPorId(id);

        coleta.setDiaColeta(coletaDetalhes.getDiaColeta());
        coleta.setTipoResiduo(coletaDetalhes.getTipoResiduo());
        coleta.setInstrucoes(coletaDetalhes.getInstrucoes());

        return calendarioColetaRepository.save(coleta);
    }

    public void deletar(Long id) {
        CalendarioColeta coleta = buscarPorId(id);
        calendarioColetaRepository.delete(coleta);
    }
}
