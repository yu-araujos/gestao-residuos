package br.com.fiap.gestaoresiduos.service;

import br.com.fiap.gestaoresiduos.model.VolumeRealResiduo;
import br.com.fiap.gestaoresiduos.repository.VolumeRealResiduoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolumeRealResiduoService {

    @Autowired
    private VolumeRealResiduoRepository volumeRealResiduoRepository;

    public VolumeRealResiduo gravar(VolumeRealResiduo volumeRealResiduo) {
        return volumeRealResiduoRepository.save(volumeRealResiduo);
    }

    public VolumeRealResiduo buscarPorId(Long id) {
        Optional<VolumeRealResiduo> volumeRealResiduoOptional = volumeRealResiduoRepository.findById(id);
        if (volumeRealResiduoOptional.isPresent()) {
            return volumeRealResiduoOptional.get();
        } else {
            throw new RuntimeException("Volume Real de Resíduo não encontrado");
        }
    }

    public List<VolumeRealResiduo> listarTodosVolumesReaisResiduo() {
        return volumeRealResiduoRepository.findAll();
    }

    public void remover(Long id) {
        Optional<VolumeRealResiduo> volumeRealResiduoOptional = volumeRealResiduoRepository.findById(id);
        if (volumeRealResiduoOptional.isPresent()) {
            volumeRealResiduoRepository.delete(volumeRealResiduoOptional.get());
        } else {
            throw new RuntimeException("Volume Real de Resíduo não encontrado");
        }
    }

    public VolumeRealResiduo atualizar(VolumeRealResiduo volumeRealResiduo) {
        Optional<VolumeRealResiduo> volumeRealResiduoOptional = volumeRealResiduoRepository.findById(volumeRealResiduo.getCdVlRealResiduo());
        if (volumeRealResiduoOptional.isPresent()) {
            return volumeRealResiduoRepository.save(volumeRealResiduo);
        } else {
            throw new RuntimeException("Volume Real de Resíduo não encontrado");
        }
    }
}
