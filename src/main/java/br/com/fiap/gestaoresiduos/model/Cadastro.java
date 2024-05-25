package br.com.fiap.gestaoresiduos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "t_cadastro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Cadastro {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CADASTRO_SEQ"
    )
    @SequenceGenerator(
            name = "CADASTRO_SEQ",
            sequenceName = "CADASTRO_SEQ",
            allocationSize = 50
    )
    @Column(name = "cd_cadastro")
    private Long cdCadastro;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String dsNome;

    @Email(message = "Email deve ser válido")
    @NotBlank(message = "O email é obrigatório")
    private String dsEmail;

    @NotBlank(message = "O endereço é obrigatório")
    @Size(max = 255, message = "O endereço deve ter no máximo 255 caracteres")
    private String dsEndereco;
}
