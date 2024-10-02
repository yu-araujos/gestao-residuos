package br.com.fiap.gestaoresiduos.controller;

import br.com.fiap.gestaoresiduos.model.Residuo;
import br.com.fiap.gestaoresiduos.model.VolumeRealResiduo;
import br.com.fiap.gestaoresiduos.repository.ResiduosRepository;
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

    @Autowired
    private ResiduosRepository residuoRepository;

    @GetMapping
    public List<VolumeRealResiduo> getAllVolumeRealResiduos() {
        return volumeRealResiduoRepository.findAll();
    }

    @GetMapping("/{cdVolumeRealResiduo}")
    public ResponseEntity<VolumeRealResiduo> getVolumeRealResiduoById(@PathVariable Long cdVolumeRealResiduo) {
        return volumeRealResiduoRepository.findById(cdVolumeRealResiduo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VolumeRealResiduo> createVolumeRealResiduo(@RequestBody VolumeRealResiduo volumeRealResiduo) {
        Residuo residuo = residuoRepository.findById(volumeRealResiduo.getResiduo().getCdResiduo())
                .orElseThrow(() -> new RuntimeException("Residuo não encontrado"));
        volumeRealResiduo.setResiduo(residuo);
        VolumeRealResiduo novoVolumeRealResiduo = volumeRealResiduoRepository.save(volumeRealResiduo);
        return ResponseEntity.ok(novoVolumeRealResiduo);
    }

    @PutMapping("/{cdVolumeRealResiduo}")
    public ResponseEntity<VolumeRealResiduo> updateVolumeRealResiduo(@PathVariable Long cdVolumeRealResiduo, @RequestBody VolumeRealResiduo volumeRealResiduoDetails) {
        return volumeRealResiduoRepository.findById(cdVolumeRealResiduo)
                .map(volumeRealResiduo -> {
                    Residuo residuo = residuoRepository.findById(volumeRealResiduoDetails.getResiduo().getCdResiduo())
                            .orElseThrow(() -> new RuntimeException("Residuo não encontrado"));
                    volumeRealResiduo.setResiduo(residuo);
                    volumeRealResiduo.setVlResOrg(volumeRealResiduoDetails.getVlResOrg());
                    volumeRealResiduo.setVlResRec(volumeRealResiduoDetails.getVlResRec());
                    volumeRealResiduo.setVlResPer(volumeRealResiduoDetails.getVlResPer());
                    VolumeRealResiduo updatedVolumeRealResiduo = volumeRealResiduoRepository.save(volumeRealResiduo);
                    return ResponseEntity.ok(updatedVolumeRealResiduo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{cdVolumeRealResiduo}")
    public ResponseEntity<Void> deleteVolumeRealResiduo(@PathVariable Long cdVolumeRealResiduo) {
        return volumeRealResiduoRepository.findById(cdVolumeRealResiduo)
                .map(volumeRealResiduo -> {
                    volumeRealResiduoRepository.delete(volumeRealResiduo);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
