package br.com.fiap.gestaoresiduos.security;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AuthenticationRequest {

    private String username;
    private String password;
}
