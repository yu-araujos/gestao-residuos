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
    private Long cdRastreio;

    @EmbeddedId
    private RastreioPK id;

    private String nrRastreio;
    private String stCaminhao;
}
