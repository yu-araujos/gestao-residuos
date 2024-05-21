package br.com.fiap.gestaoresiduos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_moradores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Moradores {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MORADORES_SEQ"
    )
    @SequenceGenerator(
            name = "MORADORES_SEQ",
            sequenceName = "MORADORES_SEQ",
            allocationSize = 50
    )
    private Long cdMoradores;
    private String dsNome;
    private String dsEmail;
    private String dsEndereco;
}
