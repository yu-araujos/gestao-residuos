package br.com.fiap.gestaoresiduos.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class VolumeRealResiduoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "cd_residuo")
    private Residuo residuo;
}
