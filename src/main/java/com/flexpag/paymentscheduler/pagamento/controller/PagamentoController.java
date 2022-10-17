package com.flexpag.paymentscheduler.pagamento.controller;

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
import com.flexpag.paymentscheduler.pagamento.model.PagamentoDto;
import com.flexpag.paymentscheduler.pagamento.service.PagamentoService;

@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*" )
@RequestMapping(value = "/pagamento")
public class PagamentoController {
    
    @Autowired
    PagamentoService pagamentoService;
   
    @GetMapping("/listar")
    public List<PagamentoDto> listarPagamento() {
        return pagamentoService.listarPagamento();
    }

    @PostMapping("/salvar")
    public ResponseEntity<PagamentoDto> salvarPagamento(@RequestBody @Valid PagamentoDto pagamentoDto) {
        var pagamento = pagamentoService.salvar(pagamentoDto);
        return ResponseEntity.ok(pagamento);
    }

    @GetMapping("/encontrar/{id}")
    public ResponseEntity<PagamentoDto> buscarImovelPorId(@PathVariable Long id) throws Exception {
        var pagamento = pagamentoService.encontrarPagamento(id);
        return ResponseEntity.ok(pagamento);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<PagamentoDto> editarPagamentoPorId(@PathVariable("id") Long id, @RequestBody @Valid PagamentoDto pagamentoDto) throws Exception {
        var novoPagamento = pagamentoService.alterar(id, pagamentoDto);
        return ResponseEntity.ok(novoPagamento);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> removerPagamentoPorId(@PathVariable Long id) throws Exception {
        pagamentoService.removerPagamento(id);
        return ResponseEntity.ok().build();
    }
    
}
