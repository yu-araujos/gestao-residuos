package br.com.fiap.gestaoresiduos.model;

import jakarta.persistence.*;
        import lombok.*;

        import java.time.LocalDate;

@Entity
@Table(name = "t_notificacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTIFICACAO_SEQ")
    @SequenceGenerator(name = "NOTIFICACAO_SEQ", sequenceName = "NOTIFICACAO_SEQ", allocationSize = 50)
    @Column(name = "cd_notificacao")
    private Long cdNotificacao;

    @ManyToOne
    @JoinColumn(name = "cd_cadastro", nullable = false)
    private Cadastro cadastro;

    @ManyToOne
    @JoinColumn(name = "cd_tipo_mensagem", nullable = false)
    private TipoNotificacao tipoNotificacao;

    private String nrNotificacao;
    private String contNotificacao;
    private String stNotificacao;
    private LocalDate dtEnvio;

}
