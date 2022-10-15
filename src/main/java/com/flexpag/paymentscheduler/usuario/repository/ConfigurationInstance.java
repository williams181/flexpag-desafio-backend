package com.flexpag.paymentscheduler.usuario.repository;

import java.util.Optional;

import org.springframework.context.annotation.Configuration;

import com.flexpag.paymentscheduler.usuario.model.Usuario;

@Configuration
public class ConfigurationInstance {
	
	private UsuarioRepository usuarioRepository;

	public ConfigurationInstance(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	public  Optional<Usuario> retornaUsuario(Long id) {
		return Optional.of(usuarioRepository.findById(id).get());
	}
	
	
	
	
}
