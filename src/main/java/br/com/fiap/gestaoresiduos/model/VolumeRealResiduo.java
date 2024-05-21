package br.com.fiap.gestaoresiduos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_vl_real_residuo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class VolumeRealResiduo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VL_REAL_RESIDUO_SEQ")
    @SequenceGenerator(name = "VL_REAL_RESIDUO_SEQ", sequenceName = "VL_REAL_RESIDUO_SEQ", allocationSize = 50)
    private Long cdVlRealResiduo;

    @EmbeddedId
    private VolumeRealResiduoPK id;

    private String vlResOrg;
    private String vlResRec;
    private String vlResPer;
}
