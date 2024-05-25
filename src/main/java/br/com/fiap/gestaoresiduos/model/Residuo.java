package br.com.fiap.gestaoresiduos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_residuo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Residuo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESIDUO_SEQ")
    @SequenceGenerator(name = "RESIDUO_SEQ", sequenceName = "RESIDUO_SEQ", allocationSize = 50)
    @Column(name = "cd_residuo")
    private Long cdResiduo;

    @ManyToOne
    @JoinColumn(name = "cd_cadastro")
    private Cadastro cadastro;

    @ManyToOne
    @JoinColumn(name = "cd_rastreio")
    private Rastreio rastreio;

    private String dsResiduo;
    private String vlMaximo;
}
