package br.com.fiap.gestaoresiduos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_tipo_notificacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TipoNotificacao {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TIPO_NOTIFICACAO_SEQ"
    )
    @SequenceGenerator(
            name = "TIPO_NOTIFICACAO_SEQ",
            sequenceName = "TIPO_NOTIFICACAO_SEQ",
            allocationSize = 50
    )
    @Column(name = "cd_tipo_mensagem")
    private Long cdTipoNotificacao;

    @Column(name = "ds_mensagem")
    private String dsMensagem;
}
