package com.flexpag.paymentscheduler.usuario.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flexpag.paymentscheduler.usuario.builder.UsuarioBuilder;
import com.flexpag.paymentscheduler.usuario.model.Usuario;
import com.flexpag.paymentscheduler.usuario.model.UsuarioDto;
import com.flexpag.paymentscheduler.usuario.model.UsuarioOAuth;
import com.flexpag.paymentscheduler.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioBuilder builder;

    @Autowired
    private UsuarioRepository repository;
    
    
    
    private List<UsuarioDto> listUsuariosDto;
    
    public UsuarioService(List<UsuarioDto> listUsuariosDto) {
        this.listUsuariosDto = listUsuariosDto;
    }

    public List<UsuarioDto> listarUsuarios() {
        List<UsuarioDto> listaUsuarioDtos = new ArrayList<>();
        
        repository.findAll().forEach(usuario -> {
            listaUsuarioDtos.add(builder.builderDto(usuario));
        });

        return listaUsuarioDtos;
    }

    @Transactional
    public UsuarioDto salvar(UsuarioDto usuarioDto) {
        
        var usuario = builder.builderModel(usuarioDto);
        var usuarioSalvo = builder.builderDto(repository.save(usuario));
        return usuarioSalvo;
    }

    @Transactional
    public Usuario salvarOA(UsuarioOAuth usuarioOAuth) {

        var usuario = builder.builderModelFromOauth(usuarioOAuth);
        var usuarioSalvo = repository.save(usuario);
        return usuarioSalvo;
    }

    public UsuarioDto encontrarUsuario(Long idUsuario) {
        var usuario = repository.findById(idUsuario).orElseThrow();
        return builder.builderDto(usuario);
    }

    @Transactional
    public UsuarioDto alterar(Long idUsuario, UsuarioDto usuarioDto) {
        usuarioDto.setIdUsuario(idUsuario);
        var usuarioAlterado = repository.save(builder.builderModel(usuarioDto));
        return builder.builderDto(usuarioAlterado);
    }

    @Transactional
    public void removerUsuario(Long id) {
        repository.deleteById(id);
    }
    
    public Usuario encontraUsuarioToken(UsuarioOAuth usuarioOAuth) {
        var usuario = repository.findByEmail(usuarioOAuth.getEmail());
        return usuario.orElse(null);
    }

    public void atualizarComUid(Usuario usuario) {
        repository.saveAndFlush(usuario);
    }

    public Usuario encontrarUsuarioEmail(String email) {
        return repository.findByEmail(email).orElseThrow();
    }

    public Usuario salvarUsuarioOauth(UsuarioOAuth usuarioOAuth) {
        var usuarioToSave = builder.builderModelFromOauth(usuarioOAuth);
        var usuario = repository.saveAndFlush(usuarioToSave);
        return usuario;
    }
}
