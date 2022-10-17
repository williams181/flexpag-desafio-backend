package com.flexpag.paymentscheduler.usuario.model;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flexpag.paymentscheduler.usuario.model.UsuarioDto;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private Long idUsuario;

    @Email
    @NotBlank(message = "O email não pode ser vazio.")
    @JsonProperty(value = "email")
    private String email;

    @Length(min = 8, message = "A senha precisa ser a partir de 8 caracteres.")
    @NotBlank(message = "A senha não pode ser vazia.")
    @JsonProperty(value = "senha")
    private String senha;

    public UsernamePasswordAuthenticationToken convertTo() {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }

}

