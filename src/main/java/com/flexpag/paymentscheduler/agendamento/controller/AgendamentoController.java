package com.flexpag.paymentscheduler.agendamento.controller;

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
import com.flexpag.paymentscheduler.agendamento.model.AgendamentoDto;
import com.flexpag.paymentscheduler.agendamento.service.AgendamentoService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/agendamento")
public class AgendamentoController {

    @Autowired
    AgendamentoService agendamentoService;

    @GetMapping("/listar")
    public List<AgendamentoDto> listarAgendamento() {
        return agendamentoService.listarAgendamento();
    }

    @PostMapping("/salvar")
    public ResponseEntity<AgendamentoDto> salvarAgendamento(@RequestBody @Valid AgendamentoDto agendamentoDto) {
        var agendamento = agendamentoService.salvar(agendamentoDto);
        return ResponseEntity.ok(agendamento);
    }

    @GetMapping("/encontrar/{id}")
    public ResponseEntity<AgendamentoDto> buscarAgendamentoPorId(@PathVariable Long id) throws Exception {
        var agendamento = agendamentoService.encontrarAgendamento(id);
        return ResponseEntity.ok(agendamento);
    }

    @GetMapping("/encontrar/porUsuario/{id}")
    public ResponseEntity<List<AgendamentoDto>> buscarAgendamentoPorIdDoUsuario(@PathVariable Long id) throws Exception {
        var agendamentoDoUsuarioEspecifico = agendamentoService.retornaAgendamentoPorUsuarioEspecifico(id);
        return ResponseEntity.ok(agendamentoDoUsuarioEspecifico);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<AgendamentoDto> editarAgendamentoPorId(@PathVariable("id") Long id,
            @RequestBody @Valid AgendamentoDto agendamentoDto) throws Exception {
        var novoAgendamento = agendamentoService.alterar(id, agendamentoDto);
        return ResponseEntity.ok(novoAgendamento);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> removerAgendamentoPorId(@PathVariable Long id) throws Exception {
        agendamentoService.removerAgendamento(id); 
        return ResponseEntity.ok().build();
    }
}
