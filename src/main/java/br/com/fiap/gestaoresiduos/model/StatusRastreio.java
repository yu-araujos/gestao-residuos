package br.com.fiap.gestaoresiduos.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_status_rastreio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class StatusRastreio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATUS_RASTREIO_SEQ")
    @SequenceGenerator(name = "STATUS_RASTREIO_SEQ", sequenceName = "STATUS_RASTREIO_SEQ", allocationSize = 50)
    private Long cdStatusRastreio;

    @EmbeddedId
    private StatusRastreioPK id;

    private String dsEnderecoInicial;
    private String dsEnderecoAtual;
    private String dsEnderecoFinal;
    private LocalDate dtOperacao;
    private LocalDateTime hrInicial;
    private LocalDateTime hrAtual;
    private LocalDateTime hrFinal;
}
