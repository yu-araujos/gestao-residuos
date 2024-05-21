package br.com.fiap.gestaoresiduos.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "t_calendario_coleta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CalendarioColeta {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CALENDARIO_COLETA_SEQ"
    )
    @SequenceGenerator(
            name = "CALENDARIO_COLETA_SEQ",
            sequenceName = "CALENDARIO_COLETA_SEQ",
            allocationSize = 50
    )
    private Long cdCalendarioColeta;
    @Column(name = "dia_coleta")
    private LocalDate diaColeta;
    private String tipoResiduo;
    private String instrucoes;
}
