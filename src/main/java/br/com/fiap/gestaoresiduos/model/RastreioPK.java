package br.com.fiap.gestaoresiduos.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RastreioPK implements Serializable {

    @ManyToOne
    private Cadastro cadastro;

    @ManyToOne
    private Residuo residuo;
}
