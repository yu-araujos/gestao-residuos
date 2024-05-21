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
    private Long cdNotificacao;

    @EmbeddedId
    private NotificacaoPK id;

    private String nrNotificacao;
    private String contNotificacao;
    private String stNotificacao;
    private LocalDate dtEnvio;
}
