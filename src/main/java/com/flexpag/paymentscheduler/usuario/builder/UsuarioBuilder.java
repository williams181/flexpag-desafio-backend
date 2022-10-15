package com.flexpag.paymentscheduler.usuario.builder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.flexpag.paymentscheduler.usuario.model.Usuario;
import com.flexpag.paymentscheduler.usuario.model.UsuarioDto;
import com.flexpag.paymentscheduler.usuario.model.UsuarioOAuth;

@Component
public class UsuarioBuilder {

    public UsuarioDto builderDto(Usuario usuarioRecebido) {
        return UsuarioDto
                .builder()
                .idUsuario(usuarioRecebido.getIdUsuario())
                .email(usuarioRecebido.getEmail())
                .senha(new BCryptPasswordEncoder().encode(usuarioRecebido.getSenha()))
                .build();
    }

    public Usuario builderModel(UsuarioDto usuarioDto) {
        return Usuario
                .builder()
                .email(usuarioDto.getEmail())
                .senha(new BCryptPasswordEncoder().encode(usuarioDto.getSenha()))
                .build();
    }

    public Usuario builderModelFromOauth(UsuarioOAuth usuarioOAuth) {
        return Usuario
                .builder()
                .email(usuarioOAuth.getEmail())
                .build();
    }
}


