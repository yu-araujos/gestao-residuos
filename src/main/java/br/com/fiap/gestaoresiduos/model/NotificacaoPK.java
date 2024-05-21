package br.com.fiap.gestaoresiduos.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class NotificacaoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "cd_cadastro")
    private Cadastro cadastro;

    @ManyToOne
    @JoinColumn(name = "cd_tipo_notificacao")
    private TipoNotificacao tipoNotificacao;
}
