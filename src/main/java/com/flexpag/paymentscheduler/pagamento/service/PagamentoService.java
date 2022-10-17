package com.flexpag.paymentscheduler.pagamento.service;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flexpag.paymentscheduler.pagamento.builder.PagamentoBuilder;
import com.flexpag.paymentscheduler.pagamento.enums.EnumStatusPagamento;
import com.flexpag.paymentscheduler.pagamento.model.Pagamento;
import com.flexpag.paymentscheduler.pagamento.model.PagamentoDto;
import com.flexpag.paymentscheduler.pagamento.repository.PagamentoRepository;

@Service
@Transactional
public class PagamentoService {

    @Autowired
    PagamentoBuilder builder;

    @Autowired
    PagamentoRepository repository;
    
    public List<Pagamento> listarPagamentoGERAl() {
        return repository.findAll();
    }
 
    public List<PagamentoDto> listarPagamento() {
        List<PagamentoDto> listaPagamentoDtos = new ArrayList<PagamentoDto>();

        repository.findAll().forEach(Pagamento -> {
            listaPagamentoDtos.add(builder.builderDto(Pagamento));
        });
        
        return listaPagamentoDtos;
    }

    @Transactional
    public PagamentoDto salvar(PagamentoDto pagamentoDto) {
        var pagamento = builder.builderModel(pagamentoDto);
        var pagamentoSalvo = builder.builderDto(repository.save(pagamento));
        return pagamentoSalvo;
    }

    public PagamentoDto encontrarPagamento(Long idPagamento) {
        var pagamento = repository.findById(idPagamento).orElseThrow();
        return builder.builderDto(pagamento);
    }

    @Transactional
    public PagamentoDto alterar(Long idPagamento, PagamentoDto pagamentoDto) {
        pagamentoDto.setIdPagamento(idPagamento);
        var pagamento = builder.builderModel(pagamentoDto);
        return builder.builderDto(repository.save(pagamento));
    }

    @Transactional
    public void removerPagamento(Long id) {
        repository.deleteById(id);
    }

}
