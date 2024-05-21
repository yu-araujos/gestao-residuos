package br.com.fiap.gestaoresiduos.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "t_rastreamento_caminhao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RastreamentoCaminhao {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "RASTREAMENTO_CAMINHAO_SEQ"
    )
    @SequenceGenerator(
            name = "RASTREAMENTO_CAMINHAO_SEQ",
            sequenceName = "RASTREAMENTO_CAMINHAO_SEQ",
            allocationSize = 50
    )
    private Long cdCaminhao;
    private String dsLocalizacao;
    @Column(name = "dt_atualizacao")
    private LocalDate dtAtualizacao;
}
