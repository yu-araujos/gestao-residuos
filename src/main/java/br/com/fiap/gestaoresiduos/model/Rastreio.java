package br.com.fiap.gestaoresiduos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_rastreio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Rastreio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RASTREIO_SEQ")
    @SequenceGenerator(name = "RASTREIO_SEQ", sequenceName = "RASTREIO_SEQ", allocationSize = 50)
    @Column(name = "cd_rastreio")
    private Long cdRastreio;

    @ManyToOne
    @JoinColumn(name = "cd_cadastro")
    private Cadastro cadastro;

    @ManyToOne
    @JoinColumn(name = "cd_residuo")
    private Residuo residuo;

    private String nrRastreio;
    private String stCaminhao;
}
