package br.com.fiap.gestaoresiduos.controller;

import br.com.fiap.gestaoresiduos.model.Residuo;
import br.com.fiap.gestaoresiduos.model.VolumeRealResiduo;
import br.com.fiap.gestaoresiduos.model.VolumeRealResiduoPK;
import br.com.fiap.gestaoresiduos.repository.VolumeRealResiduoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volume-real-residuo")
public class VolumeRealResiduoController {

    @Autowired
    private VolumeRealResiduoRepository volumeRealResiduoRepository;

    @GetMapping
    public List<VolumeRealResiduo> getAllVolumeRealResiduos() {
        return volumeRealResiduoRepository.findAll();
    }

    @GetMapping("/{cdResiduo}")
    public ResponseEntity<VolumeRealResiduo> getVolumeRealResiduoById(@PathVariable Long cdResiduo) {
        Residuo residuo = new Residuo();
        residuo.setCdResiduo(cdResiduo);
        VolumeRealResiduoPK id = new VolumeRealResiduoPK(residuo);
        return volumeRealResiduoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public VolumeRealResiduo createVolumeRealResiduo(@RequestBody VolumeRealResiduo volumeRealResiduo) {
        return volumeRealResiduoRepository.save(volumeRealResiduo);
    }

    @PutMapping("/{cdResiduo}")
    public ResponseEntity<VolumeRealResiduo> updateVolumeRealResiduo(@PathVariable Long cdResiduo, @RequestBody VolumeRealResiduo volumeRealResiduoDetails) {
        Residuo residuo = new Residuo();
        residuo.setCdResiduo(cdResiduo);
        VolumeRealResiduoPK id = new VolumeRealResiduoPK(residuo);
        return volumeRealResiduoRepository.findById(id)
                .map(volumeRealResiduo -> {
                    // Atualizar outros campos conforme necessário
                    VolumeRealResiduo updatedVolumeRealResiduo = volumeRealResiduoRepository.save(volumeRealResiduoDetails);
                    return ResponseEntity.ok(updatedVolumeRealResiduo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{cdResiduo}")
    public ResponseEntity<Void> deleteVolumeRealResiduo(@PathVariable Long cdResiduo) {
        Residuo residuo = new Residuo();
        residuo.setCdResiduo(cdResiduo);
        VolumeRealResiduoPK id = new VolumeRealResiduoPK(residuo);
        return volumeRealResiduoRepository.findById(id)
                .map(volumeRealResiduo -> {
                    volumeRealResiduoRepository.delete(volumeRealResiduo);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
