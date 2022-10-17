package com.flexpag.paymentscheduler.usuario.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.flexpag.paymentscheduler.exceptions.NegocioException;
import com.flexpag.paymentscheduler.usuario.model.UsuarioDto;
import com.flexpag.paymentscheduler.usuario.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*" )
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDto>> listarUsuarios() {
        var usuarioDtos = service.listarUsuarios();

        return ResponseEntity.ok(usuarioDtos);
    }

    @PostMapping("/salvar")
    public ResponseEntity<UsuarioDto> salvarUsuario(@RequestBody @Valid UsuarioDto usuario) throws NegocioException {
        var resultado = service.salvar(usuario);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/encontrar/{id}")
    public ResponseEntity<UsuarioDto> encontrarUsuario(@PathVariable("id") Long idUsuario) {
        var usuarioEncontrado = service.encontrarUsuario(idUsuario);
        return ResponseEntity.ok(usuarioEncontrado);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<UsuarioDto> editarUsuario(@PathVariable("id") Long id, @RequestBody @Valid UsuarioDto usuario)
            throws NegocioException {
        var resultado = service.alterar(id, usuario);
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<String> removeUsuarioId(@PathVariable("id") Long id) throws NegocioException {
        service.removerUsuario(id);
        return ResponseEntity.noContent().build();
    }
    
}
