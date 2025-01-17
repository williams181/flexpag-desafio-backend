package com.flexpag.paymentscheduler.pagamento.builder;

import org.springframework.stereotype.Component;
import com.flexpag.paymentscheduler.pagamento.model.Pagamento;
import com.flexpag.paymentscheduler.pagamento.model.PagamentoDto;
import com.flexpag.paymentscheduler.pagamento.model.PagamentoListaDto;

@Component
public class PagamentoBuilder {

    public PagamentoDto builderDto(Pagamento pagamento){
        return PagamentoDto.builder()
                .idPagamento(pagamento.getIdPagamento())
                .valorPagamento(pagamento.getValorPagamento())
                .statusPagamento(pagamento.getStatusPagamento())
                .build();
            }

    public Pagamento builderModel(PagamentoDto pagamentoDto){
        return Pagamento.builder()
        .idPagamento(pagamentoDto.getIdPagamento())
        .statusPagamento(pagamentoDto.getStatusPagamento())
        .valorPagamento(pagamentoDto.getValorPagamento())
        .build();
    }

    public PagamentoListaDto buiderPagamentoListagem(Pagamento pagamento) {
        return PagamentoListaDto.builder()
            .idPagamento(pagamento.getIdPagamento())
            .valorPagamento(pagamento.getValorPagamento())
            .statusPagamento(pagamento.getStatusPagamento())
            .build();
    }

  
}
