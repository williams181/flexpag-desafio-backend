package com.flexpag.paymentscheduler.usuario.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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

import com.lowagie.text.DocumentException;

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
    
    


    @GetMapping(path="/pdf", produces="text/plain")
    public void exportPdf( HttpServletResponse response) throws DocumentException, IOException{
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=usuarios-" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        
        List<UsuarioDto> usuariosDto = service.listarUsuarios();
        
        UsuarioService exporter = new UsuarioService(usuariosDto);
        exporter.export(response);
        
        
    }
    
    
    
}
